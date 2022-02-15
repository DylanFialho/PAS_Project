package com.example.pas_project.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse extends User{

    @SerializedName("message")
    private String errorMessage;


    public UserResponse(long id, String password, String email, String errorMessage) {
        super(id, password, email);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
