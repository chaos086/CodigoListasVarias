    package ListaSimple;

    import java.util.Iterator;

    /**
     * ListaSimple - Generic Singly Linked List
     *
     * Español: Esta clase implementa una lista simplemente enlazada genérica con varias operaciones.
     * English: This class implements a generic singly linked list with multiple operations.
     */
    public class ListaSimple<T extends Comparable<T>> implements Iterable<T> {
        public Nodo<T> head;
        private int size;

        public ListaSimple() {
            this.head = null;
            this.size = 0;
        }

        // 1. AddFirst / Agregar al inicio
        public void addFirst(T value) {
            Nodo<T> newNode = new Nodo<>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // 2. AddLast / Agregar al final
        public void addLast(T value) {
            Nodo<T> newNode = new Nodo<>(value);
            if (isEmpty()) {
                head = newNode;
            } else {
                Nodo<T> aux = head;
                while (aux.next != null) aux = aux.next;
                aux.next = newNode;
            }
            size++;
        }

        // 3. AddAt / Insertar en posición
        public void addAt(int index, T value) {
            if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
            if (index == 0) {
                addFirst(value);
            } else {
                Nodo<T> newNode = new Nodo<>(value);
                Nodo<T> aux = head;
                for (int i = 0; i < index - 1; i++) aux = aux.next; // Español: buscar la posición anterior / English: find the previous node
                newNode.next = aux.next;
                aux.next = newNode;
                size++;
            }
        }

        // 4. GetValueAt / Obtener valor en posición
        public T getValueAt(int index) {
            return getNode(index).data;
        }

        // 5. GetNode / Obtener nodo
        private Nodo<T> getNode(int index) {
            if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
            Nodo<T> aux = head;
            for (int i = 0; i < index; i++) aux = aux.next;
            return aux;
        }

        // 6. GetIndexOfValue / Obtener índice de un valor
        public int getIndexOfValue(T value) {
            Nodo<T> aux = head;
            int pos = 0;
            while (aux != null) {
                if (aux.data.equals(value)) return pos;
                aux = aux.next;
                pos++;
            }
            return -1; // Español: no encontrado / English: not found
        }

        // 7. isValidIndex / Verificar índice válido
        public boolean isValidIndex(int index) {
            return index >= 0 && index <= size;
        }

        // 8. isEmpty / Verificar si lista está vacía
        public boolean isEmpty() {
            return size == 0;
        }

        // 9. removeFirst / Eliminar primer nodo
        public void removeFirst() {
            if (!isEmpty()) {
                head = head.next; // Español: mover cabeza al next nodo / English: move head to next node
                size--;
            }
        }

        // 10. removeLast / Eliminar último nodo
        public void removeLast() {
            if (!isEmpty()) {
                if (size == 1) {
                    head = null; // Español: si hay un solo nodo se borra / English: if only one node, set to null
                } else {
                    Nodo<T> aux = head;
                    while (aux.next.next != null) aux = aux.next; // Español: recorrer hasta penúltimo / English: traverse to second last
                    aux.next = null; // Español: desconectar último nodo / English: unlink last node
                }
                size--;
            }
        }

        // 11. removeByValue / Eliminar por valor
        public void removeByValue(T value) {
            if (!isEmpty()) {
                if (head.data.equals(value)) {
                    removeFirst();
                } else {
                    Nodo<T> aux = head;
                    while (aux.next != null && !aux.next.data.equals(value))
                        aux = aux.next;
                    if (aux.next != null) {
                        aux.next = aux.next.next; // Español: saltar el nodo a eliminar / English: skip the node to remove
                        size--;
                    }
                }
            }
        }

        // 12. updateNodeAt / Modificar nodo en posición
        public void updateNodeAt(int index, T newValue) {
            Nodo<T> aux = getNode(index);
            aux.data = newValue; // Español: reemplazar el valor / English: replace the value
        }

        // 13. sortList / Ordenar lista (burbuja simple)
        public void sortList() {
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    Nodo<T> current = head;
                    Nodo<T> next = head.next;
                    for (int j = 0; j < size - i - 1; j++) {
                        if (current.data.compareTo(next.data) > 0) {
                            // Español: intercambiar valores / English: swap values
                            T temp = current.data;
                            current.data = next.data;
                            next.data = temp;
                        }
                        current = next;
                        next = next.next;
                    }
                }
            }
        }

        // 14. printList / Imprimir lista
        public void printList() {
            Nodo<T> aux = head;
            while (aux != null) {
                System.out.print(aux.data + " -> ");
                aux = aux.next;
            }
            System.out.println("null");
        }

        // 15. iterator / Iterador
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Nodo<T> current = head;
                public boolean hasNext() { return current != null; }
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        public void clearList() {
            head = null;
            size = 0;
        }

        public Nodo<T> invertirRecursivo(Nodo<T> nodo) {
            if (nodo == null || nodo.next == null) {
                return nodo;
            }

            Nodo<T> nuevaCabeza = invertirRecursivo(nodo.next);

            nodo.next.next = nodo;
            nodo.next = null;

            return nuevaCabeza;
        }

        public void invertir() {
            head = invertirRecursivo(head);
        }
    }