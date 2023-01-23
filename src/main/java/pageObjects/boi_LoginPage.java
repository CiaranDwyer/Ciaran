package pageObjects;


import base_Setup.base_Setup_Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class boi_LoginPage extends base_Setup_Browser {

   WebDriver driver;

    By userID_Field = By.cssSelector("#C2__USER_NAME");

    public boi_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserID(){
        WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(5));
        myWait.until(ExpectedConditions.elementToBeClickable(userID_Field));
        driver.findElement(userID_Field).sendKeys("12345");
    }
}
