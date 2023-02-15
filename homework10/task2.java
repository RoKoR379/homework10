package homework10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static ArrayList<UserDto> readUsers(String path) throws FileNotFoundException {
        ArrayList<UserDto> userDtos = new ArrayList<UserDto>();
        File file = new File("src/main/java/homework10/test2.txt");
        Scanner inputFile;
        String name;
        Integer age;

        if (file.exists()) {
            inputFile = new Scanner(file);
            inputFile.next();
            inputFile.next();
            while (inputFile.hasNext() ) {
                name = inputFile.next();
                age = Integer.valueOf(inputFile.next());
                userDtos.add(new UserDto(name, age));
            }

        }
        return userDtos;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<UserDto> userDtos;

        userDtos = readUsers("src/homework10/test2.txt");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(userDtos);
        System.out.println("toJson = " + toJson);

        FileWriter fileWriter = new FileWriter("users.json");
        gson.toJson(userDtos, fileWriter);
        fileWriter.close();

    }

}
