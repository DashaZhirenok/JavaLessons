package task9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Duska on 07.10.2017.
 */
public class StreamZip {
    public static void main(String[] args) {
        Stream<Integer> integers = IntStream.range(1, 9).boxed();

        Stream<Integer> integers2 = IntStream.range(1, 9).boxed();

        Stream<String> zipStream = zip(integers, integers2);
        zipStream.forEach(x -> System.out.println(x));

    };

    /**
     * @param first
     * @param second
     * @return
     */
    public static Stream<String> zip(Stream<Integer> first, Stream<Integer> second){
        Iterator<Integer> firstIt = first.iterator();
        Iterator<Integer> secondIt = second.iterator();
        Iterator<String> It = new Iterator<String>() {
            boolean isFirst = true;
            public boolean hasNext(){
                if(isFirst) return firstIt.hasNext();
                return secondIt.hasNext();
            }
            public String next(){
                if (isFirst){
                    isFirst = false;
                    return String.valueOf(firstIt.next());
                }
                isFirst = true;
                return String.valueOf(secondIt.next());
            }
        };
        Iterable<String> iterable = ()-> It;
        Spliterator<String> spliterator = iterable.spliterator();
        return StreamSupport.stream(spliterator, false);
    }

}
