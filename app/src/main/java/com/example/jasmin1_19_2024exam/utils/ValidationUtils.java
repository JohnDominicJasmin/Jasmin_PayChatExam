package com.example.jasmin1_19_2024exam.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final int MAX_FNAME_LENGTH = 40;
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final String REQUIRED_MOBILE_COUNTRY_CODE = "63";

    public static boolean isValidBirthDate(String birthDate) {
        if (isNullOrEmpty(birthDate)) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(birthDate);
            return parsedDate != null;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidMobileCountryCode(String mobileCountryCode) {
        if (isNullOrEmpty(mobileCountryCode)) {
            return false;
        }

        if (!isNumeric(mobileCountryCode)) {
            return false;
        }

        return mobileCountryCode.equals(REQUIRED_MOBILE_COUNTRY_CODE);
    }

    public static boolean isValidMobile(String mobile) {
        if (mobile == null || mobile.isEmpty()) {
            return false;
        }

        if (!isNumeric(mobile)) {
            return false;
        }

        return mobile.length() <= 15;
    }

    public static boolean isValidName(String fname) {
        return fname != null && fname.matches("[a-zA-Z0-9\\s]+") && fname.length() <= MAX_FNAME_LENGTH;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email != null && email.length() <= MAX_EMAIL_LENGTH && Pattern.matches(emailRegex, email);
    }


    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    private static boolean isRequired(String value) {
        return value != null && !value.trim().isEmpty();
    }

    private static boolean isAlphaNumericWithSpaces(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]*$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    private static boolean isMaxLength40(String value) {
        return value.length() <= 40;
    }


}

