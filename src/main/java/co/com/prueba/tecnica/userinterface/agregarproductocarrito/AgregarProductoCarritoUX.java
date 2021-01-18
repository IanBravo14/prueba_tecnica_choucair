package co.com.prueba.tecnica.userinterface.agregarproductocarrito;

import net.serenitybdd.screenplay.targets.Target;

public class AgregarProductoCarritoUX {

    private AgregarProductoCarritoUX(){}

    public static final Target BTN_SECCION_PRODUCTO = Target.the("botón para ingresar a la sección que el cliente desee").locatedBy("(//li//a[text()='{0}'])[2]");
    public static final Target PRODUCTO_A_COMPRAR = Target.the("producto que se va a comprar").locatedBy("//div[@class='product-container']//div//div//a[@title='{0}']");
    public static final Target BTN_AGREGAR_PRODUCTO_CARRITO = Target.the("botón para agregar el producto al carrito").locatedBy("//p[@id='add_to_cart']//button//span");
    public static final Target BTN_CONTINUAR_COMPRA = Target.the("botón que permite continuar comprando").locatedBy("//span[@title='Continue shopping']");
    public static final Target BTN_INGRESAR_CARRITO = Target.the("botón para ingresar a la sección del carrito de compras").locatedBy("//div[@class='button-container']//a//span");
    public static final Target LBL_NOMBRE_VESTIDO = Target.the("label nombre del vestido").locatedBy("(//td[@class='cart_description']//p)[1]");
    public static final Target LBL_NOMBRE_T_SHIRT = Target.the("label nombre del t-shirt").locatedBy("(//td[@class='cart_description']//p)[2]");
    public static final Target LBL_PRECIO_VESTIDO = Target.the("label con el precio del vestido").locatedBy("(//td[@class='cart_total']//span)[1]");
    public static final Target LBL_PRECIO_T_SHIRT = Target.the("label con el precio del t-shirt").locatedBy("(//td[@class='cart_total']//span)[2]");
    public static final Target LBL_PRECIO_TOTAL = Target.the("label con precio total de ambos productos sin el envío").locatedBy("//tr[@class='cart_total_price']//td[@id='total_product']");
}
