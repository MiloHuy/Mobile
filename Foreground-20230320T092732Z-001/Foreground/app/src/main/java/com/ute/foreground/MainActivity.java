package com.ute.foreground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btStartService;
    private Button btStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStartService = findViewById(R.id.btStartService);
        btStopService = findViewById(R.id.btStopService);
        btStartService.setOnClickListener(view -> clickStartService());
        btStopService.setOnClickListener(view -> clickStopService());
    }

    private void clickStartService() {
        Song song = new Song("Big city boy", "Tincoder", R.drawable.img, R.raw.file_example);
        Intent intent = new Intent(this, MyService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", song);
        intent.putExtras(bundle);
        startService(intent);
    }

    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}