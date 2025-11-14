package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='columns products is-multiline']/div[2]/a/div/div/button")
    private WebElement demoEbookAddCartBtn;  // e book ürününü sepete ekle

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDemoEbookAddCartBtn(){
        clickElement(demoEbookAddCartBtn);
    }

    @FindBy(xpath = "//div[@class='navbar-end']/a/i")
    public WebElement addToCartPageButton;  // sepete gitme butonu

    public void clickAddToCartPageButton() {
        clickElement(addToCartPageButton);
    }

    @FindBy(xpath = "//a[@class='EJ-ShopLink']")
    public WebElement goHomePageButton;     // US_307 İÇİN anasayfaya dönme butonu

    public void clickGoHomePageButton() {
        clickElement(goHomePageButton);
    }

    @FindBy(xpath = "//a[@class='contact']")
    public WebElement contactUsButton; // iletişim kurma butonu

    public void clickContactUsButton() {
        clickElement(contactUsButton);
    }
    @FindBy(xpath = "//div[@class='column is-2-desktop is-4-tablet is-4-mobile']/a/img")
    public WebElement EJunkieVerify;  // US_307 nin son adımı verify.

    public void verifyEjunkie() {
        verifyDisplayed(EJunkieVerify, "EJunkie page is no displayed");
    }

    @FindBy(xpath = "//a[@class='EJ-ShopLink']")
    public WebElement eJunkieButton;                  // E-commerce by E-junkie butonuna basar.
    public void ClickEjunkieButton(){
        clickElement(eJunkieButton);
    }


}
