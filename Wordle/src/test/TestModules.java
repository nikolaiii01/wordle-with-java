package test;

import static org.junit.Assert.*;
import org.junit.Test;

import main.lib.GuessChecker;
import main.lib.Dictionary;

public class TestModules {

    @Test
    public void testCorrectGuess() {
        GuessChecker checker = new GuessChecker();
        String word = "haunt";
        String guess = "haunt";
        System.out.println("Unit test for correct guess:");
        System.out.println("Word: " + word);
        System.out.println("Guess: " + guess);
        int flag = checker.compareGuessAndWord(guess, word);
        assert(flag == 1);
    }
    
    @Test
    public void testIncorrectGuess() {
        GuessChecker checker = new GuessChecker();
        String word = "taunt";
        String guess = "tnwat";
        System.out.println("Unit test for incorrect guess:");
        System.out.println("Word: " + word);
        System.out.println("Guess: " + guess);
        int flag = checker.compareGuessAndWord(guess, word);
        System.out.println();
        assert(flag == 0);
    }

    @Test
    public void testGetRandomWord() {
        Dictionary dictionary = new Dictionary();
        String randomWord = dictionary.getRandomWord();
        assertNotNull(randomWord);
        assertTrue(dictionary.contains(randomWord));
    }

    @Test
    public void testDictionaryContainsGhost() {
        Dictionary dictionary = new Dictionary();
        assertTrue(dictionary.contains("ghost"));
    }

    @Test
    public void testDictionaryDoesNotContainAdieu() {
        Dictionary dictionary = new Dictionary();
        assertFalse(dictionary.contains("adieu"));
    }

    @Test
    public void testDictionaryDoesNotContainEmptyString() {
        Dictionary dictionary = new Dictionary();
        assertFalse(dictionary.contains(""));
    }

    @Test
    public void testDictionaryDoesNotContainNull() {
        Dictionary dictionary = new Dictionary();
        assertFalse(dictionary.contains(null));
    }
    
    @Test
    public void testDictionaryDoesNotContainDuplicateWords() {
        Dictionary dictionary = new Dictionary();
        String[] words = dictionary.getWords();
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                assertFalse(words[i].equals(words[j]));
            }
        }
    }

    @Test
    public void testDictionaryContainsOnly5LetterWords() {
        Dictionary dictionary = new Dictionary();
        String[] words = dictionary.getWords();
        for(int i = 0; i < words.length; i++) {
            assertTrue(words[i].length() == 5);
        }
    }

    @Test
    public void testDictionaryDoesNotContainNumberStrings() {
        Dictionary dictionary = new Dictionary();
        String[] words = dictionary.getWords();
        for(int i = 0; i < words.length; i++) {
            assertFalse(words[i].matches(".*\\d.*"));
        }
    }

    @Test
    public void testDictionaryDoesNotContainSpecialCharacters() {
        Dictionary dictionary = new Dictionary();
        String[] words = dictionary.getWords();
        for(int i = 0; i < words.length; i++) {
            assertFalse(words[i].matches(".*\\W.*"));
        }
    }

    @Test
    public void testDictionaryDoesNotContainUppercaseLetters() {
        Dictionary dictionary = new Dictionary();
        String[] words = dictionary.getWords();
        for(int i = 0; i < words.length; i++) {
            assertFalse(words[i].matches(".*[A-Z].*"));
        }
    }

    @Test
    public void testWordIsUsedAsAGuessAlready() {
        Dictionary dictionary = new Dictionary();
        String[] guesses = new String[6];
        guesses[0] = "haunt";
        guesses[1] = "taunt";
        guesses[2] = "stare";
        guesses[3] = "cloud";
        guesses[4] = "pinky";
        assertTrue(dictionary.isWordGuessed("haunt", guesses));
    }

    @Test
    public void testWordIsNotYetUsedAsAGuess() {
        Dictionary dictionary = new Dictionary();
        String[] guesses = new String[6];
        guesses[0] = "haunt";
        guesses[1] = "taunt";
        guesses[2] = "stare";
        guesses[3] = "cloud";
        guesses[4] = "pinky";
        assertFalse(dictionary.isWordGuessed("brave", guesses));
    }
}