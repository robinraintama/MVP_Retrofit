package com.raintama.mvp_retrofit.connection;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APICollections {
    @POST(ConstantConnection.URL_API.GOOGLE_LOGIN)
    Call<User> googleLogin(@Body Map<String, Object> body);
}
