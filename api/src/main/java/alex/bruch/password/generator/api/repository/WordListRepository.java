package alex.bruch.password.generator.api.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WordListRepository {
    public List<String> loadWords() throws IOException {
        System.out.println("Loading words...");
        List<String> wordList = new ArrayList<>();

        InputStream is = null;
        BufferedReader br = null;
        try {
            is = getClass().getClassLoader().getResourceAsStream("wordlist/eff-large");

            if (is == null) {
                System.err.println("Could not find wordlist/eff-large");
                return null;
            }

            br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                wordList.add(line);
            }
            System.out.println("Loaded " + wordList.size() + " words");
            return wordList;

        } catch (IOException e) {
            System.out.println("Error loading words: " + e.getMessage());
        } finally {
            if (br != null) {
                br.close();
            }
            if (is != null) {
                is.close();
            }
        }
        return null;
    }
}
