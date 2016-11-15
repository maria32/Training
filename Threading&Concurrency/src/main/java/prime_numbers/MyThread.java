package prime_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martanase on 11/10/2016.
 */
public class MyThread extends Thread {

    private int id;
    private int noOfThreads;
    private List<Integer> primaryList;
    private List<Integer> primeNumbers;

    public MyThread(int noOfThreads, int id, String name, List<Integer> primaryList, List<Integer> primeNumbers) {
        this.noOfThreads = noOfThreads;
        this.id = id;
        this.primaryList = primaryList;
        this.primeNumbers = primeNumbers;
        setName(name);
    }

    public void addPrimeNumber(Integer a){
        primeNumbers.add(a);
    }

    public void run(){
        System.out.println(getName() + " started.");
        for(int i = (id*primaryList.size())/noOfThreads; i < ((id+1)*primaryList.size())/noOfThreads; i++){
            if(isPrime(primaryList.get(i))) {
                synchronized (primeNumbers) {
                    addPrimeNumber(primaryList.get(i));
                    System.out.println(getName() + ":\t" + primeNumbers.toString());
                }

            }
        }
        System.out.println(getName() + " finished.");
    }

    private boolean isPrime(int n){
        if(n == 0)
            return false;
        for(int i = 2; i <= n/2; i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(List<Integer> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }
}
