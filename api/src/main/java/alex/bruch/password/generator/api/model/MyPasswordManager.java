package alex.bruch.password.generator.api.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class MyPasswordManager {
    //CharSets
    private final List<Integer> lowerCaseDecimal = List.of(97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122);
    private final List<Integer> upperCaseDecimal = List.of(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);
    private final List<Integer> digitsDecimal = List.of(48, 49, 50, 51, 52, 53, 54, 55, 56, 57);
    // Generator properties
    private final List<Integer> finalSet = new ArrayList<>();
    private final Random random = new Random();

    public void updateLowerCase(boolean addLowerCase){
        if (addLowerCase) {
            finalSet.addAll(lowerCaseDecimal);
        } else finalSet.removeAll(lowerCaseDecimal);
    }

    public void updateUpperCase(boolean addUpperCase){
        if (addUpperCase) {
            finalSet.addAll(upperCaseDecimal);
        } else finalSet.removeAll(upperCaseDecimal);
    }
    public void updateDigits(boolean addDigits){
        if (addDigits) {
            finalSet.addAll(digitsDecimal);
        } else finalSet.removeAll(digitsDecimal);
    }

    private String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append((char) (int) finalSet.get(random.nextInt(1, finalSet.size())));
        }

        return password.toString();
    }

    public List<String> getPassword(int amount, int length) {
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            passwords.add(generatePassword(length));
        }
        return passwords;
    }
}
