package FifthLab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighlightPattern {
    public static String highlightPattern(String text){
        try {
            Pattern pattern = Pattern.compile("([a-z])([A-z])");
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("!$1$2!");
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return text;
        }
    }
}
