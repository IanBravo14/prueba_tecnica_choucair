package co.com.prueba.tecnica.questions.registrarcliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.BIENVENIDA_CUENTA_CLIENTE;
import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.NOMBRE_USUARIO;

public class PantallaBienvenida implements Question<Boolean> {

    private List<List<String>> datosRegistroCliente;


    public PantallaBienvenida(List<List<String>> datosRegistroCliente) {
        this.datosRegistroCliente = datosRegistroCliente;
    }

    public static PantallaBienvenida delCliente(List<List<String>> datosRegistroCliente) {
        return new PantallaBienvenida(datosRegistroCliente);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeBienvenida = datosRegistroCliente.get(0).get(0);
        String nombreUsuario = datosRegistroCliente.get(0).get(1);
        actor.attemptsTo(
                WaitUntil.the(BIENVENIDA_CUENTA_CLIENTE, isPresent())
        );
        return mensajeBienvenida.equals(BIENVENIDA_CUENTA_CLIENTE.resolveFor(actor).getText()) && nombreUsuario.equals(NOMBRE_USUARIO.resolveFor(actor).getText());
    }
}
