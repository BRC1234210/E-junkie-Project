package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(css = "#Overlay > div > div.container.Cart > div > div.column.one-half.RightColumn > div.Payment-Section > div > button.Payment-Button.CC")
    public WebElement payUsingDebitOrCreditCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickPayUsingDebitOrCreditCartButton(){
        clickElement(payUsingDebitOrCreditCartButton);
    }


    @FindBy(xpath = "//button[@class='Pay-Button']")
    public WebElement payButton;     // ödeme yap butonu

    public void clickPayButton(){
        clickElement(payButton);
    }
}
