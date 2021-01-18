package co.com.prueba.tecnica.exceptions.registrarcliente;

public class RegistroClienteError extends AssertionError {

    public static final String MENSAJE_REGISTRO_FALLIDO = "El cliente no se pudo registrar";

    public RegistroClienteError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
