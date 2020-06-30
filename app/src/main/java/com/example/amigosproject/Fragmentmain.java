package com.example.amigosproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragmentmain extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentmain);

        bottomNav = findViewById(R.id.nav_bottom_id);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        //default fragment display garcha
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, new Home()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home_id:
                    selectedFragment = new Home();
                    break;
                case R.id.category_id:
                   selectedFragment =new Category();
                    break;
                case R.id.about_id:
                    selectedFragment=new UploadFile();
                    break;
                case R.id.account_id:
                    selectedFragment=new EditProfile();

            }
            // aba fragment lai display garnay code
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_id, selectedFragment).commitAllowingStateLoss();
            return true;
        }
    };
}
