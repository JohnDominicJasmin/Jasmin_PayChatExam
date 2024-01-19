package com.example.jasmin1_19_2024exam.data.api;

import com.example.jasmin1_19_2024exam.data.data_source.remote.dto.ApiResponseDto;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface PayChatService {

    @POST("/save")
    @FormUrlEncoded
    Call<ApiResponseDto> saveApplicantDetails(
            @Field("fname") String firstName,
            @Field("lname") String lastName,
            @Field("mname") String middleName,
            @Field("email") String email,
            @Field("mobile") String mobileNumber,
            @Field("mobile_country_code") String mobileCountryCode,
            @Field("birth_date") String birthDate
    );

    @GET("/get")
    Call<ApiResponseDto> getApplicantDetails(@Query("applicant_id") String applicantId);


    @GET("/applicant_id")
    Call<ApiResponseDto > getApplicantId(@Query("email") String email);

}
