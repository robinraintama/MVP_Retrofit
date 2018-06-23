package com.raintama.mvp_retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class Utils {
    public static void intentWithClearTask(AppCompatActivity mActivity, Class<?> classDestination){
        if (mActivity != null){
            Intent intent = new Intent(mActivity, classDestination);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            mActivity.overridePendingTransition(0,0);
            mActivity.startActivity(intent);
        }
    }
}
