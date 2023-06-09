package com.ute.project2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity implements BottomNavigationListener {
    BottomNavigationView bottomNavigationView;
    BottomNavigationManager bottomNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_search, new ResultQueryFragment()).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation_search);
        bottomNavigationManager = new BottomNavigationManager(this, bottomNavigationView);
    }

    @Override
    public void onBottomNavigationItemSelected(int itemId) {
        Fragment selectedFragment = null;
        if (itemId == R.id.search) {
            selectedFragment = new SearchFragment();
        } else if (itemId == R.id.yourLibrary) {
            selectedFragment = new YourLibraryFragment();
        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_search, selectedFragment).commit();
        }
    }
}