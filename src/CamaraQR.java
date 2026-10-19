import java.util.ArrayList;
import java.util.List;

public class CamaraQR implements LectorOptico {

    private List<String> imagenesEnfocadas; // simula los QR que la cámara va capturando
    private int posicion;

    public CamaraQR() {
        this.imagenesEnfocadas = new ArrayList<>();
        this.posicion = 0;
    }

    public void mostrarQR(String contenido) {
        imagenesEnfocadas.add(contenido);
    }

    @Override
    public String escanearCodigo() {

        if (posicion >= imagenesEnfocadas.size()) {
            System.out.println("[Cámara QR] No hay ningún código QR en el encuadre.");
            return null;
        }

        String contenido = imagenesEnfocadas.get(posicion);
        posicion++;

        // Regla propia: el QR de este comercio debe empezar con "PROD:"
        if (!contenido.startsWith("PROD:")) {
            System.out.println("[Cámara QR] Imagen decodificada, pero el contenido no corresponde a un producto: \"" + contenido + "\".");
            return null;
        }

        System.out.println("[Cámara QR] Imagen decodificada: " + contenido);
        return contenido;
    }

    @Override
    public String getNombre() {
        return "cámara QR";
    }
}