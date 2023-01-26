package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class boi_AuthPage {

    private final String expectedMessage = "We've sent a notification to security device";
    WebDriver driver;


    By actualMessage = By.xpath("//*[text()= 'We've sent a notification to security device']");

    public boi_AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkAuthMMessage() {

        return driver.findElement(actualMessage);
    }
}
