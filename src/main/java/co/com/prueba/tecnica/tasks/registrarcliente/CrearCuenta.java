package co.com.prueba.tecnica.tasks.registrarcliente;

import co.com.prueba.tecnica.interactions.registrarcliente.IntroducirDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CrearCuenta implements Task {

    private List<List<String>> datosRegistro;
    private String requerimientoEscenario;

    public CrearCuenta(List<List<String>> datosRegistro, String requerimientoEscenario) {
        this.datosRegistro = datosRegistro;
        this.requerimientoEscenario = requerimientoEscenario;
    }

    public static CrearCuenta delCliente(List<List<String>> datosRegistro, String requerimientoEscenario) {
        return Tasks.instrumented(CrearCuenta.class, datosRegistro, requerimientoEscenario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGN_IN, isClickable()),
                Click.on(BTN_SIGN_IN),
                Enter.theValue(datosRegistro.get(0).get(2)).into(CAMPO_EMAIL),
                Click.on(BTN_CREAR_CUENTA),
                IntroducirDatos.delCliente(datosRegistro, requerimientoEscenario)
        );
    }
}
