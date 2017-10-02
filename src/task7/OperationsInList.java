package task7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Duska on 02.10.2017.
 */
public class OperationsInList{
    private static final String S_PATH = "D:\\Project\\JavaLesson\\src\\task6\\AmountOfSymbols.java";
    public static void main(String[] args) throws FileNotFoundException {

        OperationsInList operationsInList = new OperationsInList();
        ArrayList<String> newArray = new ArrayList<>();
        newArray = operationsInList.readFromFileAndWriteInList(S_PATH);

        System.out.println(newArray);

    }

    private static ArrayList readFromFileAndWriteInList(String sPath) throws FileNotFoundException {

        File file = new File(sPath);
        ArrayList<String> tmpArray = new ArrayList<>();

        try{
            BufferedReader fin = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String tmp = "";

            while ((tmp = fin.readLine()) !=  null){
                tmpArray.add(tmp);
            }

        }
        catch (Exception e){

        }

        return tmpArray;
    }
}
