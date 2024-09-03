package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordGeneratorTest {
    private static int GENERATIONS_NUMBER = 50;

    @Test
    void generatePassword() {
        for (int i = 0; i < GENERATIONS_NUMBER; i++) {
            String generatedPassword = PasswordGenerator.generatePassword();
            boolean isValid = PasswordValidator.isValid(generatedPassword);
            assertTrue(isValid);
        }
    }
}