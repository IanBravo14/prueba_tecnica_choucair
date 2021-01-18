package co.com.prueba.tecnica.userinterface.registrarcliente;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrarClienteUX {

    private RegistrarClienteUX() {
    }

    public static final Target BTN_SIGN_IN = Target.the("botón para ingresar al registro").locatedBy("//div[@class='header_user_info']//a");
    public static final Target CAMPO_EMAIL = Target.the("campo donde se introduce el correo").located(By.id("email_create"));
    public static final Target BTN_CREAR_CUENTA = Target.the("botón para iniciar la creación de la cuenta").located(By.id("SubmitCreate"));
    public static final Target RADIO_BTN_MR = Target.the("radio botón para seleccionar título de mr").located(By.id("id_gender1"));
    public static final Target CAMPO_NOMBRE = Target.the("campo donde se introduce el nombre del cliente").located(By.id("customer_firstname"));
    public static final Target CAMPO_APELLIDO = Target.the("campo donde se introduce el apellido del cliente").located(By.id("customer_lastname"));
    public static final Target CAMPO_PASSWORD = Target.the("campo donde se introduce la contraseña del cliente").located(By.id("passwd"));
    public static final Target TXT_AREA_INFORMACION_ADICIONAL = Target.the("área de texto donde el cliente escribe información adicional").located(By.id("other"));
    public static final Target LISTA_DESPLEGABLE_DIA = Target.the("lista desplegable de los días").located(By.id("days"));
    public static final Target LISTA_DESPLEGABLE_MES = Target.the("lista desplegable de los meses").located(By.id("months"));
    public static final Target LISTA_DESPLEGABLE_ANIO = Target.the("lista desplegable de los años").located(By.id("years"));
    public static final Target CAMPO_COMPANIA = Target.the("campo donde se introduce el nombre de la compañía").located(By.id("company"));
    public static final Target CAMPO_DIRECCION = Target.the("campo donde se introduce la dirección del cliente").located(By.id("address1"));
    public static final Target CAMPO_DIRECCION_2 = Target.the("campo donde se introduce la dirección secundaria del cliente").located(By.id("address2"));
    public static final Target CAMPO_CIUDAD = Target.the("campo donde se introduce la ciudad").located(By.id("city"));
    public static final Target CAMPO_NUM_MOVIL = Target.the("campo donde se introduce el número de celular").located(By.id("phone_mobile"));
    public static final Target CAMPO_NUM_TELEFONO = Target.the("campo donde se introduce el número de teléfono").located(By.id("phone"));
    public static final Target LISTA_DESPLEGABLE_ESTADO = Target.the("lista desplegable de los estado que hay en USA").located(By.id("id_state"));
    public static final Target CAMPO_CODIGO_POSTAL = Target.the("campo donde se introduce el código postal donde vive el cliente").located(By.id("postcode"));
    public static final Target LISTA_DESPLEGABLE_PAIS = Target.the("lista desplegable de los países").located(By.id("id_country"));
    public static final Target CAMPO_DIR_ALIAS = Target.the("campo donde se introduce una dirección alternativa para futura referencia").located(By.id("alias"));
    public static final Target BTN_REGISTRAR = Target.the("botón para finalizar el registro del cliente").located(By.id("submitAccount"));
    public static final Target CAMPOS_OBLIGATORIOS = Target.the("mensaje que campos son olbigatorios").locatedBy("(//div[@class='alert alert-danger']//ol//li)[{0}]");
    public static final Target BIENVENIDA_CUENTA_CLIENTE = Target.the("mensaje de bienvenida a la cuenta del cliente por haberse registrado").locatedBy("//p[@class='info-account']");
    public static final Target NOMBRE_USUARIO = Target.the("nombre de usuario que el cliente tiene en la tienda virtual").locatedBy("//div[@class='header_user_info']//a//span");

}
