package com.example.car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {
    BottomNavigationView bnv;
    FirebaseUser user;
    FirebaseAuth mAuth;

    ImageView set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        set = findViewById(R.id.settings);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Settings.class));
            }
        });
        mAuth=FirebaseAuth.getInstance();
        bnv=findViewById(R.id.btonav);
        bnv.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        bnv.setSelectedItemId(R.id.home);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser==null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(), "welcome home", Toast.LENGTH_SHORT).show();
        }
    }
    Home firstFragment= new Home();
    historya secondFragment = new historya();



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
              // getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;

            case R.id.history:
                startActivity( new Intent(getApplicationContext(),historya.class));
                finish();
                return true;

            case R.id.profile:
                startActivity( new Intent(getApplicationContext(),MainActivity2.class));
                finish();
                return true;
        }
        return false;
    }
}