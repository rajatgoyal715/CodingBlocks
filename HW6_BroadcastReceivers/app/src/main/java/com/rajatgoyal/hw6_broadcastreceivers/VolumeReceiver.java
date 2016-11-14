package com.rajatgoyal.hw6_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class VolumeReceiver extends BroadcastReceiver {
    public static final String TAG = "volRcv";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG,"onReceive: ");
        int volume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
        Log.d(TAG, "volume: " + volume);

        SharedPreferences sharedPref = context.getSharedPreferences("broadcast_receivers", Context.MODE_PRIVATE);
        int volLevel = sharedPref.getInt("maxVolLevel",0);

        Toast.makeText(context, "Volume : " + volume + "\nVolumeLevel : " + volLevel, Toast.LENGTH_SHORT).show();

        if(volume>volLevel){
            Log.d(TAG,"open activity: ");
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
