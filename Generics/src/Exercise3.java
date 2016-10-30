/**
 * Created by martanase on 10/28/2016.
 */
public class Exercise3 {
    public <T> void exchange(T[] array, int a, int b){
        T aux = array[a];
        array[a] = array[b];
        array[b] = aux;
    }
}
