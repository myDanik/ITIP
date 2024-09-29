package FirstLab;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " is a palindrome");
            }
            else {
                System.out.println(s + "is not a palindrome");
            }
        }
    }

    public static String reverseString(String s) {
        String reverse_word = "";
        for (int i = 0; i < s.length(); i++) {
            reverse_word = s.charAt(i) + reverse_word;
        }
        return reverse_word;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}
