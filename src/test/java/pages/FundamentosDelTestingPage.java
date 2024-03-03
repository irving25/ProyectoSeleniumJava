package pages;

import org.openqa.selenium.WebDriver;

public class FundamentosDelTestingPage extends BasePage{

    private String introduccionTestingLink = "//h2[contains(text(),'Introducción al Testing de Software')]";
    public FundamentosDelTestingPage() {
        super(driver);
    }

    public void clickIntroduccionTestingLink(){
        clickElement(introduccionTestingLink);
    }
}
