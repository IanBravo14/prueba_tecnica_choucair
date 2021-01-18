package co.com.prueba.tecnica.exceptions.compraproducto;

public class CompraProductoError extends AssertionError {

    public static final String ERROR_COMPRA_PRODUCTO = "La compra del producto no se pudo efectuar";

    public CompraProductoError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
