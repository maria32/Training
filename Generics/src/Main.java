import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by martanase on 10/28/2016.
 */
public class Main {

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }


    public static void main(String[] args){

        //ex1
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        int count = Algorithm.countIf(ci, new PrimePredicate());
        System.out.println("Number of prime integers = " + count);

        String[] sList = {"Ana", "Raluca", "Margareta"};



        Exercise3 ex3 = new Exercise3();
        ex3.exchange(sList, 1, 2);
        System.out.println(sList[0] + sList[1] + sList[2]);

        //ex8
        Algorithm ex8 = new Algorithm();
        List<Long> sir = new ArrayList<>();
        sir.add(1L);
        sir.add(2L);
        sir.add(6L);
        sir.add(5L);

        System.out.println(ex8.maxOfList(sir, 0, 2));

        //ex12
        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate<Integer> p = new RelativelyPrimePredicate(c);

        int i = Algorithm.findFirst(li, 0, li.size(), p);

        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }

    }

}
