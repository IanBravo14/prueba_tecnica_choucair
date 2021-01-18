package co.com.prueba.tecnica.stepdefinitions;

import co.com.prueba.tecnica.questions.agregarproductocarrito.ValoresDelCarrito;
import co.com.prueba.tecnica.tasks.agregarproductocarrito.AgregarProductos;
import co.com.prueba.tecnica.tasks.comprarproducto.Autenticarse;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarProductoCarritoStepDefinition {

    @Cuando("^se agreguen varios productos al carrito$")
    public void seAgreguenVariosProductosAlCarrito(List<List<String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Autenticarse.enLaAplicacion(datos),
                AgregarProductos.alCarrito(datos)
        );
    }

    @Entonces("^debe observar los siguientes campos$")
    public void debeObservarLosSiguientesCampos(List<List<String>> datos) {
        theActorInTheSpotlight().should(
                seeThat(ValoresDelCarrito.son(datos))
        );
    }

}
