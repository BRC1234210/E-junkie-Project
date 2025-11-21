package Step_definitions;

import Pages.BillingPage;
import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

public class US_304_VerifySuccessfulBillPaymentStep {

    WebDriver driver= BaseDriver.getDriver();
    HomePage homePage=new HomePage(driver);
    CartPage cartPage=new CartPage(driver);
    BillingPage billingPage=new BillingPage(driver);

    @Then("User fill in the mask with valid credit cart number")
    public void userFillInTheMaskWithValidCreditCartNumber() {
        billingPage.fillInformationMaskWithValidNumber();
    }


    @Then("Verify success paying message")
    public void verifySuccessPayingMessage() {
        billingPage.verifyCaptchaText();
    }
}
