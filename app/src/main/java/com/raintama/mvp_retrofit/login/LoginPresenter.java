package com.raintama.mvp_retrofit.login;

import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.connection.RetrofitService;
import com.raintama.mvp_retrofit.connection.User;

import java.util.HashMap;

import retrofit2.Call;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractor(this);
    }

    @Override
    public void permissionGoogle() {
        loginView.googleAPIClientBuild();
    }

    @Override
    public void googleLogin(View view) {
        loginView.doSignInGoogleView();
    }

    @Override
    public void handleSignInGoogle(GoogleSignInResult result) {
        if (result.isSuccess())loginView.signInGoogleSuccess(result);
        else loginView.signInGoogleFailed(result);
    }

    @Override
    public void accountGoogleLogin(final GoogleSignInAccount account) {
        loginView.showProgressDialog();

        Call call = RetrofitService.retrofitRequest().googleLogin(new HashMap<String, Object>(){{
            put("GOOGLE_TOKEN", account.getIdToken());
        }});
        loginInteractor.callLoginApi(call);
    }

    @Override
    public void callLoginSuccess(User user) {
        loginView.dismissProgressDialog();
        loginView.loginSuccess(user);
    }

    @Override
    public void callLoginFailed(String message) {
        loginView.dismissProgressDialog();
        loginView.showServerErrorDialog(message);
    }

    @Override
    public void onNoConnection(Call call) {
        loginView.dismissProgressDialog();
        loginView.retryDialog(call);
    }
}
