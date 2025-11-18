package Step_definitions;

import Pages.BillingPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.SuccessfullOrderPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class US_305_DownloadEbookSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver=BaseDriver.getDriver();
    CartPage cartPage=new CartPage(driver);
    BillingPage billingPage=new BillingPage(driver);
    SuccessfullOrderPage successfullOrderPage=new SuccessfullOrderPage(driver);
    HomePage homePage=new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @And("the customer clicks the {string} button")
    public void theCustomerClicksTheButton(String arg0) {
        driver.get("https://shopdemo.fatfreeshop.com/");

        homePage.clickAddToCartPageButton();
    }

    @And("the customer clicks the {string} option")
    public void theCustomerClicksTheOption(String arg0) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'Payment-Button')]")
        ));
        cartPage.clickPayUsingDebitOrCreditCartButton();
    }


    @And("the customer fills in all required fields")
    public void theCustomerFillsInAllRequiredFields() {
    billingPage.fillInformationMaskWithValidNumber();
    }


    @And("the customer clicks the Pay button")
    public void theCustomerClicksThePayButton() {
        cartPage.clickPayButton();
    }

    @Then("the customer should be able to verify the confirmation message")
    public void theCustomerShouldBeAbleToVerifyTheConfirmationMessage() {
        successfullOrderPage.verifySuccessfulText();
    }

    @And("the customer clicks the {string} button to download the e-book")
    public void theCustomerClicksTheButtonToDownloadTheEBook(String arg0) {
     successfullOrderPage.clickDownloadaButton();
    }


}
