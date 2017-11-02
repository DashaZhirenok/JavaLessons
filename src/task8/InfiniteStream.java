package task8;

import java.util.stream.Stream;

/**
 * Created by Duska on 06.10.2017.
 */
public class InfiniteStream {

    public static void main(String[] args) {

        //2^48 - много для данной задачи, возьмем 2^12
        Long m =(long) Math.pow(2, 12);


        //сгенерируем псевдослучайные числа и установим лимит на кол-во - 35
        myRandom(0, 25214903917L, 11, m)
                .limit(35)
                .forEach(System.out::println);
    }

    private static Stream<Long> myRandom(long seed, long a, long c, long m) {

        Stream <Long> newRandomStream = Stream.iterate(seed, Xn -> (a * Xn + c) % m);
        return newRandomStream;
    }
}
