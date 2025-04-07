package alex.bruch.password.generator.api.service;

import alex.bruch.password.generator.api.model.MyPasswordManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {
    private final MyPasswordManager myPasswordManager;

    public PasswordServiceImpl(MyPasswordManager myPasswordManager) {
        this.myPasswordManager = myPasswordManager;
    }

    @Override
    public List<String> getPassword(int amount, int length, boolean upperCase, boolean lowerCase, boolean digits) {
        myPasswordManager.updateLowerCase(lowerCase);
        myPasswordManager.updateUpperCase(upperCase);
        myPasswordManager.updateDigits(digits);
        return myPasswordManager.getPassword(amount, length);
    }
}
