package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//iframe[@class='EJIframeV3 EJOverlayV3']")
    public WebElement iframe;

    @FindBy(css = "button.Payment-Button.CC")
    public WebElement payUsingDebitOrCreditCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPayUsingDebitOrCreditCartButton(){
        driver.switchTo().frame(iframe);
        clickElement(payUsingDebitOrCreditCartButton);
    }

    @FindBy(xpath = "//button[@class='Pay-Button']")
    public WebElement payButton;     // ödeme yap butonu

    public void clickPayButton(){
        clickElement(payButton);
    }
}
