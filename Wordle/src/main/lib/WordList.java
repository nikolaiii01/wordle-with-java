package main.lib;

import java.util.Arrays;
import java.util.List;

public class WordList {
    List<String> wordList = Arrays.asList("tough","cough","spank","blank","stink","stank","study","blame","flame","flank","state","stare","cloud","pinky","blink",
    "alert","resin","shade","night","light","right","haunt","taunt","ghost","toast","boast","roast","react","alone","arise","about","tears","teach","reach","slump",
    "slaps","slate","slant","slang","slain","later","tired","glare","glade","false","flask","flair","flaws","stats","clamp","clank","kneel","knead","xerox","piano",
    "plate","plain","plaid","plank","rolls","robot","waste","dealt", "delta","drama","drank","drain","drugs","drums","drill","drift","yacht","punch","pupil","puppy",
    "eagle","eaten","ocean","oasis","aroma","arose","crown","crowd","croak","claim","clash","brain","brave","brake","bloat","bloom","flood","flour","flown","fight",
    "alien","canoe","fraud","raise","minor","panic","study","drive","title","bully","guard","dream","wound","equal","sight","sugar","cheer","pause","legal","error",
    "smash","trade","burst","flash","shame","sting","boost","store","shine","track","match","route","crash","clown","vegan","creep","sweat","quest","vocal","drool",
    "shift","scene","worth","final","faint","occur","blind","sheet","crush","relax","label","expel","event","limit","argue","sharp","curse","image","guide","expel",
    "quake","clout","query","squad","vouch","siege","naive","inept","quirk","glory","irony","chief","motto","glyph");

    public List<String> getWordList() {
        return wordList;
    }
    
    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public void addWordToWordList(String word){
        if (!wordList.contains(word) && word.matches("[a-zA-Z]+") && word.length() == 5) {
            wordList.add(word);
        }
    }

    public void removeWordFromWordList(String word){
        if (wordList.contains(word)) {
            wordList.remove(word);
        }
    }

    public boolean contains(String guess) {
        //check if guess is in word list
        if (wordList.contains(guess)) {
            return true;
        } else { 
            return false;
        }
    }

    public String getRandomWord(){
        return wordList.get((int)(Math.random() * wordList.size()));
    }
}