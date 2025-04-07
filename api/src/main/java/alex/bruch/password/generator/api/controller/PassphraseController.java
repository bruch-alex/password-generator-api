package alex.bruch.password.generator.api.controller;

import alex.bruch.password.generator.api.service.PassphraseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generator")
public class PassphraseController {

    private final PassphraseService passphraseService;

    public PassphraseController(PassphraseService passphraseService) {
        this.passphraseService = passphraseService;
    }

    @GetMapping("/get-passphrase")
    @ResponseBody
    public String getPassphrase(@RequestParam(value = "words", required = false, defaultValue = "3") int words,
                                @RequestParam(value = "capitalize", required = false, defaultValue = "false") boolean capitalize) {
        return passphraseService.getPassphrase(words, capitalize);
    }
}
