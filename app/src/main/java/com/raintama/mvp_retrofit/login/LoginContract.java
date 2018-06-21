package com.raintama.mvp_retrofit.login;

import com.raintama.mvp_retrofit.contract.BaseViewContract;

public interface LoginContract {
    interface View extends BaseViewContract {
        void goToHome();
    }

    interface Presenter {
        void callLoginApi();

    }
}
