package supermercadoconcurrente;

import java.util.Arrays;

public class SupermercadoConcurrente {

    public static void main(String[] args) {

        Producto p1 = new Producto("Arroz", 5000, 2);
        Producto p2 = new Producto("Leche", 3500, 1);
        Producto p3 = new Producto("Pan", 2000, 2);
        Producto p4 = new Producto("Huevos", 12000, 3);

        Cliente cliente1 = new Cliente(
                "Carlos",
                Arrays.asList(p1, p2)
        );

        Cliente cliente2 = new Cliente(
                "Ana",
                Arrays.asList(p3, p4)
        );

        long tiempoInicial = System.currentTimeMillis();

        Cajera cajera1 = new Cajera(
                "Laura",
                cliente1,
                tiempoInicial
        );

        Cajera cajera2 = new Cajera(
                "Sofia",
                cliente2,
                tiempoInicial
        );

        cajera1.start();
        cajera2.start();

    }
}