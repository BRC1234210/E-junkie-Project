package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='columns products is-multiline']/div[2]/a/div/div/button")
    private WebElement demoEbookAddCartBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDemoEbookAddCartBtn(){
        clickElement(demoEbookAddCartBtn);
    }
}
