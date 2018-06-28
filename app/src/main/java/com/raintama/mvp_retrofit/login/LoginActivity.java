package com.raintama.mvp_retrofit.login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.MyApplication;
import com.raintama.mvp_retrofit.R;
import com.raintama.mvp_retrofit.connection.User;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    private LoginPresenter presenter;
    private static final int GOOGLE_SIGN_IN_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        presenter = new LoginPresenter(this);

        askPermission();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            presenter.handleSignInGoogle(result);
        }
    }

    @Override
    public void askPermission() {
        presenter.permissionGoogle();
    }

    @Override
    public void googleAPIClientBuild() {
        // TODO setup client build
    }

    @Override
    public void googleSignIn() {
        // TODO remind myself, why it is here?
    }

    @Override
    public void doSignInGoogleView() {
        // TODO show google signin view
    }

    @Override
    public void signInGoogleSuccess(GoogleSignInResult result) {
        presenter.accountGoogleLogin(result.getSignInAccount());
    }

    @Override
    public void signInGoogleFailed(GoogleSignInResult result) {
        showServerErrorDialog(result.getStatus().getStatusMessage());
    }

    @Override
    public void loginSuccess(User user) {
        MyApplication.getInstance().setAccessToken(user.getAccessToken());
        goToHome();
    }

    @Override
    public void goToHome() {
        // TODO intent to home activity
    }
}
