package FifthLab;

public class Main {
    public static void main(String[] args) {

        System.out.println(PasswordValidator.validator("Password123"));
        System.out.println(HighlightPattern.highlightPattern("В тексте есть случаи типа aB и tR, которые нужно выделить."));
        System.out.println(IPValidator.validator("255.55.252.251"));
        System.out.println(WordStartingWithLetter.finder("The sale of the product is -19,99$", 's'));
    }

}
