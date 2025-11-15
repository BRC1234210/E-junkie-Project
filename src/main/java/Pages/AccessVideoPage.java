package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AccessVideoPage extends BasePage{

    @FindBy(xpath = "//a[@class='EJ-ShopLink']")
    public WebElement footerEjunkieLink;

    @FindBy(xpath = "//div[@class='banner_btn']/a[@class='blue_btn']")
    public WebElement howItWorksButton;

    @FindBy(css = "iframe[src*='youtube']")
    public WebElement youtubeIframe;

    @FindBy(css = "button[aria-label='Play']")
    public WebElement playButton;

    @FindBy(xpath = "//div[@id='offerModal']//div[@class='modal-background']")
    public WebElement trialPopupBackground;

    @FindBy(xpath = "//div[@id='offerModal']//div[@class='modal-card']")
    public WebElement trialPopupCard;

    @FindBy(css = "button.modal-close")
    public WebElement videoModalCloseButton;

    public AccessVideoPage(WebDriver driver) {

        super(driver);
    }
    public void clickFooterEjunkieLink() {
        clickElement(footerEjunkieLink);
    }
    public void clickHowItWorks() {
        clickElement(howItWorksButton);
    }
    public void switchToVideoIframe() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(trialPopupCard));
            clickElement(trialPopupCard);
            clickElement(trialPopupBackground);
        } catch (Exception e) {
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(youtubeIframe));
    }
    public void clickPlayButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(playButton));

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", playButton);
        }
    }
    public void waitForSeconds(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(driver -> true);
    }
    public void closeVideoPopup() {
        driver.switchTo().defaultContent();
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(videoModalCloseButton));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", videoModalCloseButton);
        }
    }
}

