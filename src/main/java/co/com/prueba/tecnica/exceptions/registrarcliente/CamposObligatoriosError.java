package co.com.prueba.tecnica.exceptions.registrarcliente;

public class CamposObligatoriosError extends AssertionError {

    public static final String MENSAJE_CAMPO_OBLIGATORIO = "Uno de los campos obligatorios no muestra el mensaje indicado. Por favor revisar";

    public CamposObligatoriosError(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
