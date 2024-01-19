package com.example.jasmin1_19_2024exam.data.data_source.remote.dto;

import com.google.gson.annotations.SerializedName;

class ApiResults {

    @SerializedName("data")
    private Object data;

    @SerializedName("message")
    private String message;

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
