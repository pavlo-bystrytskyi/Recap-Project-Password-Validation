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
        Random random = new Random();
        char[] passwordElements = new char[MINIMUM_PASSWORD_LENGTH];
        String password = "";
        do {
            for (int i = 0; i < MINIMUM_PASSWORD_LENGTH; i++) {
                // Magic!
                passwordElements[i] = (char) (33 + random.nextInt(94));
            }
            password = new String(passwordElements);
        } while (!PasswordValidator.isValid(password));

        return password;
    }
}
