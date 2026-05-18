# Simulación de Cobro en Supermercado con Concurrencia

Proyecto desarrollado en Java que simula el proceso de cobro en un 
supermercado utilizando hilos (Threads) para procesar múltiples 
clientes de forma simultánea.

## Descripción

El sistema simula cajeras atendiendo clientes al mismo tiempo.
Cada cajera corre en un hilo independiente, procesa los productos
del cliente uno por uno, calcula el tiempo total de la compra y
al finalizar todas las cajeras muestra el tiempo total del proceso.

## Tecnologías utilizadas
- Java JDK 8+
- Apache NetBeans IDE 29
- Concurrencia con Thread y join()

## Estructura del proyecto

supermercado-concurrente/
├── src/supermercadoconcurrente/
│   ├── SupermercadoConcurrente.java  → clase principal (main)
│   ├── Cajera.java                   → hilo que procesa la compra
│   ├── Cliente.java                  → representa al cliente
│   └── Producto.java                 → representa cada producto
├── build/
├── nbproject/
└── manifest.mf

## Clases

### Producto
Representa un producto del supermercado con tres atributos:
- `nombre` → nombre del producto (String)
- `precio` → precio en pesos (double)
- `tiempoProcesamiento` → segundos que tarda en cobrarse (int)

Ejemplo:
```java
Producto p1 = new Producto("Arroz", 5000, 2);
```

### Cliente
Representa un cliente con su lista de productos a comprar.
- `nombre` → nombre del cliente (String)
- `productos` → lista de productos (List<Producto>)

Ejemplo:
```java
Cliente cliente1 = new Cliente("Carlos", Arrays.asList(p1, p2));
```

### Cajera
Extiende `Thread`. Cada cajera atiende a un cliente en paralelo.
- Recibe el nombre de la cajera, el cliente y el tiempo inicial
- En el método `run()` procesa cada producto con `Thread.sleep()`
- Muestra el detalle de cada producto cobrado
- Calcula y muestra el total de la compra
- Muestra el tiempo que tardó en atender al cliente

### SupermercadoConcurrente
Clase principal con el método `main()` que:
- Crea los productos y los asigna a clientes
- Crea las cajeras y les asigna un cliente cada una
- Inicia los hilos con `start()` para que trabajen en paralelo
- Espera que todos terminen con `join()`
- Muestra el tiempo total de todas las compras

## Conceptos de concurrencia aplicados

| Concepto | Uso en el proyecto |
|----------|--------------------|
| `extends Thread` | Cajera es un hilo independiente |
| `start()` | Inicia la ejecución paralela de cada cajera |
| `join()` | Espera a que todos los hilos terminen |
| `Thread.sleep()` | Simula el tiempo de cobro de cada producto |
| `InterruptedException` | Manejo seguro de interrupciones |


1. Clonar el 
