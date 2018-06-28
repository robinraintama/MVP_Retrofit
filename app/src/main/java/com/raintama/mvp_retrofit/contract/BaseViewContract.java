package com.raintama.mvp_retrofit.contract;

import retrofit2.Call;

public interface BaseViewContract {
    //ERROR DIALOG
    void showServerErrorDialog(String message);
    void handleInvalidToken();

    //PROGRESS DIALOG
    void showProgressDialog();
    void dismissProgressDialog();
    void retryDialog(Call call);
}
