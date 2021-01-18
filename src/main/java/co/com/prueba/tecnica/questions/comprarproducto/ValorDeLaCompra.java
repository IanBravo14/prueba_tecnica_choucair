package co.com.prueba.tecnica.questions.comprarproducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.prueba.tecnica.userinterface.comprarproducto.ComprarProductoUX.*;
import static co.com.prueba.tecnica.utils.constantes.TiendaVirtualConstantes.*;

public class ValorDeLaCompra implements Question<Boolean> {

    private List<List<String>> datosCompra;
    private String totalPrecioLabel;
    private String lblOrdenCompra;

    public ValorDeLaCompra(List<List<String>> datosCompra) {
        this.datosCompra = datosCompra;
    }

    public static ValorDeLaCompra son(List<List<String>> datosCompra) {
        return new ValorDeLaCompra(datosCompra);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String totalPrecio = actor.recall(VALOR_TOTAL_PRODUCTO);
        obtenerDatosCompra(actor, datosCompra.get(0).get(1));
        return totalPrecio.equals(totalPrecioLabel) && datosCompra.get(0).get(0).equals(lblOrdenCompra);
    }

    private void obtenerDatosCompra(Actor actor, String medioPago) {
        if(medioPago.equalsIgnoreCase(MEDIO_PAGO_CHEQUE)) {
            lblOrdenCompra = Text.of(LBL_ORDEN_COMPRA_CHEQUE).viewedBy(actor).asString();
            totalPrecioLabel = Text.of(LBL_PRECIO_TOTAL_CHEQUE).viewedBy(actor).asString();
        } else if(medioPago.equalsIgnoreCase(MEDIO_PAGO_TRANSFERENCIA_BANCARIA)) {
            lblOrdenCompra = Text.of(LBL_ORDEN_COMPRA_TRANS_BANCARIA).viewedBy(actor).asString();
            totalPrecioLabel = Text.of(LBL_PRECIO_TOTAL_TRANS_BANCARIA).viewedBy(actor).asString();
        }
    }
}
