package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage extends BasePage{

    @FindBy(id = "sender_name")
    public WebElement nameInput;

    @FindBy(id = "sender_email")
            public WebElement emailInput;

    @FindBy(id = "sender_subject")
            public WebElement subjectInput;

    @FindBy(id = "sender_message")
            public WebElement messageInput;

    @FindBy(css = "div[class='recaptcha-checkbox-checkmark']")
            public WebElement recaptchaBtn;
    @FindBy(id = "send_message_button")
            public WebElement sendMessageBtn;


    HomePage homePage = new HomePage(driver);
    public void clickContactUsBtn(){
        homePage.contactUsButton.click();
    }

  public void clickTheRecaptchaBtn(){
        clickElement(recaptchaBtn);
  }
  public void clickTheSendMessageBtn (){
        clickElement(sendMessageBtn);
  }


    public void AlertMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String text = alert.getText();
        Assert.assertEquals(text, "Recaptcha didn't match");

        alert.accept();
    }

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
}
