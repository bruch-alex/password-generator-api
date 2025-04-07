package alex.bruch.password.generator.api.controller;

import alex.bruch.password.generator.api.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-password-manager")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/get-password")
    public String getPassword(@RequestParam(value = "length", required = false, defaultValue = "8") int length,
                              @RequestParam(value = "upperCase", required = false, defaultValue = "true") boolean upperCase,
                              @RequestParam(value = "lowerCase", required = false, defaultValue = "true") boolean lowerCase,
                              @RequestParam(value = "digits", required = false, defaultValue = "true") boolean digits) {
        return passwordService.getPassword(length, upperCase, lowerCase, digits);
    }
}
