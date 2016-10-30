import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by martanase on 10/28/2016.
 */

/* nu functioneaza pentru ca ">" nu se poate folosi pentru primitive*/
//public final class Algorithm {
//    public static <T> T max(T x, T y) {
//        return x > y ? x : y;
//    }
//}

public final class Algorithm {

    public <T extends Comparable> T max(T x, T y) {
        return (x.compareTo(y) > 0) ? x : y;
    }

    public <T extends Object & Comparable<? super T>> T maxOfList(List<? extends T> list, int begin, int end){
        T max = list.get(begin);

        for(int i = begin + 1; i < end; i++){
            if(max.compareTo(list.get(i)) < 0){
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {

        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }

    //ex12
    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p){
        for(int i = begin; i < end; i++){
            if(p.test(list.get(i)))
                return i;
        }
        return -1;
    }

    public static int gcd(int a, int b){
        while(a != b){
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }


}
