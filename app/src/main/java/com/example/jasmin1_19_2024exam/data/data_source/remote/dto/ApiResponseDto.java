package com.example.jasmin1_19_2024exam.data.data_source.remote.dto;

import com.google.gson.annotations.SerializedName;

public class ApiResponseDto {

    @SerializedName("status")
    private boolean status;

    @SerializedName("code")
    private int code;

    @SerializedName("results")
    private ApiResults results;

    public boolean isStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public ApiResults getResults() {
        return results;
    }
}

