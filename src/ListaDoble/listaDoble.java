package ListaDoble;

import java.util.Iterator;

public class listaDoble<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public listaDoble() {
        head = tail = null;
        size = 0;
    }

    // 1. Agregar al inicio
    public void agregarInicio(T data) {
        NodoDoble<T> nuevo = new NodoDoble<>(data);
        if (head == null) {
            head = tail = nuevo;
        } else {
            nuevo.next = head;
            head.prev = nuevo;
            head = nuevo;
        }
        size++;
    }

    // 2. Agregar al final
    public void agregarFinal(T data) {
        NodoDoble<T> nuevo = new NodoDoble<>(data);
        if (tail == null) {
            head = tail = nuevo;
        } else {
            tail.next = nuevo;
            nuevo.prev = tail;
            tail = nuevo;
        }
        size++;
    }

    // 3. Agregar en posición
    public void agregar(int index, T data) {
        if (!indiceValido(index)) throw new IndexOutOfBoundsException();
        if (index == 0) { agregarInicio(data); return; }
        if (index == size) { agregarFinal(data); return; }

        NodoDoble<T> nuevo = new NodoDoble<>(data);
        NodoDoble<T> actual = obtenerNodo(index);
        NodoDoble<T> anterior = actual.prev;

        anterior.next = nuevo;
        nuevo.prev = anterior;
        nuevo.next = actual;
        actual.prev = nuevo;
        size++;
    }

    // 4. Obtener valor nodo
    public T obtenerValorNodo(int index) {
        return obtenerNodo(index).data;
    }

    // 5. Obtener nodo
    private NodoDoble<T> obtenerNodo(int index) {
        if (!indiceValido(index)) throw new IndexOutOfBoundsException();
        NodoDoble<T> actual;
        if (index < size / 2) {
            actual = head;
            for (int i = 0; i < index; i++) actual = actual.next;
        } else {
            actual = tail;
            for (int i = size - 1; i > index; i--) actual = actual.prev;
        }
        return actual;
    }

    // 6. Obtener posición de un valor
    public int obtenerPosicionNodo(T data) {
        NodoDoble<T> actual = head;
        int index = 0;
        while (actual != null) {
            if (actual.data.equals(data)) return index;
            actual = actual.next;
            index++;
        }
        return -1;
    }

    // 7. Validar índice
    private boolean indiceValido(int index) {
        return index >= 0 && index <= size;
    }

    // 8. Está vacía
    public boolean estaVacia() { return size == 0; }

    // 9. Eliminar primero
    public void eliminarPrimero() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // 10. Eliminar último
    public void eliminarUltimo() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // 11. Eliminar por valor
    public void eliminar(T data) {
        NodoDoble<T> actual = head;
        while (actual != null && !actual.data.equals(data)) {
            actual = actual.next;
        }
        if (actual == null) return;

        if (actual == head) { eliminarPrimero(); return; }
        if (actual == tail) { eliminarUltimo(); return; }

        actual.prev.next = actual.next;
        actual.next.prev = actual.prev;
        size--;
    }

    // 12. Modificar nodo
    public void modificarNodo(int index, T nuevoDato) {
        obtenerNodo(index).data = nuevoDato;
    }

    // 13. Ordenar lista (burbuja)
    public void ordenarLista() {
        if (size <= 1) return;
        for (int i = 0; i < size; i++) {
            NodoDoble<T> actual = head;
            while (actual.next != null) {
                Comparable<T> a = (Comparable<T>) actual.data;
                if (a.compareTo(actual.next.data) > 0) {
                    T temp = actual.data;
                    actual.data = actual.next.data;
                    actual.next.data = temp;
                }
                actual = actual.next;
            }
        }
    }

    // 14. Imprimir lista
    public void imprimirLista() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoDoble<T> actual = head;
        while (actual != null) {
            System.out.print(actual.data + " <-> ");
            actual = actual.next;
        }
        System.out.println("null");
    }

    // 15. Iterador
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            NodoDoble<T> actual = head;
            public boolean hasNext() { return actual != null; }
            public T next() {
                T data = actual.data;
                actual = actual.next;
                return data;
            }
        };
    }

    // 16. Borrar lista
    public void borrarLista() {
        head = tail = null;
        size = 0;
    }
}
