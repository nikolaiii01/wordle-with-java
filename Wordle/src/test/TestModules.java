package test;

import static org.junit.Assert.*;
import org.junit.Test;

import main.lib.GuessChecker;
import main.lib.WordList;

public class TestModules {

    @Test
    public void testCompareGuessAndWord() {
        GuessChecker checker = new GuessChecker();
        String word = "haunt";
        String guess = "haunt";
        System.out.println("Unit test for compareGuessAndWord() #2");
        System.out.println("Word: " + word);
        System.out.println("Guess: " + guess);
        int flag = checker.compareGuessAndWord(guess, word);
        assert(flag == 1);
    }
    
    @Test
    public void testCompareGuessAndWord2() {
        GuessChecker checker = new GuessChecker();
        String word = "taunt";
        String guess = "tnwat";
        System.out.println("Unit test for compareGuessAndWord() #1");
        System.out.println("Word: " + word);
        System.out.println("Guess: " + guess);
        int flag = checker.compareGuessAndWord(guess, word);
        System.out.println();
        assert(flag == 0);
    }

    @Test
    public void testGetRandomWord() {
        WordList wordList = new WordList();
        String randomWord = wordList.getRandomWord();
        assertNotNull(randomWord);
        assertTrue(wordList.contains(randomWord));
    }

    @Test
    public void testContains() {
        WordList wordList = new WordList();
        assertTrue(wordList.contains("ghost"));
        assertFalse(wordList.contains("adieu"));
    }
}