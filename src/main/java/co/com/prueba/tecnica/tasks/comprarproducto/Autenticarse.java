package co.com.prueba.tecnica.tasks.comprarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.comprarproducto.ComprarProductoUX.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Autenticarse implements Task {

    private List<List<String>> datosCompra;

    public Autenticarse(List<List<String>> datosCompra) {
        this.datosCompra = datosCompra;
    }

    public static Autenticarse enLaAplicacion(List<List<String>> datosCompra) {
        return Tasks.instrumented(Autenticarse.class, datosCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGN_IN, isClickable()),
                Click.on(BTN_SIGN_IN),
                WaitUntil.the(CAMPO_EMAIL, isPresent()),
                Enter.theValue(datosCompra.get(0).get(0)).into(CAMPO_EMAIL),
                Enter.theValue(datosCompra.get(0).get(1)).into(CAMPO_PASSWORD),
                Click.on(BTN_REGISTRAR)
        );
    }
}
