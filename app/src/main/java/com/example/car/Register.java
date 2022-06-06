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
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    ImageView back;

    EditText name,email,pass;

    TextView register, login;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name=findViewById(R.id.namer);
        email=findViewById(R.id.emailt);
        pass=findViewById(R.id.passt);
        back=findViewById(R.id.backs);

        //firebase instance creation

        mAuth=FirebaseAuth.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        login=findViewById(R.id.logn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });
        register=findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSignin();

               // startActivity(new Intent(getApplicationContext(),Primarydetails.class));
            }
        });
    }

    private void performSignin() {
        String  nam=name.getText().toString();
        String emial=email.getText().toString();
        String oass=pass.getText().toString();
        if(nam.isEmpty())
        {
            name.setError("enter the name");
        }
        else if(emial.isEmpty())
        {
            email.setError("enter the email id");
        }
        else if(!emial.matches(emailPattern))
        {
            email.setError("enter the correct Email-id");
        }
        else if(oass.isEmpty())
        {
            pass.setError("enter the password");
        }
        else if(oass.length()<8)
        {
            pass.setError("password must be more than 8 letters");
            pass.setText("");
        }
        else {
           connect();

        }
    }

    private void connect() {
            String emaila=email.getText().toString();
            String passs=pass.getText().toString();
            mAuth
                    .createUserWithEmailAndPassword(emaila, passs)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),
                                                "Registration successful!",
                                                Toast.LENGTH_LONG)
                                        .show();
                                // if the user created intent to login activity
                                Intent intent
                                        = new Intent(getApplicationContext(),Primarydetails.class);
                                //intent.putExtra("messageKey",name.getText().toString());
                                startActivity(intent);
                            }
                            if(task.isCanceled())
                            {


                                // Registration failed
                                Toast.makeText(
                                                getApplicationContext(),
                                                "Registration failed!!"
                                                        + " Please try again later",
                                                Toast.LENGTH_LONG)
                                        .show();


                            }
                        }
                    });

        }
    }