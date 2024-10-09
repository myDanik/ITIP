import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tasks3of6 {

    public static void main(String[] args) {
//        Task1
        String word1 = "";
        String word2 = "";
        System.out.println(isStrangePair(word1,word2));
//        Task2
        List<String[]> items = new ArrayList<>();
        items.add(new String[] {"Laptop", "124200"});
        items.add(new String[] {"Phone", "51450"});
        items.add(new String[] {"Headphones", "13800"});
        int discount = 25;

        List<String[]> result = sale(items, discount);
        for (String[]item: result){
            System.out.println(item[0] +" "+ item[1]);


        }
//        Task3
        int x = -2;
        int y = -3;
        int radius = 4;
        int m = 5;
        int n = -6;
        System.out.println(sucsessShot(x,y,radius,m,n));
//        Task4
        int number = 3;
        System.out.println(parityAnalysis(number));
//        Task5
        System.out.println(rps("rock", "paper"));
//        Task6
        int buggerNumber = 999;
        System.out.println(bugger(buggerNumber));
//        Task7
        List<String[]> inventory = new ArrayList<>();
        inventory.add(new String[]{"Скакалка", "550", "8"});
        inventory.add(new String[]{"Шлем", "3750", "4"});
        inventory.add(new String[]{"Мяч", "2900", "10"});
        System.out.println(mostExpensive(inventory));
//        Task8
        String str = "abcba";
        System.out.println(longestUnique(str));
//        Task9
        String word = "arachnophobia";
        String prefixOrSuffix = "-phobia";
        System.out.println(isPrefix(word,prefixOrSuffix));
        System.out.println(isSuffix(word,prefixOrSuffix));
//        Task10
        int a = 1;
        int b = 2;
        int c = 2;
        int w = 1;
        int h = 1;
        System.out.println(doesBrickFit(a,b,c,w,h));
    }
    public static boolean isStrangePair(String word1, String word2){
        if ((word1.length()==0)&&(word1.length()==0)){
            return true;
        }
        return ((word1.toCharArray()[0]==word2.toCharArray()[word2.toCharArray().length-1])&&(word2.toCharArray()[0]==word1.toCharArray()[word1.toCharArray().length-1]));
    }
    public static List<String[]> sale(List<String[]> items, int discount){
        List<String[]> resultList = new ArrayList<>();
        for (String[] item: items){
            double price = Double.parseDouble(item[1]);
            double discountedPrice = price * (1 - discount / 100.0);
            int finalPrice = (int) Math.max(1, Math.round(discountedPrice));
            resultList.add(new String[] {item[0], String.valueOf(finalPrice)});
        }
        return resultList;
    }
    public static boolean sucsessShot(int x, int y, int r, int m, int n){
        return Math.sqrt((m-x)*(m-x) + (n-y)*(n-y)) <= r;
    }
    public static boolean parityAnalysis(int num){
        int sum = 0;
        int temp = num;
        while (temp>0){
            sum += temp%10;
            temp/=10;
        }
        return (sum%2==num%2);
    }
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Tie";
        }
        if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("scissors") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }
    public static int bugger(int num){
        int count = 0;
        int temp = num;
        while (temp>9){
            int otherTemp = 1;
            while (temp>0){
                otherTemp *= temp%10;
                temp /=10;
            }
            temp = otherTemp;
            count++;
        }
        return count;
    }
    public static String mostExpensive(List<String[]> items){
        String itemName = "";
        int maxCost = 0;
        for (String[] item:items){
            if ((Integer.parseInt(item[2]) * Integer.parseInt(item[1]))>maxCost){
                maxCost = Integer.parseInt(item[2]) * Integer.parseInt(item[1]);
                itemName = item[0];
            }

        }
        return "Наиб. общ. стоимость у предмета " + itemName + " - " + String.valueOf(maxCost);

    }
    public static String longestUnique(String str){
        String subStr = "";
        int lenOfResultStr = 0;
        int maxLen = 0;
        String resultStr = "";
        for (char ch: str.toCharArray()){
            if (subStr.indexOf(ch) == -1){
                subStr+=ch;
                lenOfResultStr++;
                if (lenOfResultStr>maxLen){
                    maxLen = lenOfResultStr;
                    resultStr = subStr;
                }
            } else {
                subStr = "";
                lenOfResultStr = 0;
            }
        }
     return resultStr;
    }
    public static boolean isPrefix(String word, String prefix){
        if (prefix.toCharArray()[prefix.length()-1] != '-'){
            return false;
        }
        String fixedPrefix = prefix.substring(0, prefix.length()-1);
        return word.equals(fixedPrefix+word.substring(fixedPrefix.length()));
    }
    public static boolean isSuffix(String word, String suffix) {
        if (suffix.toCharArray()[0] != '-'){
            return false;
        }
        String fixedSuffix = suffix.substring(1);
        return word.equals(word.substring(0, word.length()-fixedSuffix.length())+fixedSuffix);
    }
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        int[] brick = {a,b,c};
        Arrays.sort(brick);
        return (brick[0] <= w && brick[1] <= h);
    }
}
