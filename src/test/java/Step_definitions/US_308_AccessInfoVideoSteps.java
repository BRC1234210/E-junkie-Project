package Step_definitions;

import Pages.AccessVideoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.BaseDriver;

public class US_308_AccessInfoVideoSteps {

    WebDriver driver = BaseDriver.getDriver();
    AccessVideoPage page = new AccessVideoPage(driver);

    @Given("the user navigates to the demo shop homepage")
    public void navigateToHomePage() {
        driver.get("https://shopdemo.fatfreeshop.com/?");
    }

    @When("the user clicks the {string} link in the footer")
    public void clickFooterLink(String arg0) {
        page.clickFooterEjunkieLink();
    }

    @Then("the user should be redirected to the e-junkie homepage")
    public void verifyEjunkieHome() {
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.e-junkie.com/"));
    }

    @When("the user clicks the {string} button")
    public void clickHowItWorks(String buttonName) {
        page.clickHowItWorks();
    }

    @Then("the information video pop-up should appear")
    public void verifyVideoPopup() {
        page.switchToVideoIframe();
    }

    @When("the user plays the video")
    public void playVideo() {
        page.clickPlayButton();
    }

    @And("the user waits for {int} seconds")
    public void waitSeconds(int seconds) {
        page.waitForSeconds(seconds);
    }

    @Then("the user closes the video pop-up")
    public void closeVideo() {
        page.closeVideoPopup();
    }
}
