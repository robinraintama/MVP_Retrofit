package com.raintama.mvp_retrofit.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.R;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        
    }

    @Override
    public void goToHome() {

    }
}
