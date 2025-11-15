package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class EbookPage extends BasePage {

    @FindBy(css = "button[onclick*='1595015']")
    public WebElement addEbookToCartButton;

    @FindBy(xpath = "//button[@class='Apply-Button Show-Promo-Code-Button']")
    public WebElement promoCodeButton;

    @FindBy(xpath = "//input[@class='Promo-Code-Value']")
    public WebElement promoCodeInput;

    @FindBy(xpath = "//button[@class='Promo-Apply']")
    public WebElement applyPromoButton;

    @FindBy(xpath = "//span[contains(text(),'Invalid')]")
    public WebElement invalidPromoMsg;

    @FindBy(css = "iframe.EJIframeV3")
    public WebElement cartIframe;

    public EbookPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addEbookToCartButton).click().perform();
    }
    public void openPromoCodeField() {
        Actions actions = new Actions(driver);
        actions.moveToElement(promoCodeButton).click().perform();
    }
    public void enterPromoCode(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(promoCodeInput));

        Actions actions = new Actions(driver);
        actions.moveToElement(promoCodeInput)
               .click()
               .sendKeys(code)
               .perform();
    }
    public void clickApplyPromo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(applyPromoButton).click().perform();

    }
    public boolean isInvalidPromoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(invalidPromoMsg));
        return invalidPromoMsg.isDisplayed();
    }
}
