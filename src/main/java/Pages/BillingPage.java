package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.ConfigReader;

import java.io.ObjectInputFilter;

public class BillingPage extends BasePage{

    @FindBy(css = "input[placeholder='Email']")
    private WebElement eMailInput;

    @FindBy(xpath = "//input[@placeholder='Confirm Email']")
    private WebElement confirmEMailInput;

    @FindBy(xpath = "//input[@placeholder='Name On Card']")
    private WebElement nameInput;

    @FindBy(css = "iframe[name*='__privateStripeFrame']")
    private WebElement iframe;

    @FindBy(xpath = "//div[@class='CardField-input-wrapper']")
    private WebElement creditCartInformationInput;

    @FindBy(xpath = "//button[@class='Pay-Button']")
    private WebElement payBtn;

    @FindBy(xpath = "//div[@id='SnackBar']/span")
    private WebElement invalidMessageText;

    @FindBy(xpath = "//div[@id='SnackBar']/span")
    private WebElement captchaText;  // ödeme texti (verify)

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformationMaskWithInvalidNumber(){
        clickElement(eMailInput);
        sendKeysToElement(eMailInput, ConfigReader.getProperty("email"));
        clickElement(confirmEMailInput);
        sendKeysToElement(confirmEMailInput,ConfigReader.getProperty("email"));
        clickElement(nameInput);
        sendKeysToElement(nameInput,ConfigReader.getProperty("name"));
        driver.switchTo().frame(iframe);
        clickElement(creditCartInformationInput);
        sendKeysToElement(creditCartInformationInput,ConfigReader.getProperty("invalidCreditCartNumber"));
        driver.switchTo().parentFrame();
    }

    public void fillInformationMaskWithValidNumber(){
        clickElement(eMailInput);
        sendKeysToElement(eMailInput, ConfigReader.getProperty("email"));
        clickElement(confirmEMailInput);
        sendKeysToElement(confirmEMailInput,ConfigReader.getProperty("email"));
        clickElement(nameInput);
        sendKeysToElement(nameInput,ConfigReader.getProperty("name"));
        driver.switchTo().frame(iframe);
        clickElement(creditCartInformationInput);
        sendKeysToElement(creditCartInformationInput,ConfigReader.getProperty("validCreditCartNumber"));
        driver.switchTo().parentFrame();
    }

    public void clickPayBtn(){
        clickElement(payBtn);
    }

    public void VerifyInvalidMessage(){
        clickElement(payBtn);
        wait.until(ExpectedConditions.visibilityOf(invalidMessageText));
        verifyDisplayed(invalidMessageText,"Kart numaranız geçersiz.");
    }

    public void verifyCaptchaText(){
        clickElement(payBtn);
        wait.until(ExpectedConditions.visibilityOf(captchaText));
        verifyDisplayed(captchaText,"captcha text is not displayed");
    }
}
