package com.example.fragmentsharedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstFragment, secondFragment;
    TextView fragmentText;
    ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = findViewById(R.id.fragment1btn);
        secondFragment = findViewById(R.id.fragment2btn);
        fragmentText = findViewById(R.id.fragmentText);

        // ViewModel logic
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        viewModel.getSelectedItem().observe(this, item -> {
            fragmentText.setText(item);

        });

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frameLayout, fragment1.class, null).addToBackStack(null).commit();

        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.beginTransaction().replace(R.id.frameLayout, fragment1.class, null).addToBackStack(null).commit();
            }

        });
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.beginTransaction().replace(R.id.frameLayout, fragment2.class, null).addToBackStack(null).commit();
            }
        });
    }
}