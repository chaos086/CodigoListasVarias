import ListaSimple.ListaSimple;

public class Main {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);

        System.out.println("Lista original:");
        lista.mostrar();

        lista.eliminar(10); // eliminar cabeza
        System.out.println("Después de eliminar 10:");
        lista.mostrar();

        lista.eliminar(30); // eliminar nodo intermedio
        System.out.println("Después de eliminar 30:");
        lista.mostrar();

        lista.eliminar(50); // elemento inexistente
    }
}
