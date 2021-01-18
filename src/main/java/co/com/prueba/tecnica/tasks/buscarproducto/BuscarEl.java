package co.com.prueba.tecnica.tasks.buscarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.prueba.tecnica.userinterface.buscarproducto.BuscarProductoUX.BTN_BUSCAR;
import static co.com.prueba.tecnica.userinterface.buscarproducto.BuscarProductoUX.CAMPO_BUSCAR;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.NOMBRE_DEL_VESTIDO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class BuscarEl implements Task {

    private String nombreVestido;

    public BuscarEl(String nombreVestido) {
        this.nombreVestido = nombreVestido;
    }

    public static BuscarEl vestido(String nombreVestido) {
        return Tasks.instrumented(BuscarEl.class, nombreVestido);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(NOMBRE_DEL_VESTIDO, nombreVestido);
        actor.attemptsTo(
                WaitUntil.the(CAMPO_BUSCAR, isEnabled()),
                Enter.theValue(nombreVestido).into(CAMPO_BUSCAR),
                WaitUntil.the(BTN_BUSCAR, isClickable()),
                Click.on(BTN_BUSCAR)
        );
    }
}
