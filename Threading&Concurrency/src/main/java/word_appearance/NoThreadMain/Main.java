package word_appearance.NoThreadMain;

import word_appearance.WordThread;

import java.io.File;
import java.util.*;

/**
 * Created by martanase on 11/15/2016.
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("word_appearance.in");

        Map<String, Integer> wordsMap = new HashMap<String, Integer>();

        long startTime = System.currentTimeMillis();
        try{
            Scanner scanner  = new Scanner(file);
            while(scanner.hasNext()){
                String word = scanner.next().replaceAll("[.,?()!\"]", "");
                if(wordsMap.containsKey(word)){
                    wordsMap.put(word, wordsMap.get(word)+1);
                }
                else {
                    wordsMap.put(word, 1);
                }
            }
            System.out.println("Nr cuvinte: " + wordsMap.size());
            System.out.println(wordsMap.entrySet());
        }catch(Exception e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\n\n---------------------------------\ntime of execution: " + elapsedTime);


    }
}
