package com.raintama.mvp_retrofit.connection;

import retrofit2.Call;
import retrofit2.Response;

public interface ConnectionManagerContract {
    void onSuccessResponse(Call call, Response response);

    void onFailedResponse(Call call, Response response, String message);

    void onFailure(Call call, String message);
}
