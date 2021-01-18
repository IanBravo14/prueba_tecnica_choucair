package co.com.prueba.tecnica.userinterface.buscarproducto;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarProductoUX {

    private BuscarProductoUX(){}

    public static final Target CAMPO_BUSCAR = Target.the("campo donde se introduce el vestido a buscar").located(By.id("search_query_top"));
    public static final Target BTN_BUSCAR = Target.the("botón para buscar el producto deseado").locatedBy("//button[@name='submit_search']");
    public static final Target RESULTADO_BUSQUEDA = Target.the("listado de resultados que arrojó la búsqueda").locatedBy("//h5[@itemprop='name']");

}
