package com.raintama.mvp_retrofit.connection;

public class ConstantConnection {

    public static final long TIMEOUT_CONNECTION = 15;

    public interface URL_API {
        String BASE_URL = "https://www.raintama.com";
        String GOOGLE_LOGIN = "GoogleSign";
    }

    public interface Result {
        String SUCCESS = "success";
        String FAILED = "failed";
    }

    public interface MainResponse {
        String STATUS = "status";
        String MESSAGE = "message";
        String TOKEN = "token";
    }

    public interface User {
        String EMAIL = "status";
        String NAME = "message";
        String AVATAR = "avatar";
        String PHONE = "phone";
    }

    public interface Error {
        String TAG_FAILED = "FAILED RESPONSE";
        String TAG_ERROR_CODE = "ERROR CODE";
        String TAG_FAILURE = "ON FAILURE";
    }
}
