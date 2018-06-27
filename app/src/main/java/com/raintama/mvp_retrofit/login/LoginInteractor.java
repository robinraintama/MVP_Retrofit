package com.raintama.mvp_retrofit.login;

import com.raintama.mvp_retrofit.connection.ConnectionManagerContract;
import com.raintama.mvp_retrofit.connection.ConnectionManagerPresenter;
import com.raintama.mvp_retrofit.connection.User;

import retrofit2.Call;
import retrofit2.Response;

class LoginInteractor implements LoginContract.Interactor{

    private LoginContract.Presenter loginPresenter;
    ConnectionManagerPresenter connectionManagerPresenter;

    public LoginInteractor(LoginContract.Presenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        connectionManagerPresenter = new ConnectionManagerPresenter();
    }

    @Override
    public void callLoginApi(Call call) {
        connectionManagerPresenter.connect(call, new ConnectionManagerContract() {
            @Override
            public void onSuccessResponse(Call call, Response response) {
                User user = (User) response.body();
                loginPresenter.callLoginSuccess(user);
            }

            @Override
            public void onFailedResponse(Call call, Response response, String message) {
                loginPresenter.callLoginFailed(message);
            }

            @Override
            public void onFailure(Call call, String message) {
                loginPresenter.onNoConnection(call);
            }
        });
    }
}
