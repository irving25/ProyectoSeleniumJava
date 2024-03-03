package pages;

import java.util.List;

public class RegistroPage extends BasePage{

    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";
    public RegistroPage() {
        super(driver);
    }

    public List<String> returPlanDropdownValues(){
        return getDropdrowValues(planDropdown);
    }


}
