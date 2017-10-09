package task9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Duska on 07.10.2017.
 */
public class StreamZip {
    public static void main(String[] args) {

        String[] arr = {"1", "3", "5"};
        String[] arr2 = {"2", "4", "6"};

        Stream<String> first = Stream.of(arr);
        Stream<String> second = Stream.of(arr2);

        Stream<String> newStream = zip(first, second);

        newStream.map(s->s.toString())
                .forEach(System.out::println);
    }

    /**
     * create method that alternates elements from the streams first and second
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        List<T> newList = new ArrayList<>();

        //getting elements from stream
        List<T> listFirst = first
                .collect(Collectors.toList());

        List<T> listSecond = second
                .collect(Collectors.toList());

        int n = listFirst.size(), sizeOfList;
        int n2 = listSecond.size();
        if(n>n2) sizeOfList = n;

        else sizeOfList = n2;

        //writing elements from two lists to one list
        for(int i=0; i<sizeOfList; i++){
            newList.add(listFirst.get(i));
            newList.add(listSecond.get(i));
        }

        Stream<T> newStream = newList.stream();
        return newStream;

    }
}
