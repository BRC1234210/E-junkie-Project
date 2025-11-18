package Step_definitions;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;


public class
US_307_goHomePageSteps {

    WebDriver driver;
    HomePage homePages;

    public Logger LOGGER = LogManager.getLogger(this.getClass());


    @Given("the browser is opened and the user navigates to the website")
    public void theBrowserIsOpenedAndTheUserNavigatesToTheWebsite() {
        driver= BaseDriver.getDriver();
        homePages=new HomePage(driver);

        driver.get("https://shopdemo.fatfreeshop.com/");
        LOGGER.info("");

    }

    @When("the customer clicks the {string} button located at the bottom-right corner")
    public void theCustomerClicksTheButtonLocatedAtTheBottomRightCorner(String goHome) {
        homePages.clickGoHomePageButton();

        LOGGER.info("");
    }

    @Then("the customer verifies that the URL is {string}")
    public void theCustomerVerifiesThatTheURLIs(String arg0) {
        homePages.verifyEjunkie();
    }
}
