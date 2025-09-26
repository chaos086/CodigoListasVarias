package ListaSimple;

public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    //Agrega al final
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    //Elimina nodo por valor
    public void eliminar(int dato) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Primer Caso: el nodo a eliminar es la cabeza
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }

        // segundo Caso: buscar en el resto de la lista
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            System.out.println("El elemento no se encontró en la lista.");
        } else {
            // "Saltar" el nodo encontrado
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    //Mostrarlista
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
/// 
}