package org.example;

public class PasswordValidator {
    private static final String[] COMMONLY_USED = {"Password1!", "Aa345678"};
    static int MINIMUM_PASSWORD_LENGTH = 8;

    public static boolean isValid(String password) {
        return isLengthCorrect(password)
                && containsDigits(password)
                && containsUppercaseLowercase(password)
                && isNotCommonlyUsed(password)
                && containsSpecialCharacters(password);
    }

    static boolean isLengthCorrect(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    static boolean containsDigits(String password) {
        return password.matches("(.*)\\d+(.*)");
    }

    static boolean containsUppercaseLowercase(String password) {
        return password.matches("(.*)[A-Z]+(.*)") && password.matches("(.*)[a-z]+(.*)");
    }

    static boolean isNotCommonlyUsed(String password) {
        for (String commonlyUsedPassword : COMMONLY_USED) {
            if (commonlyUsedPassword.equals(password)) {

                return false;
            }
        }

        return true;
    }

    static boolean containsSpecialCharacters(String password) {
        return password.matches("(.*)[^a-zA-Z0-9]+(.*)");
    }
}
