package alex.bruch.password.generator.api.service.impl;

import alex.bruch.password.generator.api.service.PasswordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PasswordServiceImpl implements PasswordService {
    private final List<Integer> lowerCaseDecimal = List.of(97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122);
    private final List<Integer> upperCaseDecimal = List.of(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);
    private final List<Integer> digitsDecimal = List.of(48, 49, 50, 51, 52, 53, 54, 55, 56, 57);
    private final List<Integer> finalSet = new ArrayList<>();
    private final Random random;

    public PasswordServiceImpl() {
        random = new Random();
    }

    public void toggleLowerCase(boolean includeLowerCase) {
        if (includeLowerCase) {
            finalSet.addAll(lowerCaseDecimal);
        } else finalSet.removeAll(lowerCaseDecimal);
    }

    public void toggleUpperCase(boolean includeUpperCase) {
        if (includeUpperCase) {
            finalSet.addAll(upperCaseDecimal);
        } else finalSet.removeAll(upperCaseDecimal);
    }

    public void toggleDigits(boolean includeDigits) {
        if (includeDigits) {
            finalSet.addAll(digitsDecimal);
        } else finalSet.removeAll(digitsDecimal);
    }

    private char getRandomChar() {
        int ascii = finalSet.get(random.nextInt(1, finalSet.size()));
        return (char) ascii;
    }

    private String buildPassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = getRandomChar();
            password.append(ch);
        }

        return password.toString();
    }

    private List<String> generateMultiplePasswords(int amount, int length) {
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            passwords.add(buildPassword(length));
        }
        return passwords;
    }

    @Override
    public List<String> generatePasswordsWithOptions(int amount, int length, boolean upperCase, boolean lowerCase, boolean digits) {
        toggleLowerCase(lowerCase);
        toggleUpperCase(upperCase);
        toggleDigits(digits);
        return generateMultiplePasswords(amount, length);
    }
}
