package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(20, 50);
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 20));
        }
        System.out.printf("Origin content of list: %s\n", list);

        List<Integer> result = list.stream().distinct().toList();
        System.out.printf("Only unique elements: %s\n", result);

        result = list.stream().limit(17).skip(6).filter(i -> i % 2 == 0).toList();
        System.out.printf("Even elements from 7 to 17: %s\n", result);

        result = list.stream().filter(i -> i >= 7 && i < 17 && i % 2 == 0).toList();
        System.out.printf("Even elements from 7 to 17: %s\n", result);

        result = list.stream().map(i -> i * 2).toList();
        System.out.printf("Every element multiple by 2: %s\n", result);

        result = list.stream().sorted(Integer::compareTo).limit(4).toList();
        System.out.printf("First 4 sorted elements: %s\n", result);

        long count = list.stream().count();
        System.out.printf("The size of stream: %d\n", count);

        double avg = list.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.printf("The avg of stream elements: %.2f\n", avg);
    }

}
