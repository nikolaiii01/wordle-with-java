package main;

import main.lib.GuessChecker;
import main.lib.WordList;

import java.util.Scanner;

//Wordle app
public class App {
    static int flag = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to WORDLE!");
        System.out.println("You have 6 tries to guess the word.");
        System.out.println("If you guess a letter that is in the word, but not in the right place, the letter will be highlighted in yellow.");
        System.out.println("If you guess a letter that is not in the word, the letter will be highlighted in red.");
        System.out.println("If you guess a letter that is in the correct place, the letter will be highlighted in green.");
        System.out.println("Good luck!");
        System.out.println();
      
        WordList words = new WordList();
        GuessChecker checker = new GuessChecker();

        String word = words.getRandomWord();

        Scanner scan = new Scanner(System.in);
        
        for (int i = 0; i < word.length(); i++) {
            System.out.print("__ ");
        }

        for(int tries = 6; tries > 0;){
            System.out.println();
            System.out.println();
            String guess = scan.nextLine();
            if(!words.contains(guess)){
                System.out.println("That word is not in the program's word list.");
            } else {
                flag = checker.compareGuessAndWord(guess, word);
                if(flag==1) break;
                tries--;
                System.out.println();
                System.out.println("You have " + tries + " tries left.");
            }
        }
        scan.close();
    }
}