package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class FreeRangeTesterSteps {
    SoftAssert soft = new SoftAssert();

    FreeRangeTestPage free = new FreeRangeTestPage();
    CursosPage cursos = new CursosPage();
    FundamentosDelTestingPage fundamentos = new FundamentosDelTestingPage();
    RegistroPage registro = new RegistroPage();

    @Given("I navigate to www.freerangetesters.com")
    public void INavigateToFreeRangeTest() {
        free.navigateToFreeRangeTest();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        free.clickSectionCourseBar(section);
    }

    @And("selected Introduccion al testing")
    public void navigateToIntro(){
        cursos.clickFundamentostestlink();
        fundamentos.clickIntroduccionTestingLink();
    }

    @When("I select Elegin plan")
    public void selectElegirPlan() {
        free.clickOnElegirPlan();
    }

    @Then("I can validate the options in the checkout page")
    public void validateChecoutPlans() {
        List<String> lista = registro.returPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.98 / mes • 11 productos", "Academia: $176 / año • 11 productos", "Free: Gratis • 1 producto");

        Assert.assertEquals(listaEsperada, lista);
    }

    public void examplesPa(){
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        Integer numeroTest = 1;
        Integer numeroTest2 = 2;

        Assert.assertEquals(numeroTest,numeroTest2);

        //Verificar que dos valores no son iguales
        Assert.assertNotEquals(palabraEncontrada,palabraEsperada);
        //Verificar que dos valores son iguales
        Assert.assertEquals(palabraEncontrada,palabraEsperada);
        //Verificar condicion verdadera
        Assert.assertTrue(palabraEncontrada.contains(palabraEsperada));
        //Verificar condicion falsa
        Assert.assertFalse(palabraEncontrada.contains(palabraEsperada));



        // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar
        // muchas cosas pequeñas a la vez.
        soft.assertEquals(palabraEsperada, palabraEncontrada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        soft.assertNotEquals(palabraEncontrada,palabraEsperada);

        soft.assertAll();    }
    }


/*
1. assertEquals

Verifica que dos valores sean iguales.

  Assert.assertEquals(actualTitle, expectedTitle, "El título de la página no es el esperado.");

2. assertNotEquals

Verifica que dos valores no sean iguales.

   Assert.assertNotEquals(actualTitle, incorrectTitle, "El título de la página no debería ser este.");

3. assertTrue

Verifica que una condición sea verdadera.

  Assert.assertTrue(isElementPresent, "El elemento debería estar presente.");

4. assertFalse

Verifica que una condición sea falsa.

   Assert.assertFalse(isElementPresent, "El elemento no debería estar presente.");
-----------------------------------------------------------------COMANDOS CONSOLA PARA CI/CD--------------------------------------------------
Opciones a la hora de correr tags

gradle test -Dcucumber.filter.tags="@Plans" -> Va a correr Scenarios taggeados con @Plan

gradle test -Dcucumber.filter.tags="Not @Plans" -> Va a correr todos los Scenarios que no tengan el tag @Plan

gradle test -Dcucumber.filter.tags="@Plans" and "@Courses"-> Va a correr todos los scenarios que tengan ambos, @Plan y @Courses tags al mismo tiempo.

gradle test -Dcucumber.filter.tags="@Plans" or "@Courses" -> Va a correr los scenarios que tengan los tags @Plans o @Courses (osea...todos los scenarios que tengan uno u otro).

gradle test -Dcucumber.filter.tags="@Plans" and not "@Courses" -> Va a correr todos los scenarios que tengan el tag "@Plans" y no tengan "@Courses".
 */


