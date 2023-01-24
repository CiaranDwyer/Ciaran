package pageObjects;

import base_Setup.base_Setup_Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class boi_Homepage extends base_Setup_Browser {

    WebDriver driver;
    WebDriverWait webDriverWait;

    By acceptCookie = By.cssSelector("#onetrust-reject-all-handler");
    By cookieBox = By.cssSelector("div[class='ot-sdk-container'] div[class='ot-sdk-row']");
    By loginLink = By.xpath("//*[text()= 'Log in/Register']");

    By sideMenuLogin = By.xpath("//a[contains(text(),'Log in to 365 online')]");

    /* CONSTRUCTOR - SO WE USE THE SAME ACTIVE WEB-DRIVER OBJECT */
    public boi_Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /* METHODS - THESE PERFORM AN ACTION BUT MOSTLY RETURN SOMETHING */
    public void acceptCookies() {
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cookieBox));
        driver.findElement(acceptCookie).click();
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(loginLink).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sideMenuLogin));
        driver.findElement(sideMenuLogin).click();
    }
}