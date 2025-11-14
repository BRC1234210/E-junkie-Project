package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[@class='Payment-Button CC']")
    private WebElement payUsingDebitOrCreditCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickPayUsingDebitOrCreditCartButton(){
        clickElement(payUsingDebitOrCreditCartButton);
    }
}
