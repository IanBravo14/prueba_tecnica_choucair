package co.com.prueba.tecnica.userinterface.comprarproducto;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ComprarProductoUX {

    private ComprarProductoUX(){}

    public static final Target BTN_SIGN_IN = Target.the("botón para ingresar al registro").locatedBy("//div[@class='header_user_info']//a");
    public static final Target CAMPO_EMAIL = Target.the("campo donde se introduce el email del cliente").located(By.id("email"));
    public static final Target CAMPO_PASSWORD = Target.the("campo donde se introduce la contraseña del cliente").located(By.id("passwd"));
    public static final Target BTN_REGISTRAR = Target.the("botón para auntenticarse en la aplicación").located(By.id("SubmitLogin"));
    public static final Target SECCION_PRODUCTO = Target.the("sección a donde el cliente quiere ingresar").locatedBy("(//li//a[text()='{0}'])[2]");
    public static final Target PRODUCTO_A_COMPRAR = Target.the("producto que se va a comprar").locatedBy("//div[@class='product-container']//div//div//a[@title='{0}']");
    public static final Target BTN_AGREGAR_PRODUCTO_CARRITO = Target.the("botón para agregar el producto al carrito").locatedBy("//p[@id='add_to_cart']//button//span");
    public static final Target BTN_PROCEDER_A_CAJA = Target.the("botón para continuar al pago del producto").locatedBy("//div[@class='button-container']//a//span");
    public static final Target LBL_TOTAL_PRECIO_PRODUCTO = Target.the("valor total del producto").located(By.id("total_price"));
    public static final Target BTN_PROCEDER_A_CAJA_2 = Target.the("botón en la sección del carrito para continuar con la compra").locatedBy("//p[@class='cart_navigation clearfix']//a//span");
    public static final Target BTN_PROCEDER_A_CAJA_3 = Target.the("botón en la sección de dirección para continuar con la compra").locatedBy("//button[@type='submit']//span[text()='Proceed to checkout']");
    public static final Target CHECKBOX_TERM_SERVICIO = Target.the("checkbox para aceptar los términos del servicio").located(By.id("cgv"));
    public static final Target BTN_PROCEDER_A_CAJA_4 = Target.the("botón en la sección de envío para continuar con la compra").locatedBy("//p[@class='cart_navigation clearfix']//button");
    public static final Target BTN_MEDIO_PAGO = Target.the("botón para escoger el medio de pago para comprar el producto").locatedBy("//a[@class='{0}']");
    public static final Target BTN_CONFIRMAR_COMPRA = Target.the("botón para confirmar la compra del producto").locatedBy("//button[@class='button btn btn-default button-medium']");
    public static final Target LBL_ORDEN_COMPRA_CHEQUE = Target.the("label de confirmación de la compra con cheque").locatedBy("//p[@class='alert alert-success']");
    public static final Target LBL_PRECIO_TOTAL_CHEQUE = Target.the("valor total del producto pagado con cheque").locatedBy("//span[@class='price']//strong");
    public static final Target LBL_ORDEN_COMPRA_TRANS_BANCARIA = Target.the("label de la confirmación de la compra con transferencia bancaria").locatedBy("//p[@class='cheque-indent']//strong");
    public static final Target LBL_PRECIO_TOTAL_TRANS_BANCARIA = Target.the("valor total del producto pagado con transferencia bancaria").locatedBy("//span[@class='price']//strong");

}
