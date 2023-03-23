package hcmute.edu.vn.service2;

import static hcmute.edu.vn.service2.MyApplication.Channel_id;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyService extends Service {
    public static final int ACTION_PAUSE = 1;
    public static final int ACTION_RESUME = 2;
    public static final int ACTION_CLEAR = 3;

    public static final int ACTION_START = 4;


    private boolean isPlaying;
    private Song mSong;
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
                mSong = song;
                startMusic(song);
                sendNotification(song);
            }
        }
        int actionMusic = intent.getIntExtra("action_music_service", 0);
        handleActionMusic(actionMusic);
        return START_NOT_STICKY;

    }

    private void handleActionMusic(int action) {
        switch (action) {
            case ACTION_PAUSE:
                pauseMusic();
                break;
            case ACTION_RESUME:
                resumeMusic();
                break;
            case ACTION_CLEAR:
                stopSelf();
                sendActionToActivity(ACTION_CLEAR);
                break;
        }
    }
    private void resumeMusic() {
        if (mediaPlayer != null && !isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
            sendNotification(mSong);
            sendActionToActivity(ACTION_RESUME);
        }
    }

    private void pauseMusic() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            sendNotification(mSong);
            sendActionToActivity(ACTION_PAUSE);
        }

    }


    private void startMusic(Song song) {
        if(mediaPlayer == null)
        {
            mediaPlayer = MediaPlayer.create(getApplicationContext(),song.getResource());
        }
        mediaPlayer.start();
        isPlaying = true;
        sendActionToActivity(ACTION_START);
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


        if (isPlaying) {
            remoteView.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_PAUSE));
            remoteView.setImageViewResource(R.id.img_play_or_pause, R.drawable.pause);
        } else {
            remoteView.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this, ACTION_RESUME));
            remoteView.setImageViewResource(R.id.img_play_or_pause, R.drawable.play);
        }
        remoteView.setOnClickPendingIntent(R.id.img_clear, getPendingIntent(this, ACTION_CLEAR));


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

    private PendingIntent getPendingIntent(Context context, int action) {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("action_music", action);
        return PendingIntent.getBroadcast(context.getApplicationContext(), action, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void sendActionToActivity(int action)
    {
        Intent intent = new Intent("send_data_to_activity");

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song",mSong);
        bundle.putBoolean("status_player",isPlaying);
        bundle.putInt("action_music",action);

        intent.putExtras(bundle);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);


    }
}
