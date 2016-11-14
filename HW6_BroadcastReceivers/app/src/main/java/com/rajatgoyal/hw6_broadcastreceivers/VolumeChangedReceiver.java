package com.rajatgoyal.hw6_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by rajat goyal on 9/18/2016.
 */

public class VolumeChangedReceiver  extends BroadcastReceiver {

    private OnVolumeChangedListener ovcl;

    public interface OnVolumeChangedListener {
        void onVolumeChanged(int volume);
    }

    public void setOnVolumeChangedListener(OnVolumeChangedListener listener) {
        ovcl = listener;
    }

    public static IntentFilter getIntentFilter() {
        IntentFilter vif = new IntentFilter();
        vif.addAction("android.media.VOLUME_CHANGED_ACTION");
        return vif;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            int volume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
            if(ovcl!=null)
                ovcl.onVolumeChanged(volume);
        }
    }
}
