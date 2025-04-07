package alex.bruch.password.generator.api.service;

public interface PassphraseService {
    String getPassphrase(int wordsCount, boolean capitalize);

}
