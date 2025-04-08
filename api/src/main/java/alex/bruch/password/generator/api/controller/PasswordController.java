package alex.bruch.password.generator.api.controller;

import alex.bruch.password.generator.api.service.PasswordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<String> getPassword(@RequestParam(value = "length", required = false, defaultValue = "8") int length,
                                    @RequestParam(value = "upperCase", required = false, defaultValue = "true") boolean upperCase,
                                    @RequestParam(value = "lowerCase", required = false, defaultValue = "true") boolean lowerCase,
                                    @RequestParam(value = "digits", required = false, defaultValue = "true") boolean digits,
                                    @RequestParam(value = "amount", required = false, defaultValue = "1") int amount) {
        return passwordService.generatePasswordsWithOptions(amount, length, upperCase, lowerCase, digits);
    }
}
