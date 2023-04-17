package main.lib;

public class GuessChecker {
    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_GREEN = "\u001B[42m";
    public static final String ANSI_RED = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    public int compareGuessAndWord(String guess, String word){
        for(int i = 0, j = 0; i < word.length(); i++, j++){
            if(word.charAt(i) == guess.charAt(j)){
                System.out.print(ANSI_GREEN + " " + word.charAt(i) + " " + ANSI_RESET);
            } else if(word.indexOf(guess.charAt(j)) != -1){
                System.out.print(ANSI_YELLOW + " " + guess.charAt(j) + " " + ANSI_RESET);
            } else {
                System.out.print(ANSI_RED + " " + guess.charAt(j) + " " + ANSI_RESET);
            }
        }
        if(guess.equals(word)){
            System.out.println();
            System.out.println("Congratulations! You guessed the word!");
            return 1;
        }
        return 0;
    }
}
