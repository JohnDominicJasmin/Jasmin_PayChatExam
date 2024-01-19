package com.example.jasmin1_19_2024exam.presentation;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.jasmin1_19_2024exam.data.data_source.remote.dto.ApiResponseDto;
import com.example.jasmin1_19_2024exam.di.PayChatModule;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;
import com.example.jasmin1_19_2024exam.utils.ValidationUtils;

public class FriendViewModel extends ViewModel {




    public void saveApplicationDetails(Person person) {

        if (!ValidationUtils.isValidName(person.getFirstName())) {
            Log.v("TAG", "Invalid First Name");
            return;
        }

        if (!ValidationUtils.isValidName(person.getLastName())) {
            Log.v("TAG", "Invalid Last Name");
            return;
        }

        if (!ValidationUtils.isValidName(person.getMiddleName())) {
            Log.v("TAG", "Invalid Middle Name");
            return;
        }

        if (!ValidationUtils.isValidEmail(person.getEmail())) {
            Log.v("TAG", "Invalid Email");
            return;
        }

        if (!ValidationUtils.isValidMobile(person.getMobile())) {
            Log.v("TAG", "Invalid Mobile");
            return;
        }

        if (!ValidationUtils.isValidMobile(person.getMobile())) {
            Log.v("TAG", "Invalid Mobile");
            return;
        }

        if (!ValidationUtils.isValidBirthDate(person.getBirthdate())) {
            Log.v("TAG", "Invalid Birthdate");
            return;
        }

        new Thread(() -> {
            try {
                ApiResponseDto responseDto = PayChatModule.providePayChatRepository().saveApplicationDetails(person);
                Log.v("TAG", responseDto.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void getApplicationDetails(String applicationId) {
        try {
            PayChatModule.providePayChatRepository().getApplicantDetails(applicationId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getApplicantId(String email) {
        new Thread(() -> {
            try {
                ApiResponseDto responseDto = PayChatModule.providePayChatRepository().getApplicantId(email);

                if(responseDto.isStatus()) {
                    Log.v("TAG", "Success");
                }else{
                    Log.v("TAG", "Failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
