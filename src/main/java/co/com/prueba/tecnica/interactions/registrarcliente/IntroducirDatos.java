package co.com.prueba.tecnica.interactions.registrarcliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.*;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.*;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.CAMPOS_OBLIGATORIOS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IntroducirDatos implements Interaction {

    private List<List<String>> datosRegistro;
    private String requerimientoEscenario;

    public IntroducirDatos(List<List<String>> datosRegistro, String requerimientoEscenario) {
        this.datosRegistro = datosRegistro;
        this.requerimientoEscenario = requerimientoEscenario;
    }

    public static IntroducirDatos delCliente(List<List<String>> datosRegistro, String requerimientoEscenario) {
        return Tasks.instrumented(IntroducirDatos.class, datosRegistro, requerimientoEscenario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (requerimientoEscenario.equalsIgnoreCase(SIN_CAMPOS_TELEFONO)) {
            String[] fechaNacimiento = datosRegistro.get(0).get(4).split(";");
            actor.attemptsTo(
                    WaitUntil.the(RADIO_BTN_MR, isClickable()),
                    Click.on(RADIO_BTN_MR),
                    Enter.theValue(datosRegistro.get(0).get(0)).into(CAMPO_NOMBRE),
                    Enter.theValue(datosRegistro.get(0).get(1)).into(CAMPO_APELLIDO),
                    Enter.theValue(datosRegistro.get(0).get(3)).into(CAMPO_PASSWORD),
                    SelectFromOptions.byVisibleText(fechaNacimiento[0] + "  ").from(LISTA_DESPLEGABLE_DIA),
                    SelectFromOptions.byVisibleText(fechaNacimiento[1] + " ").from(LISTA_DESPLEGABLE_MES),
                    SelectFromOptions.byVisibleText(fechaNacimiento[2] + "  ").from(LISTA_DESPLEGABLE_ANIO),
                    Enter.theValue(datosRegistro.get(0).get(5)).into(CAMPO_DIRECCION),
                    Enter.theValue(datosRegistro.get(0).get(6)).into(CAMPO_CIUDAD),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(7)).from(LISTA_DESPLEGABLE_ESTADO),
                    Enter.theValue(datosRegistro.get(0).get(8)).into(CAMPO_CODIGO_POSTAL),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(9)).from(LISTA_DESPLEGABLE_PAIS),
                    Enter.theValue(datosRegistro.get(0).get(10)).into(CAMPO_DIR_ALIAS),
                    Click.on(BTN_REGISTRAR)
            );
        } else if (requerimientoEscenario.equalsIgnoreCase(SOLO_NOMBRE_APELLIDO)) {
            actor.attemptsTo(
                    WaitUntil.the(CAMPO_NOMBRE, isClickable()),
                    Enter.theValue(datosRegistro.get(0).get(0)).into(CAMPO_NOMBRE),
                    Enter.theValue(datosRegistro.get(0).get(1)).into(CAMPO_APELLIDO),
                    Click.on(BTN_REGISTRAR)
            );
        } else if(requerimientoEscenario.equalsIgnoreCase(CAMPOS_OBLIGATORIOS)) {
            actor.attemptsTo(
                    WaitUntil.the(CAMPO_NOMBRE, isClickable()),
                    Enter.theValue(datosRegistro.get(0).get(0)).into(CAMPO_NOMBRE),
                    Enter.theValue(datosRegistro.get(0).get(1)).into(CAMPO_APELLIDO),
                    Enter.theValue(datosRegistro.get(0).get(3)).into(CAMPO_PASSWORD),
                    Enter.theValue(datosRegistro.get(0).get(4)).into(CAMPO_DIRECCION),
                    Enter.theValue(datosRegistro.get(0).get(5)).into(CAMPO_CIUDAD),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(6)).from(LISTA_DESPLEGABLE_ESTADO),
                    Enter.theValue(datosRegistro.get(0).get(7)).into(CAMPO_CODIGO_POSTAL),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(8)).from(LISTA_DESPLEGABLE_PAIS),
                    Enter.theValue(datosRegistro.get(0).get(9)).into(CAMPO_NUM_MOVIL),
                    Enter.theValue(datosRegistro.get(0).get(10)).into(CAMPO_DIR_ALIAS),
                    Click.on(BTN_REGISTRAR)
            );
        } else if (requerimientoEscenario.equalsIgnoreCase(TODOS_LOS_CAMPOS)) {
            String[] fechaNacimiento = datosRegistro.get(0).get(4).split(";");
            actor.attemptsTo(
                    WaitUntil.the(RADIO_BTN_MR, isClickable()),
                    Click.on(RADIO_BTN_MR),
                    Enter.theValue(datosRegistro.get(0).get(0)).into(CAMPO_NOMBRE),
                    Enter.theValue(datosRegistro.get(0).get(1)).into(CAMPO_APELLIDO),
                    Enter.theValue(datosRegistro.get(0).get(3)).into(CAMPO_PASSWORD),
                    SelectFromOptions.byVisibleText(fechaNacimiento[0] + "  ").from(LISTA_DESPLEGABLE_DIA),
                    SelectFromOptions.byVisibleText(fechaNacimiento[1] + " ").from(LISTA_DESPLEGABLE_MES),
                    SelectFromOptions.byVisibleText(fechaNacimiento[2] + "  ").from(LISTA_DESPLEGABLE_ANIO),
                    Enter.theValue(datosRegistro.get(0).get(5)).into(CAMPO_COMPANIA),
                    Enter.theValue(datosRegistro.get(0).get(6)).into(CAMPO_DIRECCION),
                    Enter.theValue(datosRegistro.get(0).get(7)).into(CAMPO_DIRECCION_2),
                    Enter.theValue(datosRegistro.get(0).get(8)).into(CAMPO_CIUDAD),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(9)).from(LISTA_DESPLEGABLE_ESTADO),
                    Enter.theValue(datosRegistro.get(0).get(10)).into(CAMPO_CODIGO_POSTAL),
                    SelectFromOptions.byVisibleText(datosRegistro.get(0).get(11)).from(LISTA_DESPLEGABLE_PAIS),
                    Enter.theValue(datosRegistro.get(0).get(12)).into(TXT_AREA_INFORMACION_ADICIONAL),
                    Enter.theValue(datosRegistro.get(0).get(13)).into(CAMPO_NUM_TELEFONO),
                    Enter.theValue(datosRegistro.get(0).get(14)).into(CAMPO_NUM_MOVIL),
                    Enter.theValue(datosRegistro.get(0).get(15)).into(CAMPO_DIR_ALIAS),
                    Click.on(BTN_REGISTRAR)
            );
        }
    }
}
