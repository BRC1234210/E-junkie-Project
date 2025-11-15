package Step_definitions;

import Pages.EbookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

public class US_301_AddEbookToCartSteps {

    WebDriver driver = BaseDriver.getDriver();
    EbookPage ebookPage = new EbookPage(driver);

    @Given("the user navigates to the e-junkie demo page")
    public void navigateToEjunkie() {
        driver.get("https://shopdemo.e-junkie.com/");
    }

    @When("the user clicks the {string} button for the e-book")
    public void clickAddToCart(String text) {
        ebookPage.clickAddToCart();
    }

    @Then("the e-book should be successfully added to the cart")
    public void verifyCartOpened() {
        driver.switchTo().frame(ebookPage.cartIframe);
    }

    @When("the user clicks the {string} link")
    public void clickPromoCodeLink(String text) {
        ebookPage.openPromoCodeField();
    }

    @And("the user enters an invalid promo code {string}")
    public void enterInvalidPromo(String code) {
        ebookPage.enterPromoCode(code);
    }
    @And("the user clicks the Apply promo code button")
    public void clickApplyButton() {
        ebookPage.clickApplyPromo();
    }

    @Then("an invalid promo code warning should be displayed")
    public void verifyInvalidPromoWarning()throws InterruptedException {
        if (!ebookPage.isInvalidPromoDisplayed()) {
            throw new AssertionError("Invalid promo code warning not displayed!");
        }
    }
}
