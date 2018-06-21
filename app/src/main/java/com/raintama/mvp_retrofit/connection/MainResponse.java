package com.raintama.mvp_retrofit.connection;

import com.google.gson.annotations.SerializedName;

public class MainResponse {

    @SerializedName(ConstantConnection.MainResponse.STATUS)
    String status;

    @SerializedName(ConstantConnection.MainResponse.MESSAGE)
    String message;

    @SerializedName(ConstantConnection.MainResponse.TOKEN)
    String accessToken;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
