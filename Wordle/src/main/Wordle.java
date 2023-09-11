import java.util.Arrays;
import java.util.List;

public class Wordle {
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

class GuessChecker {
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

class Dictionary {
    List<String> wordList = Arrays.asList("tough","cough","spank","blank","stink","stank","study","blame","flame","flank","state","stare","cloud","pinky","blink",
    "alert","resin","shade","night","light","right","haunt","taunt","ghost","toast","boast","roast","react","alone","arise","about","tears","teach","reach","slump",
    "slaps","slate","slant","slang","slain","later","tired","glare","glade","false","flask","flair","flaws","stats","clamp","clank","kneel","knead","xerox","piano",
    "plate","plain","plaid","plank","rolls","robot","waste","dealt", "delta","drama","drank","drain","drugs","drums","drill","drift","yacht","punch","pupil","puppy",
    "eagle","eaten","ocean","oasis","aroma","arose","crown","crowd","croak","claim","clash","brain","brave","brake","bloat","bloom","flood","flour","flown","fight",
    "alien","canoe","fraud","raise","minor","panic","drive","title","bully","guard","dream","wound","equal","sight","sugar","cheer","pause","legal","error","smash",
    "trade","burst","flash","shame","sting","boost","store","shine","track","match","route","crash","clown","vegan","creep","sweat","quest","vocal","drool","shift",
    "scene","worth","final","faint","occur","blind","sheet","crush","relax","label","event","limit","argue","sharp","curse","image","guide","expel","quake","clout",
    "query","squad","vouch","siege","naive","inept","quirk","glory","irony","chief","motto","glyph");

    public boolean contains(String guess) {
        boolean retVal = false;
        retVal = (wordList.contains(guess));
        return retVal;
    }

    public String getRandomWord(){
        return wordList.get((int)(Math.random() * wordList.size()));
    }

    public String[] getWords() {
        return wordList.toArray(new String[0]);
    }

    public boolean isWordGuessed(String word, String[] guessedWords) {
        for (int i = 0; i < guessedWords.length; i++) {
            if (guessedWords[i] != null && guessedWords[i].equals(word)) {
                return true;
            }
        }
        return false;
    }
}