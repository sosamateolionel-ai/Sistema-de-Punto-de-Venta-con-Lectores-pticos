import java.util.ArrayList;
import java.util.List;

public class PuntoVenta {

    private LectorOptico lector; // asociación con la ABSTRACCIÓN
    private List<String> productosRegistrados;

    public PuntoVenta(LectorOptico lector) {
        this.lector = lector;
        this.productosRegistrados = new ArrayList<>();
    }

    public void setLector(LectorOptico lector) {
        this.lector = lector;
        System.out.println("Punto de venta: lector cambiado a " + lector.getNombre() + ".");
    }

    public boolean registrarProducto() {

        System.out.println("\nPunto de venta: esperando lectura con " + lector.getNombre() + "...");

        String codigo = lector.escanearCodigo();

        if (codigo == null) {
            System.out.println("Punto de venta: no se registró ningún producto.");
            return false;
        }

        productosRegistrados.add(codigo);
        System.out.println("Punto de venta: producto registrado -> " + codigo);
        return true;
    }

    public void mostrarTicket() {

        System.out.println("\n=== Ticket (" + productosRegistrados.size() + " productos) ===");

        for (int i = 0; i < productosRegistrados.size(); i++) {
            System.out.println((i + 1) + ". " + productosRegistrados.get(i));
        }
    }
}