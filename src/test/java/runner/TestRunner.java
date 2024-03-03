package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", //Directorio donde se pepenan los de archivos .feature
        glue = "steps", //Paquete donde tenemos nuestras clases definiendo los steps escritos en el feature file
        plugin = {"pretty","html:target/cucumber-reports"},
        tags = "@Navigate"

)
public class TestRunner {

    @AfterClass
    //Cerrar el navegador despues de la prueba
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}
