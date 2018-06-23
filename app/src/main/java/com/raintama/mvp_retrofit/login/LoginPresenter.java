package com.raintama.mvp_retrofit.login;

import com.raintama.mvp_retrofit.BaseActivity;
import com.raintama.mvp_retrofit.presenter.BasePresenter;

import retrofit2.Call;

public class LoginPresenter extends BaseActivity implements LoginContract.Presenter {
    private LoginContract.View loginView;
    private LoginInteractor loginInteractor;
    private String validEmail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validation() {

    }

    @Override
    public void loginSuccess() {
        loginView.goToHome();
    }

    @Override
    public void onNoConnection(Call call) {

    }
}
