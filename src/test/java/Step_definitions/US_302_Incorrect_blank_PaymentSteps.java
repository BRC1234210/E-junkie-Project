package Step_definitions;


import Pages.BillingPage;
import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class US_302_Incorrect_blank_PaymentSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver=BaseDriver.getDriver();
    CartPage cartPage=new CartPage(driver);
    BillingPage billingPage=new BillingPage(driver);
    HomePage homePage=new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("Navigate to the webpage")
    public void navigate_to_the_webpage() {
        driver.get("https://shopdemo.fatfreeshop.com/");
        LOGGER.info("Navigated to webpage");
    }

    @Then("Find Demo ebook and click add to cart button")
    public void find_demo_ebook_and_click_add_to_cart_button() {
     homePage.clickDemoEbookAddCartBtn();
        LOGGER.info("Added demo ebook to cart");
    }
    @Then("Select payment method,using credit card")
    public void select_payment_method_using_credit_card() {
        WebElement frame = driver.findElement(By.cssSelector("iframe[class*='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.payUsingDebitOrCreditCartButton));
        cartPage.clickPayUsingDebitOrCreditCartButton();
        LOGGER.info("Selected credit card payment");
    }
    @Then("Leave fields blank on the payment page and click pay button")
    public void leave_fields_blank_on_the_payment_page_and_click_pay_button() {
     cartPage.clickPayButton();
        LOGGER.info("Clicked pay button with blank fields");
    }
    @Then("Verify that the Invalid field errors are displayed simultaneously")
    public void verify_that_the_invalid_field_errors_are_displayed_simultaneously() {

        billingPage.VerifyInvalidMessage();
        LOGGER.info("Verified error messages");
    }

}
