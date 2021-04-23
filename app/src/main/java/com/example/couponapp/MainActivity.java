package com.example.couponapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.action_home:
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_compose:
                    Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_profile:
                default:
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    break;
            }
            // fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;
        });
        bottomNavigation.setSelectedItemId(R.id.action_home);
    }
}