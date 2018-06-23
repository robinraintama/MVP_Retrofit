package com.raintama.mvp_retrofit;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raintama.mvp_retrofit.contract.BaseViewContract;
import com.raintama.mvp_retrofit.login.LoginActivity;

public class BaseActivity extends AppCompatActivity implements BaseViewContract{
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO implement progress bar
    }

    @Override
    public void handleInvalidToken() {
        Utils.intentWithClearTask(this, LoginActivity.class);
        MyApplication.getInstance().setLogout();
    }

    public void logoutGoogle() {

    }

    @Override
    public void showServerErrorDialog() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
