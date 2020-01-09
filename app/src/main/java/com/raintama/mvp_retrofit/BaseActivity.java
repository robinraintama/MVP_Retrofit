package com.raintama.mvp_retrofit;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ProgressBar;

import com.raintama.mvp_retrofit.contract.BaseViewContract;
import com.raintama.mvp_retrofit.login.LoginActivity;

import retrofit2.Call;

public class BaseActivity extends AppCompatActivity implements BaseViewContract{
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO implement progress bar
    }

    @Override
    public void showServerErrorDialog(String message) {

    }

    @Override
    public void handleInvalidToken() {
        Utils.intentWithClearTask(this, LoginActivity.class);
        MyApplication.getInstance().setLogout();
    }

    public void logoutGoogle() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void retryDialog(Call call) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
