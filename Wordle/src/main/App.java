package main;

import main.lib.GuessChecker;
import main.lib.Dictionary;

public class App {
    static int flag = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to WORDLE!");
        System.out.println("You have 6 tries to guess a five letter word.");
        System.out.println("If you guess a letter that is in the word, but not in the right place, the letter will be highlighted in yellow.");
        System.out.println("If you guess a letter that is not in the word, the letter will be highlighted in red.");
        System.out.println("If you guess a letter that is in the correct place, the letter will be highlighted in green.");
        System.out.println("Good luck!");
        System.out.println();
      
        Dictionary dictionary = new Dictionary();
        GuessChecker checker = new GuessChecker();
        String[] guesses = new String[7];

        String word = dictionary.getRandomWord();
        
        for (int i = 0; i < word.length(); i++) {
            System.out.print("__ ");
        }

        for(int tries = 6, i = 0; tries >= 0;){
            System.out.println();
            System.out.println();
            String guess = System.console().readLine("Guess: ");
            if(guess.length() != 5){
                System.out.println("Your guess must be five letters long.");
            } else if(!dictionary.contains(guess)){
                System.out.println("That word is not in the program's word list.");
            } else if(dictionary.isWordGuessed(guess, guesses)){
                System.out.println("You have already guessed that word.");
            } else {
                flag = checker.compareGuessAndWord(guess, word);
                guesses[i] = guess;
                if(flag==1) break;
                System.out.println();
                System.out.println("You have " + tries + " tries left.");
                tries--;
                i++;
            }
        }
    }
}
