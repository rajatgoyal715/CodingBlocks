package com.rajatgoyal.hw6_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    String KEY_VOLUME = "maxVolLevel";

    VolumeChangedReceiver vcr;
    IntentFilter vif;

    FrameLayout layout;
    EditText inputV;
    Button btnSave;

    static int volume;

    public static final String TAG = "volRcv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        layout = (FrameLayout)findViewById(R.id.layout);
        inputV = (EditText)findViewById(R.id.inputVolume);
        btnSave = (Button)findViewById(R.id.btnSave);

        volume = 0;

        SharedPreferences sharedPref = getSharedPreferences("broadcast_receivers", Context.MODE_PRIVATE);
        if(sharedPref != null)
            volume = sharedPref.getInt(KEY_VOLUME,0);

        inputV.setText(volume+"");

        vcr = new VolumeChangedReceiver();
        vif = VolumeChangedReceiver.getIntentFilter();

        vcr.setOnVolumeChangedListener(new VolumeChangedReceiver.OnVolumeChangedListener() {
            @Override
            public void onVolumeChanged(int volume) {
                if(volume>Integer.valueOf(inputV.getText().toString())){
                    layout.setBackgroundColor(Color.RED);
                }
                else{
                    layout.setBackgroundColor(Color.GREEN);
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                volume = Integer.parseInt(inputV.getText().toString());

                SharedPreferences sharedPref = getSharedPreferences("broadcast_receivers",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(KEY_VOLUME, Integer.parseInt(inputV.getText().toString()));
                editor.apply();
            }
        });
    }

    @Override
    protected void onPause() {
        unregisterReceiver(vcr);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(vcr,vif);
    }
}
