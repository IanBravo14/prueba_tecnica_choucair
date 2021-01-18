package co.com.prueba.tecnica.questions.buscarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.buscarproducto.BuscarProductoUX.RESULTADO_BUSQUEDA;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.NOMBRE_DEL_VESTIDO;

public class ResultadoDeLaBusqueda implements Question<Boolean> {

    public static ResultadoDeLaBusqueda es() {
        return new ResultadoDeLaBusqueda();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> resultadoBusqueda = Text.of(RESULTADO_BUSQUEDA).viewedBy(actor).asList();
        String nombreVestido = actor.recall(NOMBRE_DEL_VESTIDO);
        int coincidenciaBusqueda = compararResultadoDeLaBusqueda(resultadoBusqueda, nombreVestido);
        return resultadoBusqueda.size() == coincidenciaBusqueda;
    }

    private int compararResultadoDeLaBusqueda(List<String> resultadoBusqueda, String nombreVestido) {
        String[] palabraVestido = nombreVestido.split(" ");
        int i = 0;
        int coincidencia = 0;
        for (String vestido : resultadoBusqueda) {
            if (vestido.indexOf(palabraVestido[i]) != -1 && vestido.indexOf(palabraVestido[i + 1]) != -1) {
                coincidencia++;
            }
        }
        return coincidencia;
    }
}
