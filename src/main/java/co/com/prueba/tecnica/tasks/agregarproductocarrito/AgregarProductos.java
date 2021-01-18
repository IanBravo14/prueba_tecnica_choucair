package co.com.prueba.tecnica.tasks.agregarproductocarrito;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.prueba.tecnica.userinterface.agregarproductocarrito.AgregarProductoCarritoUX.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import java.util.List;

public class AgregarProductos implements Task {

    private List<List<String>> datos;

    public AgregarProductos(List<List<String>> datos) {
        this.datos = datos;
    }

    public static AgregarProductos alCarrito(List<List<String>> datos) {
        return Tasks.instrumented(AgregarProductos.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SECCION_PRODUCTO.of(datos.get(0).get(2)), isClickable()),
                Click.on(BTN_SECCION_PRODUCTO.of(datos.get(0).get(2))),
                JavaScriptClick.on(PRODUCTO_A_COMPRAR.of(datos.get(0).get(4))),
                WaitUntil.the(BTN_AGREGAR_PRODUCTO_CARRITO, isPresent()),
                Click.on(BTN_AGREGAR_PRODUCTO_CARRITO),
                WaitUntil.the(BTN_CONTINUAR_COMPRA, isPresent()),
                Click.on(BTN_CONTINUAR_COMPRA),
                WaitUntil.the(BTN_SECCION_PRODUCTO.of(datos.get(0).get(3)), isClickable()),
                Click.on(BTN_SECCION_PRODUCTO.of(datos.get(0).get(3))),
                JavaScriptClick.on(PRODUCTO_A_COMPRAR.of(datos.get(0).get(5))),
                WaitUntil.the(BTN_AGREGAR_PRODUCTO_CARRITO, isPresent()),
                Click.on(BTN_AGREGAR_PRODUCTO_CARRITO),
                WaitUntil.the(BTN_INGRESAR_CARRITO, isClickable()),
                Click.on(BTN_INGRESAR_CARRITO)
        );
    }
}
