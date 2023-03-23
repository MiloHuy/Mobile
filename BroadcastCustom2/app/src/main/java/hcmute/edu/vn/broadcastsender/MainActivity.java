package hcmute.edu.vn.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

    }
    private void SendBroadcast(View v)
    {
        Intent intent = new Intent("hcmute.edu.vn.EXAMPLE_ACTION");
        intent.putExtra("hcmute.edu.vn.EXTRA_TEXT","Broadcast Received");
        sendBroadcast(intent);
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receiveText = intent.getStringExtra("hcmute.edu.vn.EXTRA_TEXT");
            textView.setText(receiveText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("hcmute.edu.vn.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}