package task4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Duska on 24.09.2017.
 */
public class MyStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**
         * Operations with words
         * Read and write to Stream. + console output
         */
        System.out.println("Enter words, please");
        String words = sc.nextLine();
        String[] arrayWithWords = words.split(" ");

        Stream <String> streamWithWords = Stream.of(arrayWithWords);
        streamWithWords.forEach(System.out::println);


        /**
         * Operations with lines
         * Read and write to Stream. + console output
         */
        System.out.println("Enter 3 lines, please");
        ArrayList<String> lines = new ArrayList<String>();

        for(int i=0; i<3; i++) {
                String line = sc.nextLine();
                lines.add(line);

        }
        lines.stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /**
         * Operations with integers
         * Read and write to Stream. + console output
         */
        System.out.println("Enter integers, please");
        String sIntegers = sc.nextLine();
        String[] aIntegers = sIntegers.split(" ");

        Stream<String> streamWithIntegers = Stream.of(aIntegers);
        try {
            streamWithIntegers.mapToInt(Integer::parseInt)
                    .forEach(System.out::println);
        }
        catch (Exception e){
            System.err.println("Incorrect type");
        }

        /**
         * Operations with doubles
         * Read and write to Stream. + console output
         */
        System.out.println("Enter doubles, please");
        String sDoubles = sc.nextLine();
        String[] aDoubles = sDoubles.split(" ");

        Stream <String> streamWithDoubles = Stream.of(aDoubles);
        try {
            streamWithDoubles.mapToDouble(Double::parseDouble)
                    .forEach(System.out::println);
        }
        catch (Exception e){
            System.err.println("Incorrect type");
        }

    }
}
