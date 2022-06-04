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

public class MainActivity2 extends AppCompatActivity {
 BottomNavigationView bat,bot;
 ImageView logout;

 FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout=findViewById(R.id.logoutp);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        bat=findViewById(R.id.btonav);
        bot=findViewById(R.id.btona);
        bot.setOnNavigationItemSelectedListener(this::setOnNavigationItemSelectedListener);
        bat.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        bat.setSelectedItemId(R.id.profile);
        bot.setSelectedItemId(R.id.personal_details);
    }
   // Home firstFragment= new Home();
    //history secondFragment = new history();
    personalretrive frag= new personalretrive();
    carreterival frags=new carreterival();



    public boolean setOnNavigationItemSelectedListener(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.personal_details:
                getSupportFragmentManager().beginTransaction().replace(R.id.cost, frag).commit();
                return true;

            case R.id.Car_details:
                getSupportFragmentManager().beginTransaction().replace(R.id.cost, frags).commit();
                return true;
        }
        return false;

    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();

                return true;

            case R.id.history:
                startActivity(new Intent(getApplicationContext(),historya.class));
                finish();
                return true;

            case R.id.profile:
                //Toast.makeText(this, "you are in profile page", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}