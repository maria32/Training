/**
 * Created by martanase on 10/30/2016.
 */
public class PrimePredicate implements UnaryPredicate<Integer> {

    public boolean test(Integer nr){

        if(nr <= 2)
            return false;
        for(int i = 2; i <= (nr / 2); i++){
            if(nr % i == 0)
                return false;
        }
        return true;
    }
}
