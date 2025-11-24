package Step_definitions;

import Pages.BillingPage;
import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

public class US_305_DownloadEbookSteps {
    WebDriver driver= BaseDriver.getDriver();
    HomePage homePage=new HomePage(driver);
    CartPage cartPage=new CartPage(driver);
    BillingPage billingPage=new BillingPage(driver);

    @When("User navigates to home page")
    public void userNavigatesToHomePage() {
        driver.get("https://shopdemo.fatfreeshop.com/");
    }


    @Then("User adds the demo e-book to the cart")
    public void userAddsTheDemoEBookToTheCart() {
        homePage.clickDemoEbookAddCartBtn();
    }


    @Then("User clicks on {string} button")
    public void userClicksOnButton(String arg0) {
        cartPage.clickPayUsingDebitOrCreditCartButton();
    }


    @Then("User fill in the mask with invalid credit cart number")
    public void userFillInTheMaskWithInvalidCreditCartNumber() {
        billingPage.fillInformationMaskWithInvalidNumber();
    }


    @Then("Verify invalid paying message")
    public void verifyInvalidPayingMessage() {
        billingPage.VerifyInvalidMessage();
    }

    // ödeme işleminden ileriye CAPTCHA yüüznden geçemediğim için otomasyonumu devam ettiremiyorum.
}
