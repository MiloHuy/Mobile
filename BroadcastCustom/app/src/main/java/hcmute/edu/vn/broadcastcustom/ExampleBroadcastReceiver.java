package hcmute.edu.vn.broadcastcustom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("hcmute.edu.vn.EXAMPLE_ACTION".equals(intent.getAction()))
        {
            String receiver = intent.getStringExtra("hcmute.edu.vn.EXTRA_TEXT");
            Toast.makeText(context,receiver,Toast.LENGTH_SHORT).show();
        }
    }
}
