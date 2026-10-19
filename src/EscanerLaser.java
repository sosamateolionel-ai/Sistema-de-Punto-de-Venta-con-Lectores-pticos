import java.util.ArrayList;
import java.util.List;

public class EscanerLaser implements LectorOptico {

    private List<String> articulosEnCinta; // simula los productos que pasan frente al láser
    private int posicion;

    public EscanerLaser() {
        this.articulosEnCinta = new ArrayList<>();
        this.posicion = 0;
    }

    public void colocarArticulo(String codigoBarras) {
        articulosEnCinta.add(codigoBarras);
    }

    @Override
    public String escanearCodigo() {

        if (posicion >= articulosEnCinta.size()) {
            System.out.println("[Láser] No hay más artículos frente al lector.");
            return null;
        }

        String codigo = articulosEnCinta.get(posicion);
        posicion++;

        // Regla propia: un código de barras EAN-13 tiene exactamente 13 dígitos
        if (!codigo.matches("\\d{13}")) {
            System.out.println("[Láser] Lectura fallida: el código \"" + codigo + "\" no es un EAN-13 válido.");
            return null;
        }

        System.out.println("[Láser] Haz de luz barrió las barras: " + codigo);
        return codigo;
    }

    @Override
    public String getNombre() {
        return "escáner láser";
    }
}