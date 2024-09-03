package org.example;

public class PasswordValidator {
    static int MINIMUM_PASSWORD_LENGTH = 8;
    private static final String[] COMMONLY_USED = {"Password1!", "Aa345678"};

    public static boolean isValid(String password) {
        return isLengthCorrect(password)
                && containsDigits(password)
                && containsUppercaseLowercase(password)
                && isNotCommonlyUsed(password)
                && containsSpecialCharacters(password);
    }

    public static boolean isLengthCorrect(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    public static boolean containsDigits(String password) {
        return password.matches("(.*)\\d+(.*)");
    }

    public static boolean containsUppercaseLowercase(String password) {
        return password.matches("(.*)[A-Z]+(.*)") && password.matches("(.*)[a-z]+(.*)");
    }

    public static boolean isNotCommonlyUsed(String password) {
        for (String commonlyUsedPassword : COMMONLY_USED) {
            if (commonlyUsedPassword.equals(password)) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsSpecialCharacters(String password) {
        return password.matches("(.*)[^a-zA-Z0-9]+(.*)");
    }
}
