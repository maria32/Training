package prime_numbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by martanase on 11/10/2016.
 */
public class Main {

    public static void main(String[] args) {

        List<MyThread> myThreads = new ArrayList<MyThread>();

        File file = new File("prime_numbers.in");
        try {
            //read array list from file
            Scanner scanner = new Scanner(file);
            List<Integer> numbersList = new ArrayList<Integer>();
            while(scanner.hasNextInt()){
                numbersList.add(scanner.nextInt());
            }

            //set no of threads
            int noOfThreads = 3;
            List<Integer> primeNumbers = new ArrayList<Integer>();
            System.out.println("number of elements in list: "+ numbersList.size());
            for (int i = 0; i < noOfThreads ; i++){
                //creare thread
                myThreads.add(new MyThread(noOfThreads, i, "Thread" + i, numbersList, primeNumbers));
                myThreads.get(myThreads.size()-1).start();
            }
            for (int i = 0; i < noOfThreads ; i++){
                try {
                    myThreads.get(i).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Prime numbers found:" + myThreads.get(0).getPrimeNumbers().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}
