package co.com.prueba.tecnica.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registrar_cliente.feature",
        glue = "co.com.prueba.tecnica.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class RegistrarCliente {
}
