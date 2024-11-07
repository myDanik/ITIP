package FifthLab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidator {
    public static boolean validator(String text){
        try {
            Pattern pattern = Pattern.compile("(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.(1?[0-9]{1,2}|2[0-4][0-9]|25[0-5])");
            Matcher matcher = pattern.matcher(text);
            return matcher.matches();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
