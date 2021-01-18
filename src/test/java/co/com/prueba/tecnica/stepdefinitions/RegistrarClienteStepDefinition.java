package co.com.prueba.tecnica.stepdefinitions;

import co.com.prueba.tecnica.exceptions.registrarcliente.CamposObligatoriosError;
import co.com.prueba.tecnica.exceptions.registrarcliente.NumeroTelefonoError;
import co.com.prueba.tecnica.exceptions.registrarcliente.RegistroClienteError;
import co.com.prueba.tecnica.questions.registrarcliente.CamposObligatoriosRequeridos;
import co.com.prueba.tecnica.questions.registrarcliente.MensajeNumeroTelefono;
import co.com.prueba.tecnica.questions.registrarcliente.PantallaBienvenida;
import co.com.prueba.tecnica.tasks.registrarcliente.CrearCuenta;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static co.com.prueba.tecnica.exceptions.registrarcliente.RegistroClienteError.MENSAJE_REGISTRO_FALLIDO;
import static co.com.prueba.tecnica.exceptions.registrarcliente.CamposObligatoriosError.MENSAJE_CAMPO_OBLIGATORIO;
import static co.com.prueba.tecnica.exceptions.registrarcliente.NumeroTelefonoError.MENSAJE_NUM_TEL_INCORRECTO;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegistrarClienteStepDefinition {

    @Cuando("^en el registro introduzca los siguientes datos a excepcion del numero de telefono$")
    public void enElRegistroIntroduzcaLosSiguientesDatosAExcepcionDelNumeroDeTelefono(List<List<String>> datosRegistro) {
        theActorInTheSpotlight().attemptsTo(
                CrearCuenta.delCliente(datosRegistro, SIN_CAMPOS_TELEFONO)
        );
    }

    @Cuando("^en el registro solo ingresa los dos primero campos obligatorios$")
    public void enElRegistroSoloIngresaLosDosPrimeroCamposObligatorios(List<List<String>> datosRegistro) {
        theActorInTheSpotlight().attemptsTo(
                CrearCuenta.delCliente(datosRegistro, SOLO_NOMBRE_APELLIDO)
        );
    }

    @Cuando("^en el registro solo ingrese los campos obligatorios$")
    public void enElRegistroSoloIngreseLosCamposObligatorios(List<List<String>> datosRegistro) {
        theActorInTheSpotlight().attemptsTo(
                CrearCuenta.delCliente(datosRegistro, CAMPOS_OBLIGATORIOS)
        );
    }

    @Cuando("^en el registro ingresa todos los campos$")
    public void enElRegistroIngresaTodosLosCampos(List<List<String>> datosRegistro) {
        theActorInTheSpotlight().attemptsTo(
                CrearCuenta.delCliente(datosRegistro, TODOS_LOS_CAMPOS)
        );
    }

    @Entonces("^le debe salir el mensaje de error \"([^\"]*)\"$")
    public void leDebeSalirElMensajeDeError(String numTelRequerido) {
        theActorInTheSpotlight().should(
                seeThat(MensajeNumeroTelefono.es(), equalTo(numTelRequerido)).orComplainWith(NumeroTelefonoError.class, MENSAJE_NUM_TEL_INCORRECTO)
        );
    }

    @Entonces("^le debe mostrar la siguiente lista de campos obligatorios faltantes$")
    public void leDebeMostrarLaSiguienteListaDeCamposObligatoriosFaltantes(List<List<String>> camposObligatoriosFaltantes) {
        theActorInTheSpotlight().should(
                seeThat(CamposObligatoriosRequeridos.son(camposObligatoriosFaltantes)).orComplainWith(CamposObligatoriosError.class, MENSAJE_CAMPO_OBLIGATORIO)
        );
    }

    @Entonces("^se debe ver un mensaje de bienvenida a su cuenta$")
    public void seDebeVerUnMensajeDeBienvenidaASuCuenta(List<List<String>> datosValidacion) {
        theActorInTheSpotlight().should(
                seeThat(PantallaBienvenida.delCliente(datosValidacion)).orComplainWith(RegistroClienteError.class, MENSAJE_REGISTRO_FALLIDO)
        );
    }

}
