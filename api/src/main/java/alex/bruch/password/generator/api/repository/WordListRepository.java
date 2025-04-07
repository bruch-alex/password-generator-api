package alex.bruch.password.generator.api.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WordListRepository {
    public List<String> loadWords() throws IOException {
        System.out.println("Loading words...");
        List<String> wordList = new ArrayList<>();

        File file = new ClassPathResource("wordlist/eff-large").getFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading words: " + e.getMessage());
        }

        System.out.println("Loaded " + wordList.size() + " words");
        return wordList;
    }
}
