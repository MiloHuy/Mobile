package hcmute.edu.vn.broadcastcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("hcmute.edu.vn.EXAMPLE_ACTION");
        registerReceiver(exampleBroadcastReceiver,filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}