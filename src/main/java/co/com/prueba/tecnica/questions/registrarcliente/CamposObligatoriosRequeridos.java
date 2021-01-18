package co.com.prueba.tecnica.questions.registrarcliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.registrarcliente.RegistrarClienteUX.*;

public class CamposObligatoriosRequeridos implements Question<Boolean> {

    private List<List<String>> camposObligatoriosFaltantes;
    private String[] arregloCamposObligatorios;
    private int contadorCamposObligatorios = 0;

    public CamposObligatoriosRequeridos(List<List<String>> camposObligatoriosFaltantes) {
        this.camposObligatoriosFaltantes = camposObligatoriosFaltantes;
    }

    public static CamposObligatoriosRequeridos son(List<List<String>> camposObligatoriosFaltantes) {
        return new CamposObligatoriosRequeridos(camposObligatoriosFaltantes);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        arregloCamposObligatorios = camposObligatoriosFaltantes.get(0).get(0).split(";");
        for (int i = 0; i < arregloCamposObligatorios.length; i++) {
            if (arregloCamposObligatorios[i].equals(CAMPOS_OBLIGATORIOS.of(String.valueOf(i+1)).resolveFor(actor).getText())) {
                contadorCamposObligatorios++;
            }
        }
        return arregloCamposObligatorios.length == contadorCamposObligatorios;
    }
}
