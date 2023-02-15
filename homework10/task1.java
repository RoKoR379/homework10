package homework10;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {
    public static void main(String[] args){
        File file = new File("src/main/java/homework10/test1.txt");
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- ]?\\d{3}[-]?\\d{4}$");
        if(file.exists()){
            try(InputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis)){
                while(scanner.hasNext()){
                    String str = scanner.nextLine();
                    Matcher matcher = pattern.matcher(str);
                    if(matcher.matches()){
                        System.out.println(str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }




}
