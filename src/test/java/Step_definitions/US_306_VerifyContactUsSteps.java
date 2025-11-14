package Step_definitions;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

import java.util.List;

public class US_306_VerifyContactUsSteps {


    WebDriver driver;
    HomePage homePages;
    ContactUsPage contactUsPage;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @When("Navigate to the Web Page")
    public void navigateToTheWebPage() {
        driver= BaseDriver.getDriver();
        homePages=new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);

        driver.get("https://shopdemo.fatfreeshop.com/");
        LOGGER.info("Web Page successfully navigated");


    }

    @Then("Click on the Contact Us Link")
    public void clickOnTheContactUsLink() {
        contactUsPage.clickContactUsBtn();
        LOGGER.info("Contact Button successfully clicked");
    }


    @Then("Send a message as {string}")
    public void sendAMessageAs(String message) {
        contactUsPage.sendKeysToElement(contactUsPage.messageInput, message);
        LOGGER.info("Message successfully entered");

    }


    @Then("Click on the Send Message Button")
    public void clickOnTheSendMessageButton() {
    contactUsPage.clickTheSendMessageBtn();
    LOGGER.info("Send Message button clicked");
    }

    @Then("Verify {string} pop up")
    public void verifyPopUp(String popUp) {
        contactUsPage.AlertMessage();
        LOGGER.info("Allert message verified");
        LOGGER.info("Contact Us was Successful");
    }


    @Then("Fill in the form {string} {string} {string}")
    public void fillInTheForm(String name, String email, String subjectBox) {

        contactUsPage.sendKeysToElement(contactUsPage.nameInput, name);
        contactUsPage.sendKeysToElement(contactUsPage.emailInput, email);
        contactUsPage.sendKeysToElement(contactUsPage.subjectInput, subjectBox);
        LOGGER.info("Fill iin the form successfully filled");
    }
}
