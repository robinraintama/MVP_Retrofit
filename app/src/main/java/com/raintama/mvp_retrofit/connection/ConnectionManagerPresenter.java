package com.raintama.mvp_retrofit.connection;

import android.util.Log;

import com.raintama.mvp_retrofit.MyApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionManagerPresenter {
    private Call mCall;
    private ConnectionManagerContract connectionManagerContract;

    public void connect(Call mCall, ConnectionManagerContract connectionManagerContract) {
        this.mCall = mCall;
        this.connectionManagerContract = connectionManagerContract;

        callAPIRequest();
    }

    public void callAPIRequest() {

        mCall.clone().enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.isSuccessful()) { //ONLY FOR RESPONSE CODE 200
                    System.out.println("Response success");
                    MainResponse mainResponse = (MainResponse) response.body();
                    String status, message;

                    status = mainResponse.getStatus();
                    message = mainResponse.getMessage();

                    if(status.equals(ConstantConnection.Result.SUCCESS)) {

                        String accessToken = mainResponse.getAccessToken();
                        if(accessToken != null) {
                            MyApplication.getInstance().setAccessToken(accessToken);
                        }

                        connectionManagerContract.onSuccessResponse(call, response);

                    } else if(status.equals(ConstantConnection.Result.FAILED)) {
                        Log.e(ConstantConnection.Error.TAG_FAILED, message);
                        connectionManagerContract.onFailedResponse(call, response, message);
                    }

                } else { // OTHER RESPONSE CODE SUCH AS 400 , 500
                    Log.e(ConstantConnection.Error.TAG_ERROR_CODE, String.valueOf(response.code()));
                    connectionManagerContract.onFailedResponse(call, response, String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(ConstantConnection.Error.TAG_FAILURE, t.getMessage());
                connectionManagerContract.onFailure(call, t.getMessage());
            }
        });
    }
}
