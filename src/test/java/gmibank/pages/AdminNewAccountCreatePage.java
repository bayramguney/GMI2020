package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminNewAccountCreatePage extends BasePage{


   @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement adminAccountNotCreatedAlert;





}
