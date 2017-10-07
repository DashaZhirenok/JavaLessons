package task7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Duska on 02.10.2017.
 */
public class OperationsInList{
    private static final String S_PATH = "D:\\Project\\JavaLesson\\src\\task6\\AmountOfSymbols.java";
    public static void main(String[] args) throws FileNotFoundException {

        OperationsInList operationsInList = new OperationsInList();

        operationsInList.readFromFileAndWriteInList(S_PATH, 7);

    }

    /**
     * This method reads lines from file(sPath) and them calls method randomLines
     * @param sPath
     * @param amountOfRows
     * @throws FileNotFoundException
     */
    private static void readFromFileAndWriteInList(String sPath, int amountOfRows) throws FileNotFoundException {

        File file = new File(sPath);
        ArrayList<String> tmpArray = new ArrayList<>();

        //добавить подсчет строк -> нединамическое выделение памяти

        //to read data from file and put into List
        try{
            BufferedReader fin = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String tmp = "";

            while ((tmp = fin.readLine()) !=  null){
                tmpArray.add(tmp);
            }

        }
        catch (Exception e){
            System.err.println(e);
        }

        randomLines(tmpArray, amountOfRows);
    }

    /**
     * This method generate random lines from current file
     * @param listWithLinesFromFile
     * @param amountOfRows
     */

    public static void randomLines(List<String> listWithLinesFromFile, int amountOfRows){
        Random rand = new Random();
        int num;

        for(int i=0; i<amountOfRows; i++){
            num = rand.nextInt(listWithLinesFromFile.size());
            System.out.println("1. The line number is " + num + ". Line: " + listWithLinesFromFile.get(num));
        }
    }
}
