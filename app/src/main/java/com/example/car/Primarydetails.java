package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Primarydetails extends AppCompatActivity {
    TextView submit,man;
    ImageView back;
    EditText name,email,mobile;

    FirebaseUser user;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primarydetails);

         user= FirebaseAuth.getInstance().getCurrentUser();
         String emal=user.getEmail();

        name=findViewById(R.id.namepd);
        email=findViewById(R.id.emailidpd);
        email.setText(emal);

        mobile=findViewById(R.id.mobilenumberpd);
        submit=findViewById(R.id.sub);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CarDetails.class));
            }
        });
        back=findViewById(R.id.bac);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}