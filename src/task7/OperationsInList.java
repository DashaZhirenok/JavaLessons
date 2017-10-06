package task7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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


    private static void readFromFileAndWriteInList(String sPath, int amountOfRows) throws FileNotFoundException {

        File file = new File(sPath);
        ArrayList<String> tmpArray = new ArrayList<>();

        //добавить подсчет строк -> нединамическое выделение памяти

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

        Random rand = new Random();
        int num;

        for(int i=0; i<amountOfRows; i++){
            num = rand.nextInt(tmpArray.size());
            System.out.println("1. The line number is " + num + ". Line: " + tmpArray.get(num));
        }

    }
}
