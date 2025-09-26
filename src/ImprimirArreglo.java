public class ImprimirArreglo {

//    public static void imprimir(int[] arreglo) {
//        while  (int i = 0; i < arreglo.length; i++) {
//            System.out.print(arreglo[i] + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        int[] numeros = {10, 20, 30, 40, 50};
//        imprimir(numeros);
//    }

    //imprime arreglo de forma recursiva
//    public static void imprimir(int[] arreglo) {
//        int i = 0;
//        while (i < arreglo.length) {
//            System.out.print(arreglo[i]);
//            i++;
//        }
//    }

    public static void imprimir(int[] arreglo) {
        imprimirRecursivo(arreglo, 0);
    }

    private static void imprimirRecursivo(int[] arreglo, int indice) {
        if (indice >= arreglo.length) {
            System.out.println("Termine");
        }
        System.out.print(arreglo[indice]);

        imprimirRecursivo(arreglo, indice + 1);
    }
}
