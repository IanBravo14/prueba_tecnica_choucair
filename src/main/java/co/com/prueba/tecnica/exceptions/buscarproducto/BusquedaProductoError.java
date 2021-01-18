package co.com.prueba.tecnica.exceptions.buscarproducto;

public class BusquedaProductoError extends AssertionError {

    public static final String PRODUCTO_NO_ENCONTRADO = "El producto buscado no se encuentra";

    public BusquedaProductoError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
