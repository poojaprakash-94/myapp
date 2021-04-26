package com.example.myapp.models;

import com.google.gson.annotations.SerializedName;

public class ApiError {

    @SerializedName("error")
    private String error;
    @SerializedName("status")
    private int status;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
