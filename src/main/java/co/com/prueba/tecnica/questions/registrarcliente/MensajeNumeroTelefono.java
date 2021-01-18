package co.com.prueba.tecnica.questions.registrarcliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.CAMPOS_OBLIGATORIOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class MensajeNumeroTelefono implements Question<String> {

    public static MensajeNumeroTelefono es() {
        return new MensajeNumeroTelefono();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPOS_OBLIGATORIOS.of(String.valueOf(1)), isPresent())
        );
        return Text.of(CAMPOS_OBLIGATORIOS.of(String.valueOf(1))).viewedBy(actor).asString();
    }
}
