package com.raintama.mvp_retrofit.login;

import com.raintama.mvp_retrofit.connection.ConnectionManagerPresenter;

class LoginInteractor implements LoginContract.Interactor{

    private LoginContract.Presenter loginPresenter;
    ConnectionManagerPresenter connectionManagerPresenter;

    public LoginInteractor(LoginContract.Presenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        connectionManagerPresenter = new ConnectionManagerPresenter();
    }

    @Override
    public void callLoginApi() {
        loginPresenter.loginSuccess();
    }
}
