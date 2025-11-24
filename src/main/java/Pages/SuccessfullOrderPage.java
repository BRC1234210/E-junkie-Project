package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullOrderPage extends BasePage{

    @FindBy(xpath = "//span[@class='green_text_margin']")
    public WebElement successfulText;

    public void verifySuccessfulText(){
        verifyDisplayed(successfulText,"succesfull text is not displayed");
    }

    @FindBy(xpath = "//span[@class='download_btn top10']")
    public WebElement downloadButton;

    public void clickDownloadButton(){
        clickElement(downloadButton);
    }





    public SuccessfullOrderPage(WebDriver driver) {
        super(driver);
    }
}
