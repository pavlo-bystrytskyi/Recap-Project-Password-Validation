package org.example;

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
        while (true) {
            String password = generateNonValidatedPassword(length);
            if (PasswordValidator.isValid(password)) {

                return password;
            }
        }
    }

    private static String generateNonValidatedPassword(int length) {
        Random random = new Random();
        char[] passwordElements = new char[length];
        for (int i = 0; i < length; i++) {
            // Magic!
            passwordElements[i] = (char) (33 + random.nextInt(94));
        }

        return new String(passwordElements);
    }
}
