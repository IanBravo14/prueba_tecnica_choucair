package co.com.prueba.tecnica.tasks.comprarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.comprarproducto.ComprarProductoUX.*;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Comprar implements Task {

    private List<List<String>> datosCompra;

    public Comprar(List<List<String>> datosCompra) {
        this.datosCompra = datosCompra;
    }

    public static Comprar elProducto(List<List<String>> datosCompra) {
        return Tasks.instrumented(Comprar.class, datosCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SECCION_PRODUCTO.of(datosCompra.get(0).get(2)), isPresent()),
                Click.on(SECCION_PRODUCTO.of(datosCompra.get(0).get(2))),
                JavaScriptClick.on(PRODUCTO_A_COMPRAR.of(datosCompra.get(0).get(3))),
                WaitUntil.the(BTN_AGREGAR_PRODUCTO_CARRITO, isPresent()),
                Click.on(BTN_AGREGAR_PRODUCTO_CARRITO),
                WaitUntil.the(BTN_PROCEDER_A_CAJA, isClickable()),
                Click.on(BTN_PROCEDER_A_CAJA)
        );
        actor.remember(VALOR_TOTAL_PRODUCTO, LBL_TOTAL_PRECIO_PRODUCTO.resolveFor(actor).getText());
        actor.attemptsTo(
                WaitUntil.the(BTN_PROCEDER_A_CAJA_2, isPresent()),
                Click.on(BTN_PROCEDER_A_CAJA_2),
                WaitUntil.the(BTN_PROCEDER_A_CAJA_3, isPresent()),
                Click.on(BTN_PROCEDER_A_CAJA_3),
                WaitUntil.the(CHECKBOX_TERM_SERVICIO, isEnabled()),
                Click.on(CHECKBOX_TERM_SERVICIO),
                JavaScriptClick.on(BTN_PROCEDER_A_CAJA_4),
                Check.whether(datosCompra.get(0).get(4).equals(MEDIO_PAGO_CHEQUE))
                        .andIfSo(
                                WaitUntil.the(BTN_MEDIO_PAGO.of(CHEQUE), isPresent()),
                                Click.on(BTN_MEDIO_PAGO.of(CHEQUE))
                        ),
                Check.whether(datosCompra.get(0).get(4).equals(MEDIO_PAGO_TRANSFERENCIA_BANCARIA))
                        .andIfSo(
                                WaitUntil.the(BTN_MEDIO_PAGO.of(TRANSFERENCIA_BANCARIA), isPresent()),
                                Click.on(BTN_MEDIO_PAGO.of(TRANSFERENCIA_BANCARIA))
                        ),
                WaitUntil.the(BTN_CONFIRMAR_COMPRA, isPresent()),
                Click.on(BTN_CONFIRMAR_COMPRA)
        );
    }
}
