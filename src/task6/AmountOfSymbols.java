package task6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Duska on 02.10.2017.
 */
public class AmountOfSymbols {

    private static final Path sPathOfDirectory = Paths.get("D:\\Project\\JavaLesson");
    private static final Path sPathOfFile = Paths.get("D:\\Project\\JavaLesson\\src\\task6\\AmountOfSymbols.java");

    public static void main(String[] args) throws IOException {
        AmountOfSymbols amountOfSymbols = new AmountOfSymbols();
        List<String> list;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter symbols or part of line");

        String currentLine = reader.readLine();
        list = amountOfSymbols.listWithFiles(sPathOfDirectory);
        System.out.println("The number of repetitions in all files: " + amountOfSymbols.myCountInFile(currentLine, list));
        list = amountOfSymbols.listWithFiles(sPathOfFile);
        System.out.println("The number of repetitions in current file: " + amountOfSymbols.myCountInFile(currentLine, list));
    }

    /**
     * This method returns List with all files in directory
     * @param sPath
     * @return
     * @throws IOException
     */

    private List listWithFiles(Path sPath) throws IOException {

        List<String> list = Files.walk(sPath.toAbsolutePath())
                .map(s->s.toString())
                .filter((s)->(s.contains(".")&&!s.contains(".git")&&!s.contains(".idea")))
                .collect(Collectors.toList());

        return list;
    }

    private int myCountInFile(String symbol, List<String> list) throws FileNotFoundException {
        int count = 0;

        /**
         * loop for counting all symbols in all files
         */

        for (int i=0; i<list.size(); i++){
            File file = new File(list.get(i));

            try {
                BufferedReader fin = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                String tmp;

                //reading data from current file and counting
                while ( (tmp = fin.readLine()) != null ){
                    if(tmp.contains(symbol))
                        count++;
                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }

        return count;
    }
}
