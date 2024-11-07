package FifthLab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class WordStartingWithLetter {
    public static ArrayList<String> finder(String text, char letter){
        ArrayList<String> result = new ArrayList<String>();
        try {
            Pattern pattern = Pattern.compile("\\b"+String.valueOf(letter)+"[a-zA-Z]*\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                result.add(matcher.group());
            }
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return result;
        }
    }
}
