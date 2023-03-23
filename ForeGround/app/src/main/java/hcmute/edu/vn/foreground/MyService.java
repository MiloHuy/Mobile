package hcmute.edu.vn.foreground;

import static hcmute.edu.vn.foreground.MyApplication.Channel_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("HCMUTE","MyService onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String strDataIntent = intent.getStringExtra("key_data_intent");

        sendNotification(strDataIntent);

        return START_NOT_STICKY;
    }

    private void sendNotification(String strDataIntent) {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this,Channel_ID).
                                        setContentTitle("Title notification service example").
                                        setContentText(strDataIntent).
                                        setSmallIcon(R.drawable.ic_notification).
                                        setContentIntent(pendingIntent).
                                        build();
        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("HCMUTE","MyService onDestroy");
    }
}
