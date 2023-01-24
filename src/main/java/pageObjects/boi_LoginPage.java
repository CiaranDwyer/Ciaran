package pageObjects;


import base_Setup.base_Setup_Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class boi_LoginPage extends base_Setup_Browser {

    WebDriver driver;
    WebDriverWait myWait;
    Properties properties = base_Setup_Browser.getPropertiesObject();


    By userID_Field = By.cssSelector("#C2__USER_NAME");
    By DOB = By.cssSelector("#C2__QUE_7FF7CAFAACF93118221880");
    By continueButton = By.xpath("//span[contains(text(),'Continue')]");
    By cookieBanner = By.cssSelector("div[class='ot-sdk-container'] div[class='ot-sdk-row']");
    By acceptCookies = By.cssSelector("#onetrust-accept-btn-handler");

    public boi_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bannerLoaded() {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(cookieBanner));
        Boolean isDisplayed = driver.findElement(cookieBanner).isDisplayed();
        System.out.println("Button is clickable: " + isDisplayed);
        myWait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
    }

    public void enterUserID() throws InterruptedException {
        myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        myWait.until(ExpectedConditions.elementToBeClickable(userID_Field));
        Thread.sleep(300);
        driver.findElement(userID_Field).sendKeys(properties.getProperty("userID"));
    }

    public void enterDOB() {
        driver.findElement(DOB).sendKeys(properties.getProperty("DOB"));
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}