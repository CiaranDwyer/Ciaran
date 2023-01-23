package pageObjects;

import base_Setup.base_Setup_Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class boi_Homepage extends base_Setup_Browser {

    WebDriver driver;
    WebDriverWait webDriverWait;

    By cookieMessage = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    By cookieBox = By.xpath("//div[@class='ot-sdk-container']//div[@class='ot-sdk-row']");
    By login = By.xpath("//span[contains(text(),'Log in/Register')]");
    By sideMenuLogin = By.xpath("//a[contains(text(),'Log in to 365 online')]");

    /* CONSTRUCTOR - SO WE USE THE SAME ACTIVE WEB-DRIVER OBJECT */
    public boi_Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /* METHODS - THESE PERFORM AN ACTION BUT MOSTLY RETURN SOMETHING */
    public void acceptCookies() {
        driver.manage().window().setSize(new Dimension(1000, 1000));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(cookieBox));
        driver.findElement(cookieMessage).click();
        driver.manage().window().maximize();
    }

    public void clickLogin() {
        driver.findElement(login).click();

        /* FluentWait fluentWait = new FluentWait<>(driver);
        //fluentWait.withTimeout(Duration.ofSeconds(5));
        //fluentWait.until(ExpectedConditions.elementToBeClickable(sideMenuLogin)); */
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sideMenuLogin));
        driver.findElement(sideMenuLogin).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }
}
