package Task2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        try {
            names = Files.readAllLines(Paths.get("names.txt"));
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        System.out.printf("Origin content of list: %s\n", names);

        long myNameCount = names.stream().filter(s -> s.equalsIgnoreCase("Александр")).count();
        System.out.printf("Peoples with name Александр: %d\n", myNameCount);

        List<String> result = names.stream().filter(s -> s.toLowerCase().startsWith("а")).toList();
        System.out.printf("Names starts with 'a' or 'A': %s\n", result);

        //names.clear();

        String first = names.stream().sorted(String::compareTo).findFirst().orElse("Empty");
        System.out.printf("The first name from sorted stream: %s", first);

    }
}
