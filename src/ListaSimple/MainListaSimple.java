package ListaSimple;

import java.util.Scanner;

/**
 * ListaSimple.MainListaSimple
 *
 * Español: Programa principal para probar ListaSimple paso a paso con mensajes en consola.
 */
public class MainListaSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaSimple<Integer> list = new ListaSimple<Integer>();

        System.out.println("=== DEMOSTRACIÓN ListaSimple ===");
        pausa(sc);

        System.out.println("\n[1] agregarInicio(10)");
        list.addFirst(10);
        list.printList();
        System.out.println("-> Se agregó 10 al inicio");
        pausa(sc);

        System.out.println("\n[2] agregarFinal(30)");
        list.addLast(30);
        list.printList();
        System.out.println("-> Se agregó 30 al final");
        pausa(sc);

        System.out.println("\n[3] agregarEnPosicion(1, 20)");
        list.addAt(1, 20);
        list.printList();
        System.out.println("-> Se insertó 20 en la posición 1");
        pausa(sc);

        System.out.println("\n[4] obtenerValorNodo(1)");
        int valor = list.getValueAt(1);
        System.out.println("-> El valor en el índice 1 es: " + valor);
        pausa(sc);

        System.out.println("\n[5] obtenerPosicionNodo(20)");
        int pos = list.getIndexOfValue(20);
        System.out.println("-> La posición del valor 20 es: " + pos);
        pausa(sc);

        System.out.println("\n[6] modificarNodo(1, 25)");
        list.updateNodeAt(1, 25);
        list.printList();
        System.out.println("-> Se cambió el valor en la posición 1 a 25");
        pausa(sc);

        System.out.println("\n[7] agregarFinal(5), agregarFinal(40)");
        list.addLast(5);
        list.addLast(40);
        list.printList();
        System.out.println("-> Se agregaron 5 y 40 al final");
        pausa(sc);

        System.out.println("\n[8] eliminarPrimero()");
        list.removeFirst();
        list.printList();
        System.out.println("-> Se eliminó el primer elemento");
        pausa(sc);

        System.out.println("\n[9] eliminarUltimo()");
        list.removeLast();
        list.printList();
        System.out.println("-> Se eliminó el último elemento");
        pausa(sc);

        System.out.println("\n[10] eliminarPorValor(25)");
        list.removeByValue(25);
        list.printList();
        System.out.println("-> Se eliminó el nodo con valor 25");
        pausa(sc);

        System.out.println("\n[11] agregarFinal(15), agregarFinal(3), agregarFinal(8)");
        list.addLast(15);
        list.addLast(3);
        list.addLast(8);
        list.printList();
        System.out.println("-> Se agregaron 15, 3 y 8");
        pausa(sc);

        System.out.println("\n[12] ordenarLista()");
        list.sortList();
        list.printList();
        System.out.println("-> La lista fue ordenada con burbuja");
        pausa(sc);

        System.out.println("\n[13] Prueba del método recursivo invertirRecursivo()");
        System.out.println("Antes de invertir:");
        list.clearList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        // Usamos el método invertir (ya encapsulado)
        list.invertir();
        System.out.println("Después de invertir recursivamente:");
        list.printList();
        pausa(sc);

        System.out.println("\n[14] borrarLista()");
        list.clearList();
        list.printList();
        System.out.println("-> Se eliminó toda la lista");
        pausa(sc);

        System.out.println("\n=== FIN DE DEMOSTRACIÓN ===");
        sc.close();
    }

    private static void pausa(Scanner sc) {
        System.out.println("\n[Presiona ENTER para continuar]");
        sc.nextLine();
    }
}
