package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidatorTest {

    @Test
    void isValid_false() {
        String[] invalidPasswords = {
                "Aa#1234", // too short
                "Aa#aaaaa", // no digits
                "aa#12345", // no Uppercase
                "AA#12345", // no Lowercase
                "Password1!", // commonly used
                "Aa012345", // no special characters
                "" // empty string
        };
        for (String password : invalidPasswords) {
            boolean result = PasswordValidator.isValid(password);

            assertFalse(result);
        }
    }

    @Test
    void isValid_true() {
        String validPassword = "Aa#12345";
        boolean result = PasswordValidator.isValid(validPassword);

        assertTrue(result);
    }

    @Test
    void isLengthCorrect_short() {
        String password = "1234567";
        boolean result = PasswordValidator.isLengthCorrect(password);

        assertFalse(result);
    }

    @Test
    void isLengthCorrect_correct() {
        String password = "12345678";
        boolean result = PasswordValidator.isLengthCorrect(password);

        assertTrue(result);
    }

    @Test
    void containsDigits_not() {
        String password = "abcdef";
        boolean result = PasswordValidator.containsDigits(password);

        assertFalse(result);
    }

    @Test
    void containsDigits_correct() {
        String password = "a1bcdef";
        boolean result = PasswordValidator.containsDigits(password);

        assertTrue(result);
    }

    @Test
    void containsUppercaseLowercase_noUppercase() {
        String password = "abcdef";
        boolean result = PasswordValidator.containsUppercaseLowercase(password);

        assertFalse(result);
    }

    @Test
    void containsUppercaseLowercase_noLowercase() {
        String password = "ABCDEF";
        boolean result = PasswordValidator.containsUppercaseLowercase(password);

        assertFalse(result);
    }

    @Test
    void containsUppercaseLowercase_correct() {
        String password = "ABCDEf";
        boolean result = PasswordValidator.containsUppercaseLowercase(password);

        assertTrue(result);
    }

    @Test
    void isNotCommonlyUsed_commonlyUsed() {
        String password = "Password1!";
        boolean result = PasswordValidator.isNotCommonlyUsed(password);

        assertFalse(result);
    }

    @Test
    void isNotCommonlyUsed_correct() {
        String password = "Password2!";
        boolean result = PasswordValidator.isNotCommonlyUsed(password);

        assertTrue(result);
    }

    @Test
    void containsSpecialCharacters_not() {
        String password = "1234567";
        boolean result = PasswordValidator.containsSpecialCharacters(password);

        assertFalse(result);
    }

    @Test
    void containsSpecialCharacters_correct() {
        String password = "123456_";
        boolean result = PasswordValidator.containsSpecialCharacters(password);

        assertTrue(result);
    }
}