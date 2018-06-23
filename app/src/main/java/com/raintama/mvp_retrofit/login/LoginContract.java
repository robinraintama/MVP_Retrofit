package com.raintama.mvp_retrofit.login;

import com.raintama.mvp_retrofit.contract.BaseViewContract;
import com.raintama.mvp_retrofit.presenter.BasePresenter;

public interface LoginContract {
    interface View extends BaseViewContract {
        void goToHome();
    }

    interface Presenter extends BasePresenter {
        void validation();
        void loginSuccess();
    }

    interface Interactor {
        void callLoginApi();
    }
}
