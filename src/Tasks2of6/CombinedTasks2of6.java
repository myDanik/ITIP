package Tasks2of6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinedTasks2of6 {
    public static void main(String[] args) {
//Task1
        String word1 = "Barack";
        String word2 = "Obama";
        System.out.println(duplicateChars(word1, word2));
//Task2
        int [] numbers = {3, 12, 7, 81,52};
        System.out.println(dividedByThree(numbers));
// Task3
        String fullName = "simonov sergei evgenievich";
        System.out.println(getInitials(fullName));
// Task4
        double [] listTask4 = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(Arrays.toString(normalizator(listTask4)));
// Task5
        double [] listTask5 = {1.6, 0, 212.3, 34.8, 0, 27.5};

        System.out.println(Arrays.toString(compressedNums(listTask5)));
//Task6
        String wordTask6 = "helloWorld";
        System.out.println(camelToSnake(wordTask6));
// Task7
        int[] listTask7 = {3, 5, 8, 1, 2, 4};
        System.out.println(secondBiggest(listTask7));
//Task8
        String wordTask8 = "Hello, I’m under the water, please help me";
        System.out.println(localReverse(wordTask8, 'e'));
//Task9
        System.out.println(equal(4,9,6));
//Task10
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
    }
//    Task 1
    public static String duplicateChars(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (char n: word1.toCharArray()) {
            if (word2.contains(String.valueOf(n)) == false){
                result.append(n);
            }

        }
        return result.toString();
    }
//    Task2
    public static int dividedByThree(int [] numbers) {
        int count = 0;
        for (int n: numbers) {
            if ((n%2==1)&&(n%3==0)) {
                count++;
            }
        }
        return count;
    }
//    Task3
    public static String getInitials(String fullName) {
        String [] fullNameList = fullName.split(" ");
        String initial1 = fullNameList[1].substring(0, 1).toString().toUpperCase();
        String initial2 = fullNameList[2].substring(0, 1).toString().toUpperCase();
        String surname = fullNameList[0].substring(0, 1).toString().toUpperCase()+ fullNameList[0].substring(1).toString().toLowerCase();
        return initial1 + "." + initial2 + "." + surname;
    }
//    Task4
    public static double[] normalizator(double [] list) {
        double [] resultlist = new double[list.length];
        for (int i = 0; i< list.length; i++) {

            resultlist[i] = (list[i] - Arrays.stream(list).min().orElse(0.0))/(Arrays.stream(list).max().orElse(0.0)-Arrays.stream(list).min().orElse(0.0));
            System.out.println((Arrays.stream(list).max().orElse(0.0)-Arrays.stream(list).min().orElse(0.0)));
        }
        System.out.println(Arrays.stream(list).min().orElse(0.0));
        System.out.println(Arrays.stream(list).max().orElse(0.0));
        return resultlist;
    }
//    Task5
    public static int [] compressedNums(double [] list) {
        return Arrays.stream(list).sorted().filter(num -> num != 0).mapToInt(num -> (int) Math.floor(num)).toArray();
    }
//    Task6
    public static String camelToSnake(String word) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i<word.length(); i++){
        char ch = word.charAt(i);
        if (Character.isUpperCase(ch)){
            result.append(word.substring(0,i));
            result.append("_");
            result.append((Character.toLowerCase(word.charAt(i))));
            result.append(word.substring(i+1));
        }
    }
    return result.toString();
    }
//    Task7
    public static int secondBiggest(int[] list){
        return Arrays.stream(list).sorted().toArray()[list.length-2];
    }
//    Task8
    public static String localReverse(String word, char ch) {
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (char n: word.toCharArray()){
            if (n==ch) {
                count++;
            }
        }
        int[] chList = new int[count];
        int countOfCh = 0;
        for (int i = 0; i<word.length();i++){
            if (word.charAt(i)==ch){
                chList[countOfCh] = i;
                countOfCh++;
            }
        }
        result.append( word.substring(0,chList[0]));
        result.append(Character.toString(ch));

        for (int i = 0; i<count-2;i+=2){

            result.append(new StringBuilder(word.substring(chList[i]+1, chList[i+1])).reverse().toString());

            result.append(Character.toString(ch));

            result.append(word.substring(chList[i+1]+1, chList[i+2]));

            result.append(Character.toString(ch));
        }
        result.append(word.substring(chList[count-2]+1, chList[count-1]));
        result.append(word.substring(chList[count-1]));

        return result.toString();


    }
    // Task9
    public static int equal(int x1, int x2, int x3){
        int[] list = {x1,x2,x3};
        int [] distinctList = Arrays.stream(list).distinct().toArray();
        if (distinctList.length == 1){
            return 3;

        } else if (distinctList.length==2) {
            return 2;


        }else {
            return 0;
        }

    }
//    Task10
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (str1.length()!=str2.length()){
            return false;
        }
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
