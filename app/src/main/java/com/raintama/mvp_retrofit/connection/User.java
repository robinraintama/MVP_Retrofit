package com.raintama.mvp_retrofit.connection;

import com.google.gson.annotations.SerializedName;


public class User extends MainResponse {
    @SerializedName(ConstantConnection.User.NAME)
    String name;

    @SerializedName(ConstantConnection.User.EMAIL)
    String email;

    @SerializedName(ConstantConnection.User.AVATAR)
    String avatar;

    @SerializedName(ConstantConnection.User.PHONE)
    String phone;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {return avatar;}

    public String getPhone(){return  phone;}
}
