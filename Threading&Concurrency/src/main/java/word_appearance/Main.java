package word_appearance;

import java.io.File;
import java.util.*;

/**
 * Created by martanase on 11/15/2016.
 */
public class Main {

    public static void main(String[] args) {

        List<WordThread> myThreads = new ArrayList<WordThread>();

        File file = new File("word_appearance.in");

        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        List<String> wordsList = new ArrayList<String>();

        long startTime = 0;
        try{
            Scanner scanner  = new Scanner(file);
            while(scanner.hasNext()){
                String word = scanner.next().replaceAll("[.,?()!\"]", "");
                wordsList.add(word);
                wordsMap.put(word, 0);

            }
            System.out.println("Nr cuvinte: " + wordsMap.size());
            System.out.println(wordsMap.entrySet());

            startTime = System.currentTimeMillis();
            //set no of threads
            int noOfThreads = 2;
            System.out.println("\n-------------------\nnumber of elements in list: "+ wordsList.size());
            for (int i = 0; i < noOfThreads ; i++){
                //creare thread
                myThreads.add(new WordThread(noOfThreads, i, "Thread" + i, wordsList, wordsMap));
                myThreads.get(myThreads.size()-1).start();
            }
            for (int i = 0; i < noOfThreads ; i++){
                try {
                    myThreads.get(i).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n-----------------------\nHashMap after threads.join():\n" + wordsMap.entrySet());
        }catch(Exception e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\n\n---------------------------------\ntime of execution: " + elapsedTime);
    }
}
