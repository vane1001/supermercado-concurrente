package supermercadoconcurrente;

public class Cajera extends Thread {

    private String nombre;
    private Cliente cliente;
    private long tiempoInicial;

    public Cajera(String nombre, Cliente cliente, long tiempoInicial) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoInicial = tiempoInicial;
    }

    @Override
    public void run() {

        System.out.println("La cajera " + nombre +
                " comenzo a atender a " +
                cliente.getNombre());

        double totalCompra = 0;

        for (int i = 0; i < cliente.getProductos().size(); i++) {

            Producto producto = cliente.getProductos().get(i);

            esperarXsegundos(producto.getTiempoProcesamiento());

            totalCompra += producto.getPrecio();

            System.out.println("Cajera " + nombre +
                    " proceso el producto: " +
                    producto.getNombre() +
                    " | Precio: $" + producto.getPrecio() +
                    " | Tiempo: " +
                    producto.getTiempoProcesamiento() +
                    " segundos");
        }

        long tiempoFinal =
                (System.currentTimeMillis() - tiempoInicial) / 1000;

        System.out.println("La cajera " + nombre +
                " termino de atender a " +
                cliente.getNombre() +
                " en " + tiempoFinal +
                " segundos");

        System.out.println("TOTAL COMPRA: $" + totalCompra);

        System.out.println("--------------------------------");
    }

    private void esperarXsegundos(int segundos) {

        try {

            Thread.sleep(segundos * 1000);

        } catch (InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

    }
}
