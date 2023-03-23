package hcmute.edu.vn.foreground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText edtDataIntent;
    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDataIntent = (EditText) findViewById(R.id.edt_data_intent);
        btnStartService = (Button)findViewById(R.id.btn_start_service);
        btnStopService = (Button) findViewById(R.id.btn_stop_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService();
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService();
            }
        });


    }

    private void clickStartService() {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("key_data_intent",edtDataIntent.getText().toString().trim());
        startService(intent);
    }
    private void clickStopService() {
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }
}