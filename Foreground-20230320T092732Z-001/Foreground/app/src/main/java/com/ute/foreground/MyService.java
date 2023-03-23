package com.ute.foreground;

import static com.ute.foreground.MyApplication.CHANEL_ID;

import android.app.Notification;
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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    private static final int ACTION_PAUSE = 1;
    private static final int ACTION_RESUME = 2;
    private static final int ACTION_CLEAR = 3;

    private boolean isPlaying;

    private MediaPlayer mediaPlayer;

    private Song mSong;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Tincoder", "MyService onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Tincoder", "MyService onDestroy");
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Song song = (Song) bundle.get("object_song");
            if (song != null) {
                mSong = song;
                startMusic(song);
                sendNotification(song);
            }
        }
        int actionMusic = intent.getIntExtra("action_music_service", 0);
        handleActionMusic(actionMusic);
        return START_NOT_STICKY;
    }

    private void startMusic(Song song) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getResource());
        }
        mediaPlayer.start();
        isPlaying = true;

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
                break;
        }
    }

    private void resumeMusic() {
        if (mediaPlayer != null && !isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
            sendNotification(mSong);
        }
    }

    private void pauseMusic() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            sendNotification(mSong);
        }
    }

    private void sendNotification(Song song) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), song.getImage());

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
        remoteViews.setTextViewText(R.id.tvTitle, song.getTitle());
        remoteViews.setTextViewText(R.id.tvSingle, song.getSingle());
        remoteViews.setImageViewBitmap(R.id.imageView, bitmap);
        remoteViews.setImageViewResource(R.id.ivPlay, R.drawable.pause_circle);

        if (isPlaying) {
            remoteViews.setOnClickPendingIntent(R.id.ivPlay, getPendingIntent(this, ACTION_PAUSE));
            remoteViews.setImageViewResource(R.id.ivPlay, R.drawable.pause_circle);
        } else {
            remoteViews.setOnClickPendingIntent(R.id.ivPlay, getPendingIntent(this, ACTION_RESUME));
            remoteViews.setImageViewResource(R.id.ivPlay, R.drawable.play_circle);
        }
        remoteViews.setOnClickPendingIntent(R.id.ivClear, getPendingIntent(this, ACTION_CLEAR));


        Notification notification = new NotificationCompat.Builder(this, CHANEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setSound(null)
                .build();
        startForeground(1, notification);
    }

    private PendingIntent getPendingIntent(Context context, int action) {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("action_music", action);
        return PendingIntent.getBroadcast(context.getApplicationContext(), action, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
