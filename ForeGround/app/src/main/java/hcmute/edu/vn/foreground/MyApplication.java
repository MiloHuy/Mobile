package hcmute.edu.vn.foreground;


import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {

    public static final String Channel_ID = "Channel_Service_Example";


    @Override
    public void onCreate() {
        super.onCreate();
        createChannelNotification();
    }

    private void createChannelNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(Channel_ID,"Channel Service Example",
                                                                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if(manager != null){
                manager.createNotificationChannel(channel);
            }
        }
    }
}
