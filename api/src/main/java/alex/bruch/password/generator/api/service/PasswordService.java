package alex.bruch.password.generator.api.service;

import java.util.List;

public interface PasswordService {
    List<String> generatePasswordsWithOptions(int amount, int length, boolean upperCase, boolean lowerCase, boolean digits);
}
