package FifthLab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean validator(String text) {
        try {
            Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}");
            Matcher matcher = pattern.matcher(text);
            return matcher.matches();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
