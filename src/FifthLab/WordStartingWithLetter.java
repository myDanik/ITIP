package FifthLab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
public class WordStartingWithLetter {
    public static List<String> finder(String text, char letter){
        List<String> result = new ArrayList<>();
        try {
            Pattern pattern = Pattern.compile("\\b[a-zA-Z]*"+String.valueOf(letter)+"\\b");
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
