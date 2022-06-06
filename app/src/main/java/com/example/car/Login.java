package com.example.car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView log,sign;
    ImageView back;
    EditText emaill,passl;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emaill=findViewById(R.id.emailli);
        passl=findViewById(R.id.passli);
        mAuth=FirebaseAuth.getInstance();

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sign=findViewById(R.id.signin);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
                finish();
            }
        });
        log=findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performlogin();
            }
        });
    }

    private void performlogin() {
      String  emails=emaill.getText().toString();
      String pass=passl.getText().toString();

      if(emails.isEmpty())
      {
          emaill.setError("enter Email");
      }
      else if (!emails.matches(emailPattern)){
          emaill.setError("enter correct Email_id");
      }
      else if(pass.isEmpty())
      {
          passl.setError("enter passeord");
      }
      else if(pass.length()<8)
      {
          passl.setError("password should contain 8 letters");
          passl.setText("");
      }
      else {
          mAuth.signInWithEmailAndPassword(emails,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if (task.isSuccessful()) {
                      startActivity(new Intent(getApplicationContext(), HomePage.class));
                      passl.setText("");
                      emaill.setText("");

                      Toast.makeText(Login.this, "logged in", Toast.LENGTH_SHORT).show();
                      finish();
                  }
                  else {
                      Toast.makeText(Login.this, "cannot log in", Toast.LENGTH_SHORT).show();
                  }
              }
          });

      }
    }
}