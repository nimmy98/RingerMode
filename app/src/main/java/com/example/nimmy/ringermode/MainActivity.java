package com.example.nimmy.ringermode;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imBtnVibrate,imBtnSilent,imBtnNormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControls();

        final AudioManager audioManager = (AudioManager)getSystemService(getApplicationContext().AUDIO_SERVICE);

        imBtnVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                resetUI(1);
                Toast.makeText(MainActivity.this,"Now in Vibrate Mode",Toast.LENGTH_SHORT).show();
            }
        });
            imBtnSilent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    resetUI(2);
                    Toast.makeText(MainActivity.this,"Now in Silent Mode",Toast.LENGTH_SHORT).show();
                }
            });
        imBtnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                resetUI(3);
                Toast.makeText(MainActivity.this,"Now in Ringing Mode",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initializeControls()
    {
        imBtnVibrate = (ImageButton) findViewById(R.id.imBtnVibrate);
        imBtnSilent = (ImageButton) findViewById(R.id.imBtnSilent);
        imBtnNormal = (ImageButton) findViewById(R.id.imBtnNormal);

    }
    private void resetUI(int i)
    {
        if(i==1)imBtnVibrate.setImageResource(R.drawable.vibrate);
        else imBtnVibrate.setImageResource(R.drawable.vibrate);
        if(i==2)imBtnSilent.setImageResource(R.drawable.silent);
        else imBtnSilent.setImageResource(R.drawable.silent);
        if(i==3)imBtnNormal.setImageResource(R.drawable.ringing);
        else imBtnNormal.setImageResource(R.drawable.ringing);
    }

}
