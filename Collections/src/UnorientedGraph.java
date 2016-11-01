import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by martanase on 11/1/2016.
 */
public class UnorientedGraph {
    private int nrVarfuri;
    private int nrMuchii;
    private MyLinkedList<Integer> muchii[];

    public UnorientedGraph() throws Exception {

        Scanner scanner = new Scanner(new File("graph-date.in"));
        this.nrVarfuri = scanner.nextInt();
        this.nrMuchii = scanner.nextInt();

        muchii = new MyLinkedList[this.nrVarfuri];
        Integer a, b;
        for(int i = 0; i < this.nrMuchii;  i++){
            a = scanner.nextInt();
            b = scanner.nextInt();

            if(muchii[a-1] == null)
                muchii[a-1] = new MyLinkedList<>();
            muchii[a-1].add(b);

            if(muchii[b-1] == null)
                muchii[b-1] = new MyLinkedList<>();
            muchii[b-1].add(a);
        }
        scanner.close();
    }

    public void print() {
        try (PrintWriter writer = new PrintWriter("date.out")) {
            int i = 1;
            for (MyLinkedList nod : muchii) {
                writer.print(i + ": ");
                writer.println(nod.toString());
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
