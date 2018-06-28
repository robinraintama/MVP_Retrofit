package com.raintama.mvp_retrofit.login;

import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.raintama.mvp_retrofit.connection.User;
import com.raintama.mvp_retrofit.contract.BaseViewContract;
import com.raintama.mvp_retrofit.presenter.BasePresenter;

import retrofit2.Call;

public interface LoginContract {
    interface View extends BaseViewContract {
        void askPermission();
        void googleAPIClientBuild();
        void googleSignIn();
        void doSignInGoogleView();
        void signInGoogleSuccess(GoogleSignInResult result);
        void signInGoogleFailed(GoogleSignInResult result);
        void loginSuccess(User user);
        void goToHome();
    }

    interface Presenter extends BasePresenter {
        void permissionGoogle();
        void googleLogin(android.view.View view);
        void handleSignInGoogle(GoogleSignInResult result);
        void accountGoogleLogin(GoogleSignInAccount account);
        void callLoginSuccess(User user);
        void callLoginFailed(String message);
    }

    interface Interactor {
        void callLoginApi(Call call);
    }
}
