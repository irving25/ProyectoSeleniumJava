package pages;

public class FreeRangeTestPage extends BasePage{

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String btnEligePlan = "//a[normalize-space()='Elegir Plan']";
    public FreeRangeTestPage() {
        super(driver);
    }

    //Metodo para navegar a pagina de amazon
    public void navigateToFreeRangeTest(){
        navigateTo("https://www.freerangetesters.com");
    }
    public void clickSectionCourseBar(String section){
        //Reemplazar el marcador de posicion en sectionLink con el nombre
        String xpathSection = String.format(sectionLink,section);
        clickElement(xpathSection);
    }
    public void clickOnElegirPlan(){
        clickElement(btnEligePlan);
        //Facken chet 
    }

}
