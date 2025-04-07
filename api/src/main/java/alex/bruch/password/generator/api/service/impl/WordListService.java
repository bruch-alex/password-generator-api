package alex.bruch.password.generator.api.service.impl;

import alex.bruch.password.generator.api.repository.WordListRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordListService {

    @Getter
    private final List<String> wordList;

    public WordListService(WordListRepository wordListRepository) {
        List<String> wordList1;
        try {
            wordList1 = wordListRepository.loadWords();
        } catch (IOException e) {
            System.out.println("Error loading word list" + e.getMessage());
            wordList1 = new ArrayList<>();
        }

        this.wordList = wordList1;
    }

}
