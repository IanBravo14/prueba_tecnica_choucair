package co.com.prueba.tecnica.stepdefinitions;

import co.com.prueba.tecnica.exceptions.compraproducto.CompraProductoError;
import co.com.prueba.tecnica.questions.comprarproducto.ValorDeLaCompra;
import co.com.prueba.tecnica.tasks.comprarproducto.Autenticarse;
import co.com.prueba.tecnica.tasks.comprarproducto.Comprar;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.prueba.tecnica.exceptions.compraproducto.CompraProductoError.ERROR_COMPRA_PRODUCTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

public class ComprarProductoStepDefinition {

    @Cuando("^haga todo el proceso de compra de manera virtual$")
    public void hagaTodoElProcesoDeCompraDeManeraVirtual(List<List<String>> datosCompra) {
        theActorInTheSpotlight().attemptsTo(
                Autenticarse.enLaAplicacion(datosCompra),
                Comprar.elProducto(datosCompra)
        );

    }

    @Entonces("^debe observar la orden de compra completada junto con el precio total a pagar$")
    public void debeObservarLaOrdenDeCompraCompletadaJuntoConElPrecioTotalAPagar(List<List<String>> datosCompra) {
        theActorInTheSpotlight().should(
                seeThat(ValorDeLaCompra.son(datosCompra)).orComplainWith(CompraProductoError.class, ERROR_COMPRA_PRODUCTO)
        );
    }


}
