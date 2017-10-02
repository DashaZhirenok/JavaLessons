package task6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Duska on 02.10.2017.
 */
public class AmountOfSymbols {

    //private static final Path sPath = Paths.get("D:\\Project\\JavaLesson");
    private static final String sPath2 = "D:\\Project\\JavaLesson\\src\\task5\\OpenZip.java";

    public static void main(String[] args) throws IOException {
        AmountOfSymbols amountOfSymbols = new AmountOfSymbols();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter symbols or part of line");

        System.out.println("Amount of symbols or part of line: " + amountOfSymbols.myCountInFile(reader.readLine(), sPath2));
    }

    /*private long myCount(String symbol, Path sPath) throws IOException {
        long count = Files.walk(sPath)
                .map(s->s.toString())
                .filter((s) -> s.contains(symbol))
                .count();
        return count;
    }
*/
    private int myCountInFile(String symbol, String sPath) throws FileNotFoundException {
        int count = 0;
        File file = new File(sPath);

        try {
            BufferedReader fin = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String tmp;
            while ( (tmp = fin.readLine()) != null ){
                  if(tmp.contains(symbol))
                      count++;
            }
        }
        catch (Exception e){
            System.err.println(e);
        }


        return count;
    }
}
