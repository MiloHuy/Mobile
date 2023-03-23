package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Activity Life Cycle","On Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity Life Cycle","On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity Life Cycle","On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity Life Cycle","On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activity Life Cycle","On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activity Life Cycle","On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Activity Life Cycle","On Restart");
    }
}