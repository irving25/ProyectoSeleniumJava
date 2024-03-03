package pages;

import org.openqa.selenium.WebDriver;

public class CursosPage extends  BasePage{

    private String fundamentosTestingLink = "//h2[contains(text(),'Fundamentos del Testing')]";
    public CursosPage() {
        super(driver);
    }

    public void clickFundamentostestlink(){
        clickElement(fundamentosTestingLink);
    }


}
