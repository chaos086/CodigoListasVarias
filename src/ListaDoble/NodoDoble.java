package ListaDoble;

public class NodoDoble<T> {
    public T data;
    public NodoDoble<T> next;
    public NodoDoble<T> prev;

    public NodoDoble(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
