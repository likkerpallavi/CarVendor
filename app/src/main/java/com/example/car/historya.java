package com.example.car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class historya extends AppCompatActivity {

    BottomNavigationView bota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historya);
        bota=findViewById(R.id.btonagv);
        bota.setSelectedItemId(R.id.history);
        bota.setOnNavigationItemSelectedListener(this::setOnNavigationItemSelectedListener);
    }
    public boolean setOnNavigationItemSelectedListener(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                finish();

                return true;

            case R.id.history:
               // startActivity(new Intent(getApplicationContext(), historya.class));

                return true;

            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
        }
                return true;
        }

}