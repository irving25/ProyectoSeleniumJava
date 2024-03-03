package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeRangeTesterTest {

    //setear la variable de tipo webdriver
    private WebDriver driver;

    //Ejecutar el codigo al inicio de las pruebas
    @BeforeMethod
    public void setUp(){
        //Inizializar el webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToFreeRangeTest(){
        //navega hasta la pagina mencionada
        driver.get("https://www.freerangetesters.com");
    }

    //Ejecutar el codigo al final de las pruebas
    @AfterMethod
    //Cerrar el navegador despues de la prueba
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
