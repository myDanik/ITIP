package FifthLab;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args){
        try {
            String text = "The sale of the product is -19,99$";
            Pattern pattern = Pattern.compile("-?\\d+([.,]?)\\d*");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
