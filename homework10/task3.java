package homework10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class task3 {
    public static void main(String[] args) {
        Map<String, Integer> wordValue = new HashMap<>();
            try(InputStream fis = new FileInputStream("src/main/java/homework10/test3.txt");
                Scanner scanner = new Scanner(fis)){
                while(scanner.hasNext()){
                    String line = scanner.nextLine();
                    String[] splitedLine = line.split(" ");
                    for(String unknownWord: splitedLine){
                        String word = unknownWord;
                        int value = 1;
                        if(wordValue.containsKey(word)){
                            int currentValue = wordValue.get(word);
                            wordValue.put(word, currentValue + 1);
                        } else {
                            wordValue.put(word, value);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordValue.get(o1).compareTo(wordValue.get(o2)) > 0 ? 1 : -1;
            }
        };
        Map<String, Integer> result = new TreeMap<>(comparator.reversed());
        result.putAll(wordValue);
        System.out.println(result);
    }
}
