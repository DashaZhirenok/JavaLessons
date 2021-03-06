package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Duska on 24.09.2017.
 */
public class GratestCommonDivisor {

    public static void main(String[] args) throws  IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите 1 число");
        String sFirst = reader.readLine();
        int first = Integer.parseInt(sFirst);

        System.out.println("Введите 2 число");
        String sSecond = reader.readLine();
        int second = Integer.parseInt(sSecond);

        int myRest = gcd_1(first,second);
        System.out.println("1. Наибольший общий делитель, используя '%': " + myRest);

        myRest=gcd_2(first,second);
        System.out.println("1. Наибольший общий делитель, используя 'Math.floorMod': " + myRest);

        myRest=gcd_3(first,second);
        System.out.println("1. Наибольший общий делитель, используя 'Math.IEEEremainder': " + myRest);
    }

    /**
     * gsd with " % "
     * @param first
     * @param second
     * @return
     */
    public static int gcd_1(int first, int second){

        int rest = 0;
        first = Math.abs(first);
        second = Math.abs(second);
        //если остаток от деления == 0, выходим из алгоритма
        if (second == 0)
            return first;

        rest = first % second;
        //рекурсивно вызовем gcd
        return gcd_1(second,rest);
    }

    /**
     * gsd with " floorMod "
     * @param first
     * @param second
     * @return
     */
    public static int gcd_2(int first, int second){

        int rest = 0;
        first = Math.abs(first);
        second = Math.abs(second);
        if (second == 0)
            return first;

        rest = Math.floorMod(first,second);

        return gcd_2(second, rest);
    }

    /**
     * gsd with " Rem "
     * @param first
     * @param second
     * @return
     */
    public static int gcd_3(int first, int second){

        int rest = 0;

        if (second == 0)
            return first;

        rest = (int) Math.IEEEremainder(first, second);

        return gcd_3(second, rest);
    }

}
