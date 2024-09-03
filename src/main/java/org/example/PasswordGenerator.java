package org.example;

import java.util.Random;

import static org.example.PasswordValidator.MINIMUM_PASSWORD_LENGTH;

public class PasswordGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(generatePassword());
        }
    }

    public static String generatePassword() {
        while (true) {
            String password = generateNonValidatedPassword();
            if (PasswordValidator.isValid(password)) {

                return password;
            }
        }
    }

    private static String generateNonValidatedPassword() {
        Random random = new Random();
        char[] passwordElements = new char[MINIMUM_PASSWORD_LENGTH];
        for (int i = 0; i < MINIMUM_PASSWORD_LENGTH; i++) {
            // Magic!
            passwordElements[i] = (char) (33 + random.nextInt(94));
        }

        return new String(passwordElements);
    }
}
