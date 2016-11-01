import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by martanase on 11/1/2016.
 */
public class XorCryption {


    public XorCryption(){

        String myText = "";
        try (BufferedReader text = new BufferedReader(new FileReader("xor-date.in"))){

            StringBuilder sb = new StringBuilder();
            String line = text.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = text.readLine();
            }
            myText = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner typedKey = new Scanner(System.in);
        System.out.println("Type key: ");
        String key = typedKey.nextLine();
        ArrayList results= new ArrayList<Integer>();
        for(int i=0;i<myText.length();i++){
            char xoredChar = (char) (myText.charAt(i) ^ key.charAt(i%key.length()));
            results.add((int) xoredChar);
        }
        System.out.println(results.toString());
    }
}
