package ListaDobleCircular;

import java.util.Scanner;

public class MainListaDobleC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDobleCircular<Integer> list = new ListaDobleCircular<Integer>();

        System.out.println("=== DEMOSTRACIÓN ListaDobleCircular ===");
        pausa(sc);

        System.out.println("\n[1] agregarInicio(10)");
        list.agregarInicio(10);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[2] agregarFinal(30)");
        list.agregarFinal(30);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[3] agregar(1, 20)");
        list.agregar(1, 20);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[4] obtenerValorNodo(1)");
        int valor = list.obtenerValorNodo(1);
        System.out.println("-> Valor en índice 1: " + valor);
        pausa(sc);

        System.out.println("\n[5] obtenerPosicionNodo(20)");
        int pos = list.obtenerPosicionNodo(20);
        System.out.println("-> Posición del valor 20: " + pos);
        pausa(sc);

        System.out.println("\n[6] modificarNodo(1, 25)");
        list.modificarNodo(1, 25);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[7] agregarFinal(5), agregarFinal(40)");
        list.agregarFinal(5);
        list.agregarFinal(40);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[8] eliminarPrimero()");
        list.eliminarPrimero();
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[9] eliminarUltimo()");
        list.eliminarUltimo();
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[10] eliminar(25)");
        list.eliminar(25);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[11] agregarFinal(15), agregarFinal(3), agregarFinal(8)");
        list.agregarFinal(15);
        list.agregarFinal(3);
        list.agregarFinal(8);
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[12] ordenarLista()");
        list.ordenarLista();
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n[13] borrarLista()");
        list.borrarLista();
        list.imprimirLista();
        pausa(sc);

        System.out.println("\n=== FIN DEMOSTRACIÓN ListaDobleCircular ===");
        sc.close();
    }

    private static void pausa(Scanner sc) {
        System.out.println("Presiona ENTER para continuar...");
        sc.nextLine();
    }
}
