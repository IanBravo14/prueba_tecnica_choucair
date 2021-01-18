package co.com.prueba.tecnica.questions.agregarproductocarrito;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.agregarproductocarrito.AgregarProductoCarritoUX.*;

public class ValoresDelCarrito implements Question<Boolean> {

    private List<List<String>> datos;

    public ValoresDelCarrito(List<List<String>> datos) {
        this.datos = datos;
    }

    public static ValoresDelCarrito son(List<List<String>> datos) {
        return new ValoresDelCarrito(datos);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(LBL_NOMBRE_VESTIDO).viewedBy(actor).asString().equals(datos.get(0).get(0))
                && Text.of(LBL_NOMBRE_T_SHIRT).viewedBy(actor).asString().equals(datos.get(0).get(1))
                && Text.of(LBL_PRECIO_VESTIDO).viewedBy(actor).asString().equals(datos.get(0).get(2))
                && Text.of(LBL_PRECIO_T_SHIRT).viewedBy(actor).asString().equals(datos.get(0).get(3))
                && Text.of(LBL_PRECIO_TOTAL).viewedBy(actor).asString().equals(datos.get(0).get(4));
    }
}
