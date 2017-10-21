package task2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Duska on 24.09.2017.
 */
public class Rot13 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите строку для кодирования");
        String encodedLine = reader.readLine();
        System.out.println(rot13(encodedLine));

        System.out.println("Введите строку для декодирования");
        String decodedLine = reader.readLine();
        System.out.println(rot13(decodedLine));

        //перевод из 16-ричной в 10
        try{
            System.out.println(Integer.parseInt("478", 16));
        }
        catch (Exception e){
            System.err.println(e);
        }

    }

    /**
     * This method decode and encode current line
     * @param encodeLine
     * @return
     */
    public static String rot13(String encodeLine){
        String line = "";
        for (int i = 0; i < encodeLine.length(); i++) {
            char c = encodeLine.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            line +=c;
        }
        return line;
    }
}

