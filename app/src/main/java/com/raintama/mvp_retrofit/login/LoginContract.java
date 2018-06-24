package com.raintama.mvp_retrofit.login;

import android.view.View;

import com.raintama.mvp_retrofit.contract.BaseViewContract;
import com.raintama.mvp_retrofit.presenter.BasePresenter;

public interface LoginContract {
    interface View extends BaseViewContract {
        void goToHome();
    }

    interface Presenter extends BasePresenter {
        void googleLogin(android.view.View view);
        void loginSuccess();
    }

    interface Interactor {
        void callLoginApi();
    }
}
