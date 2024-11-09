package SixthLab;
import java.io.*;
import java.util.*;
public class TenWordFinder {
    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        try (FileReader fileReader = new FileReader("src/SixthLab/text");
             Scanner scanner = new Scanner(fileReader)){
            scanner.useDelimiter("\\s+");
            while (scanner.hasNext()){
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                result.put(word, result.getOrDefault(word,0)+1);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(result.entrySet());

        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        System.out.println("Топ-10 слов:");
        for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
