package com.raintama.mvp_retrofit.connection;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static OkHttpClient.Builder okHttpClientBuilder;
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;
    private static APICollections restApi;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ConstantConnection.URL_API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static APICollections retrofitRequest(){
        Log.i("RETROFIT", "REST API");
        if(okHttpClientBuilder == null) {
            okHttpClientBuilder = new OkHttpClient.Builder();
        }
        okHttpClientBuilder.readTimeout(ConstantConnection.TIMEOUT_CONNECTION, TimeUnit.SECONDS);
        okHttpClientBuilder.connectTimeout(ConstantConnection.TIMEOUT_CONNECTION, TimeUnit.SECONDS);
        okHttpClientBuilder.retryOnConnectionFailure(false);
        addInterceptorOkHTTP();

        if(okHttpClient==null) {
            okHttpClient = okHttpClientBuilder.build();
        }

        if(retrofit == null) {
            retrofit = builder.client(okHttpClient).build();
        }

        if(restApi == null) {
            restApi = retrofit.create(APICollections.class);
        }

        return restApi;
    }

    public static void addInterceptorOkHTTP(){
        if(okHttpClientBuilder==null){
            retrofitRequest();
            return;
        }
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request;
                request = original.newBuilder()
//                        .header("token", MyApplication.getInstance().getAccessToken())
//                        .header("User-Agent", "Android")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });
    }
}
