package com.example.jasmin1_19_2024exam.data.repository;

import android.util.Log;

import com.example.jasmin1_19_2024exam.data.api.PayChatService;
import com.example.jasmin1_19_2024exam.data.data_source.remote.dto.ApiResponseDto;
import com.example.jasmin1_19_2024exam.domain.repository.PayChatRepository;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PayChatRepositoryImpl implements PayChatRepository {

    private final PayChatService payChatService;

    public PayChatRepositoryImpl(PayChatService payChatService) {
        this.payChatService = payChatService;
    }

    @Override
    public  ApiResponseDto saveApplicationDetails(Person person) {
        Call<ApiResponseDto> call = payChatService.saveApplicantDetails(
                person.getFirstName(),
                person.getLastName(),
                person.getMiddleName(),
                person.getEmail(),
                person.getMobile(),
                "63",
                person.getBirthdate()
        );

        call.enqueue(new Callback<ApiResponseDto>() {
            @Override
            public void onResponse(Call<ApiResponseDto> call, Response<ApiResponseDto> response) {
                if (response.isSuccessful()) {
                    ApiResponseDto responseDto = response.body();
                    if (responseDto != null) {
                        Log.v("TAG", responseDto.toString());
                    } else {
                        Log.e("TAG", "Null response body");
                    }
                } else {
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("TAG", "API Error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponseDto> call, Throwable t) {
                Log.e("TAG", "Request failed: " + t.getMessage());
//                callback.onError("Request failed: " + t.getMessage());
            }
        });
        return new ApiResponseDto();
    }
    @Override
    public ApiResponseDto getApplicantDetails(String applicantId) throws IOException {
        return payChatService.getApplicantDetails(applicantId).execute().body();
    }

    @Override
    public ApiResponseDto getApplicantId(String email) throws IOException {
        return payChatService.getApplicantId(email).execute().body();
    }
}
