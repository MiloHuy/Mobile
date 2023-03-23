package hcmute.edu.vn.service2;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

public class MyApplication extends Application {

    public static final String Channel_id = "Channel_Service_Example";
    @Override
    public void onCreate() {
        super.onCreate();
        createChannelNotification();
    }

    private void createChannelNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(Channel_id,
                                        "Channel Service",
                                        NotificationManager.IMPORTANCE_DEFAULT);
            channel.setSound(null,null);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager != null)
            {
                manager.createNotificationChannel(channel);
            }
        }
    }
}
