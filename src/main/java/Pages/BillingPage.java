package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ConfigReader;

import java.io.ObjectInputFilter;

public class BillingPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement eMailInput;

    @FindBy(xpath = "//input[@placeholder='Confirm Email']")
    private WebElement confirmEMailInput;

    @FindBy(xpath = "//input[@placeholder='Name On Card']")
    private WebElement nameInput;

    @FindBy(xpath = "//div[@class='CardField-input-wrapper']")
    private WebElement creditCartInformationInput;

    @FindBy(xpath = "//div[@id='SnackBar']/span")
    private WebElement invalidMessageText;

    @FindBy(xpath = "//input[@placeholder='Name On Card']")
    private WebElement captchaText;

    public BillingPage(WebDriver driver) {
        super(driver);
    }
    public void fillInformationMask(){
        sendKeysToElement(eMailInput, ConfigReader.getProperty("email"));
        sendKeysToElement(confirmEMailInput,ConfigReader.getProperty("email"));
        sendKeysToElement(nameInput,ConfigReader.getProperty("name"));
        sendKeysToElement(creditCartInformationInput,ConfigReader.getProperty("invalidCreditCartNumber"));
    }
    public void VerifyInvalidMessage(){
        verifyDisplayed(invalidMessageText,"Invalid Message is not disappear.");
    }
}
