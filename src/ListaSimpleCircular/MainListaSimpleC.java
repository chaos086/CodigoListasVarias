package ListaSimpleCircular;

import ListaSimple.ListaSimple;

import java.util.Scanner;

public class MainListaSimpleC {
    public class MainListaSimple {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ListaSimpleCircular<Integer> list = new ListaSimpleCircular<Integer>();

            System.out.println("=== DEMOSTRACIÓN ListaSimpleCircular ===");
            pausa(sc);

            System.out.println("\n[1] agregarInicio(10)");
            list.agregarInicio(10);
            list.imprimirLista();
            System.out.println("-> Se agregó 10 al inicio");
            pausa(sc);

            System.out.println("\n[2] agregarFinal(30)");
            list.agregarFinal(30);
            list.imprimirLista();
            System.out.println("-> Se agregó 30 al final");
            pausa(sc);

            System.out.println("\n[3] agregar(1, 20)");
            list.agregar(1, 20);
            list.imprimirLista();
            System.out.println("-> Se insertó 20 en la posición 1");
            pausa(sc);

            System.out.println("\n[4] obtenerValorNodo(1)");
            int valor = list.obtenerValorNodo(1);
            System.out.println("-> El valor en el índice 1 es: " + valor);
            pausa(sc);

            System.out.println("\n[5] obtenerPosicionNodo(20)");
            int pos = list.obtenerPosicionNodo(20);
            System.out.println("-> La posición del valor 20 es: " + pos);
            pausa(sc);

            System.out.println("\n[6] modificarNodo(1, 25)");
            list.modificarNodo(1, 25);
            list.imprimirLista();
            System.out.println("-> Se cambió el valor en la posición 1 a 25");
            pausa(sc);

            System.out.println("\n[7] agregarFinal(5), agregarFinal(40)");
            list.agregarFinal(5);
            list.agregarFinal(40);
            list.imprimirLista();
            System.out.println("-> Se agregaron 5 y 40 al final");
            pausa(sc);

            System.out.println("\n[8] eliminarPrimero()");
            list.eliminarPrimero();
            list.imprimirLista();
            System.out.println("-> Se eliminó el primer elemento");
            pausa(sc);

            System.out.println("\n[9] eliminarUltimo()");
            list.eliminarUltimo();
            list.imprimirLista();
            System.out.println("-> Se eliminó el último elemento");
            pausa(sc);

            System.out.println("\n[10] eliminar(25)");
            list.eliminar(25);
            list.imprimirLista();
            System.out.println("-> Se eliminó el nodo con valor 25");
            pausa(sc);

            System.out.println("\n[11] agregarFinal(15), agregarFinal(3), agregarFinal(8)");
            list.agregarFinal(15);
            list.agregarFinal(3);
            list.agregarFinal(8);
            list.imprimirLista();
            System.out.println("-> Se agregaron 15, 3 y 8");
            pausa(sc);

            System.out.println("\n[12] ordenarLista()");
            list.ordenarLista();
            list.imprimirLista();
            System.out.println("-> La lista fue ordenada con burbuja");
            pausa(sc);

            System.out.println("\n[13] Iterador de la lista");
            for (Integer dato : list) {
                System.out.print(dato + " ");
            }
            System.out.println("\n-> Se recorrió la lista con el iterador");
            pausa(sc);

            System.out.println("\n[14] borrarLista()");
            list.borrarLista();
            list.imprimirLista();
            System.out.println("-> Se eliminó toda la lista");
            pausa(sc);

            System.out.println("\n=== FIN DE DEMOSTRACIÓN ===");
            sc.close();
        }

        private static void pausa(Scanner sc) {
            System.out.println("\nPresiona ENTER para continuar...");
            try {
                sc.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
