package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    /*
    * Declaracion de una variable estatica driver de tipo WebDriver
    * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
    * El modificador de acceso protected es para que la variable se pueda usar en clases, paquetes y subclases
     */
    protected static WebDriver driver;
    //Wait variable de tipo WebDriverWait, se incializa con el driver estatico, se usa para las esperas explicitas de los elementos
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    //Configuracion del driver con chrome, WebDriverManager va a descargar y configurar automaticamente el driver del navegador
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        //Cuando la heredemos esta clase dara acceso a todas estas funciones a las demas clases
    }

    public static void closeBrowser(){
        driver.quit();
    }
    public static void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    //Se crea el objeto de tipo webelement, se devuelve haciendo una espera hasta que se presente el elemento localizado por xpath usando el locator de argumento dame el webelement
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    public void clickElement(String locator){
        Find(locator).click();
    }
    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
    public void selectFromDropdownByText(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(value);
    }

    public void selectFromDropdownByIndex(String locator, int value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(value);
    }
    //Funcion de cantidad de webelements de un dropdown
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    //Devolver valores del dropdown
    public List<String> getDropdrowValues(String locator){
        //Instancia del select de selenium, funciones y metodos de selenium
        Select dropdown = new Select(Find(locator));
        //Se hacer la instancia de la lista, guardando los webelements del dropdown y los guarda en la lista, con la funcion getOptions toma las opciones del select
        List<WebElement> dropDownOptions = dropdown.getOptions();
        //Se hace el array
        List<String> values = new ArrayList<>();
        //Para cada opcion de la lista, se agregara al array
        for (WebElement option : dropDownOptions){
            values.add(option.getText());
        }
        return values;
    }
}
