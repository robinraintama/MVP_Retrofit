package com.raintama.mvp_retrofit.connection;

import com.raintama.mvp_retrofit.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APICollections {
    @POST(ConstantConnection.URL_API.GOOGLE_LOGIN)
    Call<User> accountGoogleLogin(@Body Map<String, Object> body);
}
