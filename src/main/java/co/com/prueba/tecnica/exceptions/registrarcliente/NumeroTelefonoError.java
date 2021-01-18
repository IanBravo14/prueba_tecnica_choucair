package co.com.prueba.tecnica.exceptions.registrarcliente;

public class NumeroTelefonoError extends AssertionError {

    public static final String MENSAJE_NUM_TEL_INCORRECTO = "El mensaje cuando hay que asignar al menos un num telefono no es el indiciado";

    public NumeroTelefonoError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
