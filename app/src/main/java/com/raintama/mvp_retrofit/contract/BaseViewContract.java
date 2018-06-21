package com.raintama.mvp_retrofit.contract;

public interface BaseViewContract {
    //ERROR DIALOG
    void showServerErrorDialog();

    //PROGRESS DIALOG
    void showProgressDialog();
    void dismissProgressDialog();
}
