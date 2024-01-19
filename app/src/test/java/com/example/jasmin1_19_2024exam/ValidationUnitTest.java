package com.example.jasmin1_19_2024exam;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.jasmin1_19_2024exam.utils.ValidationUtils;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidationUnitTest {


    @Test
    public void testValidBirthDate() {
        assertTrue(ValidationUtils.isValidBirthDate("12/31/2000"));
        assertTrue(ValidationUtils.isValidBirthDate("01/01/1990"));
    }

    @Test
    public void testInvalidBirthDate() {
        assertFalse(ValidationUtils.isValidBirthDate("13/31/2000")); // Invalid month
        assertFalse(ValidationUtils.isValidBirthDate("12/32/2000")); // Invalid day
        assertFalse(ValidationUtils.isValidBirthDate("12-31-2000")); // Invalid format
        assertFalse(ValidationUtils.isValidBirthDate("2020/12/31")); // Invalid format
        assertFalse(ValidationUtils.isValidBirthDate("31/12/2000")); // Invalid format
        assertFalse(ValidationUtils.isValidBirthDate("")); // Empty string
        assertFalse(ValidationUtils.isValidBirthDate(null)); // Null string
    }

    @Test
    public void testValidFname() {
        // Test with a valid fname
        assertTrue(ValidationUtils.isValidName("John Doe"));
    }

    @Test
    public void testValidMobile() {
        assertTrue(ValidationUtils.isValidMobile("123456789012345"));
        assertTrue(ValidationUtils.isValidMobile("987654321"));
    }

    @Test
    public void testInvalidMobile() {
        assertFalse(ValidationUtils.isValidMobile(null));
        assertFalse(ValidationUtils.isValidMobile(""));
        assertFalse(ValidationUtils.isValidMobile("abc123"));
        assertFalse(ValidationUtils.isValidMobile("1234567890123456"));
    }

    @Test
    public void testInvalidFnameWithSpecialCharacter() {
        assertFalse(ValidationUtils.isValidName("John@Doe"));
    }

    @Test
    public void testInvalidFnameMaxLengthExceeded() {
        assertFalse(ValidationUtils.isValidName("ThisIsANameThatExceedsTheMaxLengthLimit ThisIsANameThatExceedsTheMaxLengthLimit"));
    }

    @Test
    public void testInvalidFnameEmpty() {
        assertFalse(ValidationUtils.isValidName(""));
    }

    @Test
    public void testInvalidFnameNull() {
        assertFalse(ValidationUtils.isValidName(null));
    }

    @Test
    public void testValidEmail() {
        assertTrue(ValidationUtils.isValidEmail("test@example.com"));
    }

    @Test
    public void testInvalidEmailFormat() {
        assertFalse(ValidationUtils.isValidEmail("invalid-email"));
    }

    @Test
    public void testInvalidEmailNull() {
        assertFalse(ValidationUtils.isValidEmail(null));
    }

    @Test
    public void testInvalidEmailMaxLengthExceeded() {
        StringBuilder longEmail = new StringBuilder();
        for (int i = 0; i < 60; i++) {
            longEmail.append("a");
        }

        assertFalse(ValidationUtils.isValidEmail(longEmail.toString()));
    }
}