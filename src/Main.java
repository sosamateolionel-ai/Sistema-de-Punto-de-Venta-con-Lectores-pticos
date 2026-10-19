
void main() {

    EscanerLaser laser = new EscanerLaser();
    laser.colocarArticulo("7791234567890");   // válido
    laser.colocarArticulo("12345");           // inválido (no es EAN-13)

    CamaraQR camara = new CamaraQR();
    camara.mostrarQR("PROD:LECHE-1L-0042");   // válido
    camara.mostrarQR("https://publicidad.com"); // QR que no es de un producto

    PuntoVenta caja = new PuntoVenta(laser);

    System.out.println("===== Lectura con escáner láser =====");
    caja.registrarProducto();   // exitosa
    caja.registrarProducto();   // código inválido
    caja.registrarProducto();   // sin más artículos

    System.out.println("\n===== Cambio a cámara QR =====");
    caja.setLector(camara);
    caja.registrarProducto();   // exitosa
    caja.registrarProducto();   // QR que no es un producto
    caja.registrarProducto();   // sin más códigos

    caja.mostrarTicket();

}
