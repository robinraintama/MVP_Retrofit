package com.raintama.mvp_retrofit.login;

import android.os.Bundle;

import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.R;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public void goToHome() {

    }
}
