package alex.bruch.password.generator.api.service.impl;

import alex.bruch.password.generator.api.service.PassphraseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PassphraseServiceImpl implements PassphraseService {
    private final WordListService wordListService;
    private final Random random;

    public PassphraseServiceImpl(WordListService wordListService) {
        this.wordListService = wordListService;
        this.random = new Random();
    }

    @Override
    public String getPassphrase(int wordsCount, boolean capitalize) {
        StringBuilder passphrase = new StringBuilder();

        for (int i = 0; i < wordsCount; i++) {
            passphrase
                    .append(getWord(capitalize))
                    .append("-");
        }
        passphrase.deleteCharAt(passphrase.length() - 1);
        return passphrase.toString();
    }

    private String getWord(boolean capitalize) {
        List<String> wordList = wordListService.getWordList();
        StringBuilder word = new StringBuilder(wordList.get(random.nextInt(wordList.size())));
        if (capitalize) {
            word.replace(0, 1, word.substring(0, 1).toUpperCase());
        }
        return word.toString();
    }
}
