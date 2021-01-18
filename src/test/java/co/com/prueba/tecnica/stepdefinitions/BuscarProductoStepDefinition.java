package co.com.prueba.tecnica.stepdefinitions;

import co.com.prueba.tecnica.exceptions.buscarproducto.BusquedaProductoError;
import co.com.prueba.tecnica.questions.buscarproducto.ResultadoDeLaBusqueda;
import co.com.prueba.tecnica.tasks.buscarproducto.BuscarEl;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.prueba.tecnica.exceptions.buscarproducto.BusquedaProductoError.PRODUCTO_NO_ENCONTRADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuscarProductoStepDefinition {

    @Cuando("^introduza el vestido \"([^\"]*)\" en el buscador$")
    public void introduzaElVestidoEnElBuscador(String nombreVestido) {
        theActorInTheSpotlight().attemptsTo(
                BuscarEl.vestido(nombreVestido)
        );
    }

    @Entonces("^debe ver los productos que tengan palabras identicas a la busqueda$")
    public void debeVerLosProductosQueTenganPalabrasIdenticasALaBusqueda() {
        theActorInTheSpotlight().should(
               seeThat(ResultadoDeLaBusqueda.es()).orComplainWith(BusquedaProductoError.class, PRODUCTO_NO_ENCONTRADO)
        );
    }

}
