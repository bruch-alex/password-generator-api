package alex.bruch.password.generator.api.service;

public interface PasswordService {
    String getPassword(int length, boolean upperCase, boolean lowerCase, boolean digits);
}
