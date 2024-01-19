package com.example.jasmin1_19_2024exam.domain.repository;

import com.example.jasmin1_19_2024exam.data.data_source.remote.dto.ApiResponseDto;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import java.io.IOException;

public interface PayChatRepository {

    public ApiResponseDto saveApplicationDetails(
            Person person
    ) throws IOException;


    public ApiResponseDto getApplicantDetails(String applicantId) throws IOException;
    public ApiResponseDto getApplicantId(String email) throws IOException;
}
