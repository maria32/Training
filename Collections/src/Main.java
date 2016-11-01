import sun.misc.Queue;

/**
 * Created by martanase on 10/31/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        //ex1
        MyLinkedList<Integer> q = new MyLinkedList<Integer>();
        q.add(3);
        q.add(5);
        q.add(8);
        System.out.println("toString: " + q.toString());
        System.out.println("\tfirst = " + q.getFirst());
        System.out.println("\tlast = " + q.getLast());

        //ex2 grafuri neorientate
        UnorientedGraph myGraph = new UnorientedGraph();
        myGraph.print();

        //ex3
        XorCryption text = new XorCryption();

    }
}
