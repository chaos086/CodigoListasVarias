package ListaDobleCircular;

import ListaDoble.NodoDoble;

import java.util.Iterator;

public class ListaDobleCircular<T> implements Iterable<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public ListaDobleCircular() {
        head = tail = null;
        size = 0;
    }

    // 1. Agregar al inicio
    public void agregarInicio(T data) {
        NodoDoble<T> nuevo = new NodoDoble<>(data);
        if (head == null) {
            head = tail = nuevo;
            head.next = head.prev = head;
        } else {
            nuevo.next = head;
            nuevo.prev = tail;
            head.prev = nuevo;
            tail.next = nuevo;
            head = nuevo;
        }
        size++;
    }

    // 2. Agregar al final
    public void agregarFinal(T data) {
        NodoDoble<T> nuevo = new NodoDoble<>(data);
        if (tail == null) {
            head = tail = nuevo;
            head.next = head.prev = head;
        } else {
            nuevo.prev = tail;
            nuevo.next = head;
            tail.next = nuevo;
            head.prev = nuevo;
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
        NodoDoble<T> actual = head;
        if (index < size / 2) {
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
        if (head == null) return -1;
        do {
            if (actual.data.equals(data)) return index;
            actual = actual.next;
            index++;
        } while (actual != head);
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
            head.prev = tail;
            tail.next = head;
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
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    // 11. Eliminar por valor
    public void eliminar(T data) {
        if (head == null) return;
        NodoDoble<T> actual = head;
        do {
            if (actual.data.equals(data)) {
                if (actual == head) { eliminarPrimero(); return; }
                if (actual == tail) { eliminarUltimo(); return; }
                actual.prev.next = actual.next;
                actual.next.prev = actual.prev;
                size--;
                return;
            }
            actual = actual.next;
        } while (actual != head);
    }

    // 12. Modificar nodo
    public void modificarNodo(int index, T nuevoDato) {
        obtenerNodo(index).data = nuevoDato;
    }

    // 13. Ordenar lista (burbuja)
    @SuppressWarnings("unchecked")
    public void ordenarLista() {
        if (size <= 1) return;
        for (int i = 0; i < size; i++) {
            NodoDoble<T> actual = head;
            for (int j = 0; j < size - 1; j++) {
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
        do {
            System.out.print(actual.data + " <-> ");
            actual = actual.next;
        } while (actual != head);
        System.out.println("(circular)");
    }

    // 15. Iterador
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodoDoble<T> actual = head;
            boolean primerPaso = true;

            public boolean hasNext() {
                return actual != null && (primerPaso || actual != head);
            }

            public T next() {
                T data = actual.data;
                actual = actual.next;
                primerPaso = false;
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
