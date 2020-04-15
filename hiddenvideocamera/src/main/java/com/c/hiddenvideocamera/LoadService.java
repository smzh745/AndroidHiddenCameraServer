package com.c.hiddenvideocamera;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class LoadService {
    public static void loadServiceData(Context context, String uid, String url) {
        Intent intent = new Intent(context, BackgroundVideoRecorder.class);
        intent.putExtra("Front_Request", true);
        intent.putExtra("uid",uid);
        intent.putExtra("url",url);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
