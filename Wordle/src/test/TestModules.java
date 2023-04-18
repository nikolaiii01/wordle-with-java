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
    //Another test for contains() method
    public void testDictionaryDoesNotContainAdieu() {
        Dictionary dictionary = new Dictionary();
        assertFalse(dictionary.contains("adieu"));
    }
}