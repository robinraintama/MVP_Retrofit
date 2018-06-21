package com.raintama.mvp_retrofit.presenter;

import retrofit2.Call;

public interface BasePresenter {
    void onNoConnection(Call call);
}
