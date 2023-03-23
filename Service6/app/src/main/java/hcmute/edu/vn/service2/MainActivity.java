package hcmute.edu.vn.service2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LocalActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
public class MainActivity extends AppCompatActivity {
    private Button btnStartService;
    private Button btnStopService;

    private RelativeLayout layoutBottom;
    private ImageView img_song,img_play_or_pause,img_clear;
    private TextView textview_title,textview_sing_song;
    private Song mySong;
    private boolean isPlaying;



    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if(bundle == null)
            {
                return;
            }
            mySong = (Song) bundle.get("object_song");
            isPlaying = bundle.getBoolean("status_player");
            int actionMusic = bundle.getInt("action_music");
            handLayoutMusic(actionMusic);
        }
    };

    private void handLayoutMusic(int action) {
        switch (action) {
            case MyService.ACTION_START:
                layoutBottom.setVisibility(View.VISIBLE);
                showInforSong();
                setStatusButtonPlayorPause();
                break;
            case MyService.ACTION_PAUSE:
                setStatusButtonPlayorPause();
                break;
            case MyService.ACTION_RESUME:
                setStatusButtonPlayorPause();
                break;
            case MyService.ACTION_CLEAR:
                layoutBottom.setVisibility(View.GONE);
                break;
        }
    }

    private void showInforSong()
    {
        if(mySong == null)
        {
            return;
        }
        img_song.setImageResource(mySong.getImage());
        textview_title.setText(mySong.getTitle());
        textview_sing_song.setText(mySong.getSingle());

        img_play_or_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying)
                {
                    sendActionToService(MyService.ACTION_PAUSE);
                }
                else {
                    sendActionToService(MyService.ACTION_RESUME);
                }
            }
        });
        img_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendActionToService(MyService.ACTION_CLEAR);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,new IntentFilter("send_data_to_activity"));


        btnStartService = (Button) findViewById(R.id.btn_start_service);
        btnStopService = (Button) findViewById(R.id.btn_stop_service);

        layoutBottom = (RelativeLayout) findViewById(R.id.layout_bottom);
        img_song =(ImageView)findViewById(R.id.img_song);
        img_play_or_pause =(ImageView)findViewById(R.id.img_play_or_pause);
        img_clear =(ImageView)findViewById(R.id.img_clear);
        textview_title = (TextView)findViewById(R.id.textview_title);
        textview_sing_song = (TextView)findViewById(R.id.textview_sing_song);

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

    private void clickStopService() {
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }

    private void clickStartService() {
        Song song = new Song("MapSoSa","G-Dragon",R.drawable.mapsosa,R.raw.mapsosa);

        Intent intent = new Intent(this,MyService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song",song);
        intent.putExtras(bundle);

        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
    private void setStatusButtonPlayorPause(){
        if(isPlaying)
        {
            img_play_or_pause.setImageResource(R.drawable.pause);
        }
        else{
            img_play_or_pause.setImageResource(R.drawable.play);
        }
    }
    private void sendActionToService(int action)
    {
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("action_music_service",action);

        startService(intent);
    }
}