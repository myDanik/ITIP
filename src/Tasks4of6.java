import java.util.List;
import java.util.ArrayList;


public class Tasks4of6 {
    public static void main(String[] args) {
//        Task1
        String word1 = "abracadabra";
        System.out.println(nonRepeat(word1));
//        Task2
        System.out.println(bruteForce(2,2));
//        Task3
        String text = "MTUCI";
        String key = "MKIIT";

        List<Integer> encoded = decode(text, key);
        System.out.println(encoded);

        String decodedText = encode(encoded, key);
        System.out.println(decodedText);
//        Task4
        String word4 = "((()))(())()()(()())";
        System.out.println(split(word4));
//        Task5
        String word5 = "abbccc";
        System.out.println(shortHand(word5));
//        Task6
        System.out.println(convertToRome(1488));
//        Task7
        System.out.println(uniqueSubstring("12223234333"));
//        Task8
        int[][] lab1 = {
                {1, 3, 1},
                {1, -1, 1},
                {4, 2, 1}};
        System.out.println(labirint(lab1));
//        Task9
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
//        Task10
        System.out.println(fibString("ABC"));
    }
//    Task1
    public static String nonRepeat(String str) {
        if (str.isEmpty()) return str;
        int count = 0;
        str = str.toLowerCase();
        char currentCh = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == currentCh) {
                count++;
            }
        }
        if (count > 3) {
            str = str.replaceAll(String.valueOf(currentCh), "");
            return nonRepeat(str);
        } else {
            return currentCh + nonRepeat(str.substring(1));
        }

    }
//    Task2
public static List<String> bruteForce(int n, int k) {
    List<String> results = new ArrayList<>();

    if (n > k) {
        return results;
    }

    generateCombinations("", n, k, results);
    return results;
}

    private static void generateCombinations(String current, int n, int k, List<String> results) {
        if (current.length() == n) {
            results.add(current);
            return;
        }

        for (int i = 0; i < k; i++) {
            char c = (char) ('0' + i);
            if (current.indexOf(c) != -1) continue;
            generateCombinations(current + c, n, k, results);
        }
    }
//    Task3
    public static List<Integer> decode(String text, String key) {
        List<Integer> result = new ArrayList<>();
        int keyLength = key.length();

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);
            char keyChar = key.charAt(i % keyLength);


            result.add(textChar ^ keyChar);
        }
        return result;
    }
    public static String encode(List<Integer> codes, String key) {
        StringBuilder result = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < codes.size(); i++) {
            int code = codes.get(i);
            char keyChar = key.charAt(i % keyLength);


            result.append((char) (code ^ keyChar));
        }
        return result.toString();
    }
//    Task4
    public static List<String> split(String str){
        List<String> clusters = new ArrayList<>();
        StringBuilder currentCluster = new StringBuilder();
        int balance = 0;

        for (char ch : str.toCharArray()) {
            currentCluster.append(ch);
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }
            if (balance == 0) {
                clusters.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return clusters;
    }
//    Task5
    public static String shortHand(String str){
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<str.length(); i++) {
            if (i<str.length()-1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append("*");
                    result.append(count);
                }
                count = 1;
            }
        }
        if (count>1);
        return result.toString();
    }
//    Task6
    public static String convertToRome(int num) {
        if (num <= 0 || num > 1502) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 1502");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
     }
//     Task7
    public static String uniqueSubstring(String str){
        StringBuilder symbols = new StringBuilder();
        for (char ch: str.toCharArray()){
            if (symbols.indexOf(Character.toString(ch)) == -1){
                symbols.append(ch);
            }
        }
        int countEven = 0;
        int countNoEven = 0;
        int max = 0;
        boolean evenFlag = false;
        for (char ch: symbols.toString().toCharArray()) {
            countNoEven = 0;
            countEven = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)==ch){
                    if (i%2==0){
                        countEven++;
                    } else countNoEven++;
                }
            }
            if (countEven>max) {
                max = countEven;
                evenFlag = false;
            }
            if (countNoEven>max) {
                max = countNoEven;
                evenFlag = true;
            }
        }
       return (evenFlag) ? "нечет": "чет";
    }
//    Task8
    public static List<String> labirint(int[][] list){
        int n = list.length;
        int[][] cost = new int[n][n];
        String[][] path = new String[n][n];
        cost[n-1][n-1] = list[n-1][n-1];
        path[n-1][n-1]= String.valueOf(list[n-1][n-1]);
        for (int i = n-1; i>=0; i--){

            for (int j = n-1; j>=0; j--){

                if (list[i][j]<0) {
                    cost[i][j] = Integer.MAX_VALUE;
                    continue;

                }
                if (i < n - 1 && cost[i + 1][j] != Integer.MAX_VALUE) {
                    int newCost = list[i][j] + cost[i + 1][j];
                    if (newCost < cost[i][j] || cost[i][j] == 0) {
                        cost[i][j] = newCost;
                        path[i][j] = list[i][j] + "-" + path[i + 1][j];
                    }
                }

                if (j < n - 1 && cost[i][j + 1] != Integer.MAX_VALUE) {
                    int newCost = list[i][j] + cost[i][j + 1];
                    if (newCost < cost[i][j] || cost[i][j] == 0) {
                        cost[i][j] = newCost;
                        path[i][j] = list[i][j] + "-" + path[i][j + 1];
                    }
                }
            }
        }
        if (cost[0][0] == Integer.MAX_VALUE) {
            return List.of("Прохода нет");
        }
        List<String> result = new ArrayList<>();
        result.add(new StringBuilder().append(path[0][0]).reverse().toString());
        result.add(String.valueOf(cost[0][0]));
        return result;
    }
//    Task9
    public static String numericOrder(String str){
        String[] words = str.split(" ");
        List<String> sortedWords = new ArrayList<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    index = Character.getNumericValue(ch) - 1;
                } else {
                    sb.append(ch);
                }
            }
            while (sortedWords.size() <= index) {
                sortedWords.add("");
            }
            sortedWords.set(index, sb.toString());
        }

        return String.join(" ", sortedWords);
    }
//    Task10
    public static boolean fibString(String str){
        int count = str.length() - (int) str.chars().distinct().count();
        return (generateFibonacciSet().indexOf((Integer) count) != -1);

    }
    private static List<Integer> generateFibonacciSet() {
        List<Integer> fibonacciSet = new ArrayList<>();
        int a = 0, b = 1;
        while (b <= 1000) {
            fibonacciSet.add(b);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibonacciSet;
    }
}
