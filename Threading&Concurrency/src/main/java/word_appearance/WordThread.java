package word_appearance;

import java.util.List;
import java.util.Map;

/**
 * Created by martanase on 11/15/2016.
 */
public class WordThread extends Thread{

    private int id;
    private int noOfThreads;
    List<String> wordsList;
    Map<String, Integer> wordsMap;

    public WordThread(int noOfThreads, int id, String name, List<String> wordsList, Map<String, Integer> wordsMap) {
        this.noOfThreads = noOfThreads;
        this.id = id;
        this.wordsList = wordsList;
        this.wordsMap = wordsMap;
        setName(name);
    }

    public void run(){
        System.out.println(getName() + " started.");
        for(int i = (id*wordsList.size())/noOfThreads; i < ((id+1)*wordsList.size())/noOfThreads; i++){
            synchronized (wordsMap) {
                System.out.println("**" + getName() + "\tchecking \t" + i + ":\t " + wordsList.get(i));
                wordsMap.put(wordsList.get(i), wordsMap.get(wordsList.get(i))+1);
            }
        }
        System.out.println(getName() + " finished.");
    }

}
