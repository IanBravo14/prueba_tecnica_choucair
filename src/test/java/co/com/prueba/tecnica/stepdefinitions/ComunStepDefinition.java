package co.com.prueba.tecnica.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.URL_TIENDA_VIRTUAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ComunStepDefinition {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que \"([^\"]*)\" ingresa a la aplicacion$")
    public void queIngresaALaAplicacion(String nombreActor) {
        theActorCalled(nombreActor).wasAbleTo(Open.url(URL_TIENDA_VIRTUAL));
    }

}
