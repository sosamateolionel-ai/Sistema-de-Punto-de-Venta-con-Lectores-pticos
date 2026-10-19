# Sistema de Punto de Venta con Lectores Ópticos

## Descripción

Este proyecto implementa un sistema de punto de venta que permite registrar productos mediante diferentes tipos de lectores ópticos. Utiliza programación orientada a objetos en Java para integrar un escáner láser de códigos de barras y una cámara lectora de códigos QR mediante una interfaz común.

## Funcionamiento

El sistema permite escanear códigos, validar su contenido y registrar los productos leídos en una lista. Si la lectura falla o no quedan códigos disponibles, se muestra un mensaje y el producto no se registra.

Se implementan dos tipos de lectores:

* **Escáner láser:** simula la lectura de códigos de barras EAN-13, aceptando únicamente cadenas de 13 dígitos.
* **Cámara QR:** simula la lectura de códigos QR, aceptando únicamente contenidos que comiencen con el prefijo `PROD:`.

La clase `PuntoVenta` utiliza la interfaz `LectorOptico`, por lo que puede trabajar con cualquiera de los dos dispositivos sin depender de una implementación concreta. También permite cambiar el lector durante la ejecución y mostrar un ticket con los productos registrados.

## Clases e interfaz principales

### `LectorOptico`

Interfaz que define el contrato común de los lectores mediante los métodos `escanearCodigo()` y `getNombre()`.

### `EscanerLaser`

Implementa `LectorOptico`. Mantiene una lista de códigos de barras simulados y una posición que indica cuál debe leerse a continuación. Valida que cada código tenga exactamente 13 dígitos.

### `CamaraQR`

Implementa `LectorOptico`. Mantiene una lista de contenidos QR simulados y una posición de lectura. Solo acepta contenidos que comiencen con `PROD:`.

### `PuntoVenta`

Administra el lector actual y una lista de productos registrados. Permite registrar productos, cambiar de lector y mostrar un ticket con los códigos aceptados.

### `Main`

Prepara códigos válidos e inválidos para ambos lectores, ejecuta las lecturas, cambia del escáner láser a la cámara QR y muestra el ticket final.

## Conceptos de programación utilizados

* **Interfaces:** `LectorOptico` establece un contrato común para distintos dispositivos.
* **Polimorfismo:** `PuntoVenta` trabaja con cualquier objeto que implemente `LectorOptico`.
* **Abstracción:** el punto de venta utiliza los métodos de la interfaz sin conocer los detalles internos de cada lector.
* **Encapsulamiento:** las listas de códigos, la posición de lectura y los productos registrados son atributos privados.
* **Asociación:** `PuntoVenta` mantiene una referencia al lector óptico que utiliza.
* **Colecciones:** se emplean listas `ArrayList` para almacenar los códigos disponibles y los productos registrados.
* **Validación de datos:** se comprueba el formato de los códigos antes de aceptarlos.
* **Modularidad:** cada clase tiene una responsabilidad específica dentro del sistema.

## Tecnologías utilizadas

* Java.
* IntelliJ IDEA.
* Programación orientada a objetos (POO).
* Colecciones de Java (`ArrayList` y `List`).

## Ejecución

<img width="690" height="371" alt="image" src="https://github.com/user-attachments/assets/23989bfe-ae88-41ad-81b0-cdabe7db94f9" />
<img width="1092" height="551" alt="image" src="https://github.com/user-attachments/assets/b09cb7fe-bbcb-41f9-b0e6-574ac7f418f5" />

## Objetivo del ejercicio

Aplicar interfaces, polimorfismo, abstracción y asociación para diseñar un punto de venta flexible. El ejercicio demuestra cómo una clase puede trabajar con distintos dispositivos mediante una interfaz común, permitiendo incorporar nuevos tipos de lectores sin modificar la lógica principal del punto de venta.

## Consideraciones

El sistema es una simulación educativa. No utiliza hardware real ni lee códigos de barras o QR mediante una cámara física. Los códigos se cargan manualmente en listas y las lecturas se simulan desde la consola. El ticket muestra únicamente los códigos registrados, sin nombres de productos ni precios.
