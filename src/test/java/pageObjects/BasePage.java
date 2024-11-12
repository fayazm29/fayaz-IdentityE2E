package pageObjects;

import base.DriverContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage()
    {
        PageFactory.initElements(DriverContext.driver,this);
    }

}