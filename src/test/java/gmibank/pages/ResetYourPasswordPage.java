package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetYourPasswordPage extends BasePage{

    @FindBy(xpath = "//h1")
    public WebElement pageHeader;

    public String getPageHeader(){
        return pageHeader.getText();
    }


}
