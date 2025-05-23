package co.com.opencart.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/compra/flujo_compra.feature"},
        glue = {"co.com.opencart.stepdefinitions"},
        tags = "@Flujo01")
public class CompraRunnerTest {
}
