package org.example;

import java.security.SecureRandom;
import java.util.Random;

import static org.example.PasswordValidator.MINIMUM_PASSWORD_LENGTH;

public class PasswordGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(generatePassword(20));
        }
    }

    public static String generatePassword() {
        return generatePassword(MINIMUM_PASSWORD_LENGTH);
    }

    public static String generatePassword(int length) {
        String password = generateNonValidatedPassword(length);
        while (!PasswordValidator.isValid(password)) {
            password = generateNonValidatedPassword(length);
        }

        return password;
    }

    private static String generateNonValidatedPassword(int length) {
        Random random = new SecureRandom();
        char[] passwordElements = new char[length];
        for (int i = 0; i < length; i++) {
            // Magic!
            passwordElements[i] = (char) (33 + random.nextInt(94));
        }

        return new String(passwordElements);
    }
}
