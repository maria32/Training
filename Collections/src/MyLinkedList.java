import sun.misc.Queue;

import javax.management.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by martanase on 10/31/2016.
 */
public class MyLinkedList<E>{

    private int total = 0;
    private Node<E> first;
    private Node<E> last;


    public int getTotal(){
        return total;
    }

    public E getFirst(){
        return first.getValue();
    }

    public E getLast(){
        return last.getValue();
    }

    public boolean add(E e) throws Exception{
        try{
            if(first == null){
                first = new Node<E>(null, e);
            } else if(last == null) {
                last = new Node<E>(first, e);
                first.setNext(last);
            } else {
                Node<E> temp = last;
                last = new Node<E>(last, e);
                last.setPrevious(temp);
                last.getPrevious().setNext(last);
            }
            total++;
            return true;
        }catch(Exception err){
            System.out.println(err);
            return false;
        }

    }

    public E get(int index){
        int counter = 0;
        Node<E> node = first;

        while(node != null){
            if(counter == index){
                return node.getValue();
            }
            counter++;
            node = node.getNext();
        }
        return null;
    }

    //retrieves and removes the head of this queue
    public E remove(){
        if(total == 0) throw new java.util.NoSuchElementException();
        E last_elem = last.getValue();
        last = last.getPrevious();
        total--;
        return last_elem;
    }

    //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    public E peek(){
        if (total == 0)
            return null;
        else
            return last.getValue();
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        Node<E> node = first;
        while (node != null) {
            s.append(node.getValue().toString() + " ");
            node = node.getNext();
        }
        return s.toString();
//        StringBuilder string = null;
//        Node<E> node = first;
//        for(int i = 0; i < total; i++){
//            string.append(node.getValue()).append(" ");
//            node = first.getNext();
//        }
//        return "MyLinkedList{" + string + '}';
    }
}
