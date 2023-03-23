package hcmute.edu.vn.service2;

import static hcmute.edu.vn.service2.MyApplication.Channel_id;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("HCMUTE", "MyService OnCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if(bundle != null)
        {
            Song song = (Song)bundle.get("object_song");
            if(song != null)
            {
                startMusic(song);
                sendNotification(song);
            }
        }
        return START_NOT_STICKY;

    }

    private void startMusic(Song song) {
        if(mediaPlayer == null)
        {
            mediaPlayer = MediaPlayer.create(getApplicationContext(),song.getResource());
        }
        mediaPlayer.start();
    }

    private void sendNotification(Song song) {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,
                                                                intent,PendingIntent.FLAG_UPDATE_CURRENT);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),song.getImage());

        RemoteViews remoteView = new RemoteViews(getPackageName(),R.layout.custom_layout);
        remoteView.setTextViewText(R.id.textview_title,song.getTitle());
        remoteView.setTextViewText(R.id.textview_sing_song,song.getSingle());
        remoteView.setImageViewBitmap(R.id.img_song,bitmap);
        remoteView.setImageViewResource(R.id.img_play_or_pause,R.drawable.pause);


        Notification notification = new NotificationCompat.Builder(this,Channel_id).
                setSmallIcon(R.drawable.notification).
                setContentIntent(pendingIntent).
                setCustomContentView(remoteView).
                setSound(null).
                build();
        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("HCMUTE","My Service Stop");
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
