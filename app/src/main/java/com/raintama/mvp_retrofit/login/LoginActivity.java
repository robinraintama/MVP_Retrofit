package com.raintama.mvp_retrofit.login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.R;
import com.raintama.mvp_retrofit.connection.User;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public void askPermission() {

    }

    @Override
    public void googleAPIClientBuild() {

    }

    @Override
    public void googleSignIn() {
    }

    @Override
    public void doSignInGoogleView() {

    }

    @Override
    public void signInGoogleSuccess(GoogleSignInResult result) {

    }

    @Override
    public void signInGoogleFailed(GoogleSignInResult result) {

    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public void goToHome() {

    }

    @Override
    public void showSnackBar(String message) {

    }
}
