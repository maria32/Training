/**
 * Created by martanase on 10/31/2016.
 */
public class Node<E> {

    private E value;
    private Node<E> previous;
    private Node<E> next;

    public Node(Node<E> previous, E e){
        this.previous = previous;
        this.value = e;
        this.next = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
