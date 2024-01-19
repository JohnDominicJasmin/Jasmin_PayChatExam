package com.example.jasmin1_19_2024exam.presentation.friend.ui_event;

public abstract class Result {

    private Result() {
    }

    public static final class InvalidFirstName extends Result {
        private final String message;

        public InvalidFirstName(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static final class InvalidLastName extends Result {
        private final String errorMessage;

        public InvalidLastName(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }


/*    public static final class InvalidMiddleName extends Result {
        private final String errorMessage;

        public InvalidLastName(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }*/


}