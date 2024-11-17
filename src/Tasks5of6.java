import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
public class Tasks5of6 {
    public static void main(String[] args) {
        System.out.println("Task1 - " + sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println("Task2 - " + memeSum(1222, 30277));
        System.out.println("Task3 - " +  digitsCount(1289396387328L));
        System.out.println("Task4 - " + totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("Task5 - " + longestRun(new int[]{3, 5, 7, 10, 15}));
        System.out.println("Task6 - " + takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println("Task7 - " + canMove("Queen", "C4", "D6"));
        System.out.println("Task8 - " + maxPossible(523, 76));
        System.out.println("Task9 - " + timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println("Task10 - " + isNew(321));

    }
    public static boolean sameLetterPattern(String str1, String str2){
        return getPattern(str1).equals(getPattern(str2));
    }
    public static String getPattern(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int nextCode = 0;

        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, nextCode++);
            }
            pattern.append(map.get(c));
        }

        return pattern.toString();
    }
    public static int memeSum(int num1, int num2){
        List<String> resultList = new ArrayList<>();
        int biggestNumber = 0;
        String result = "";
        if (String.valueOf(num1).length() < String.valueOf(num2).length()) {
            biggestNumber = num2;
            num2 = num1;
        } else {
            biggestNumber = num1;
        }
        while (biggestNumber>0){
            resultList.add(String.valueOf((biggestNumber%10)+(num2%10)));
            biggestNumber/=10;
            num2/=10;
        }
        resultList.reversed();
        for (String str: resultList){
            result = str + result;
        }
        return Integer.parseInt(result);
    }
    public static int digitsCount(long num){
        if (num < 10){
            return 1;
        }
        return digitsCount(num/10)+1;
    }
    public static int totalPoints(String[] words, String hiddenWord){
        int total = 0;
        for (String word: words){
            if (canFormWord(word, hiddenWord)){
                switch (word.length()){
                    case 3:
                        total+=1;
                        break;
                    case 4:
                        total+=2;
                        break;
                    case 5:
                        total+=3;
                        break;
                    case 6:
                        total+=54;
                        break;
                }
            }
        }
        return total;
    }
    public static boolean canFormWord(String target,String source) {
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        for (char c : source.toCharArray()) {
            sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
        }

        for (char c : target.toCharArray()) {
            if (!sourceMap.containsKey(c) || sourceMap.get(c) == 0) {
                return false;
            }
            sourceMap.put(c, sourceMap.get(c) - 1);
        }

        return true;
    }
    public static int longestRun(int[] numbers){
        int count = 1;
        int maxCount = 1;
        for (int i = 0; i < numbers.length-1; i++){
            if (Math.abs(numbers[i]-numbers[i+1])==1){
                count++;
            } else {
                count = 1;
            }
            if (count>maxCount) maxCount=count;
        }

        return maxCount;
    }
    public static String takeDownAverage(String[] classResults){
        List<Integer> fixedList = new ArrayList<>();
        Double average = 0.0;
        for (String result: classResults){
            int percent = Integer.parseInt(result.substring(0, result.length()-1));
            fixedList.add(percent);
            average+=percent;
        }
        average = average/classResults.length;
        long result = Math.round(((average-5)*(classResults.length+1))-average*classResults.length);
        return String.valueOf(result) + "%";

    }
    public static boolean canMove(String piece, String pos1, String pos2) {
        piece = piece.toLowerCase();
        String alphabet = "ABCDEFGH";
        int startRow = Integer.parseInt(pos1.substring(1));
        int endRow = Integer.parseInt(pos2.substring(1));
        int startCol = alphabet.indexOf(pos1.substring(0, 1));
        int endCol = alphabet.indexOf(pos2.substring(0, 1));
        if (startRow > 8 || endRow > 8) return false;
        if (endCol == -1 || startCol == -1) return false;
        switch (piece) {
            case "king":
                return Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1;
            case "queen":
                return (startRow == endRow || startCol == endCol ||
                        Math.abs(startRow - endRow) == Math.abs(startCol - endCol));

            case "rook":
                return startRow == endRow || startCol == endCol;

            case "bishop":
                return Math.abs(startRow - endRow) == Math.abs(startCol - endCol);

            case "knight":
                return (Math.abs(startRow - endRow) == 2 && Math.abs(startCol - endCol) == 1) ||
                        (Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 2);

            case "pawn":
                if (startCol != endCol) return false;
                if (startRow == 2) return endRow == 3 || endRow == 4;
                return endRow == startRow + 1;
            default:
                return false;
        }

    }
    public static int maxPossible(int num1, int num2) {
        StringBuilder result = new StringBuilder();
        String strNum = String.valueOf(num1);
        List<Integer> numberList = new ArrayList<>();
        while (num2>0) {
            numberList.add(num2%10);
            num2 /= 10;
        }
        numberList.sort(Collections.reverseOrder());
        for (char ch: strNum.toCharArray()) {
            try {
                if ((numberList.getFirst() > Character.getNumericValue(ch))) {
                    result.append(numberList.getFirst());
                    numberList.removeFirst();
                } else {
                    result.append(ch);
                }

            }catch (NoSuchElementException e){
                result.append(ch);
            }
        }

        return Integer.parseInt(result.toString());
    }
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        Map<String, String> cityOffsets = new HashMap<>();
        cityOffsets.put("Los Angeles", "-08:00");
        cityOffsets.put("New York", "-05:00");
        cityOffsets.put("Caracas", "-04:30");
        cityOffsets.put("Buenos Aires", "-03:00");
        cityOffsets.put("London", "00:00");
        cityOffsets.put("Rome", "+01:00");
        cityOffsets.put("Moscow", "+03:00");
        cityOffsets.put("Tehran", "+03:30");
        cityOffsets.put("New Delhi", "+05:30");
        cityOffsets.put("Beijing", "+08:00");
        cityOffsets.put("Canberra", "+10:00");

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        timestamp = timestamp.trim();
        timestamp = timestamp.substring(0, 1).toUpperCase() + timestamp.substring(1);
        LocalDateTime localDateTime = null;
        localDateTime = LocalDateTime.parse(timestamp, inputFormatter);
        ZoneOffset offsetA = ZoneOffset.of(cityOffsets.get(cityA));
        ZonedDateTime timeInCityA = localDateTime.atZone(offsetA);
        ZoneOffset offsetB = ZoneOffset.of(cityOffsets.get(cityB));
        ZonedDateTime timeInCityB = timeInCityA.withZoneSameInstant(offsetB);
        return timeInCityB.format(outputFormatter);
    }
    public static boolean isNew(int number) {
        List<Integer> numberList = new ArrayList<>();
        int temp = number;
        while (temp > 0) {
            numberList.add(temp % 10);
            temp /= 10;
        }
        Collections.sort(numberList);
        for (int i = 1; i < number; i++) {
            List<Integer> currentList = new ArrayList<>();
            temp = i;
            while (temp > 0) {
                currentList.add(temp % 10);
                temp /= 10;
            }
            Collections.sort(currentList);
            if (currentList.equals(numberList)) {
                return false;
            }
        }

        return true;
    }

}
