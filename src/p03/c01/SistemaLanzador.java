package src.p03.c01;

public class SistemaLanzador {
    public static void main(String[] args) {

        IParque parque = new Parque(50);
        char letra_puerta = 'A';
        int numPuertas = args.length > 0 ? Integer.parseInt(args[0]) : 5;

        System.out.println("¡Parque abierto!");

        for (int i = 0; i < numPuertas; i++) {

            String puerta = ""+((char) (letra_puerta++));

            // Creación de hilos de entrada
            ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
            new Thread (entradas).start();

            ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
            new Thread(salidas).start();

        }
    }
}