package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class boi_PinPage {

    WebDriver driver;

    By pinPageText = By.xpath("//*[text()= 'Your 365 PIN']");
    By pinNum1 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2500");
    By pinNum2 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2501");
    By pinNum3 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2502");
    By pinNum4 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2503");
    By pinNum5 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2504");
    By pinNum6 = By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2504");
    By loginInButton = By.xpath("//span[normalize-space()='Log in']");


    public boi_PinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPinText() {
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(pinPageText));
        String pinText = driver.findElement(pinPageText).getText();
        System.out.println("PIN TEXT IS DISPLAYED AS " +pinText);
    }

    public void enterPAC() throws InterruptedException {

        WebElement elementPinNum1 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2500"));
        WebElement elementPinNum2 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2501"));
        WebElement elementPinNum3 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2502"));
        WebElement elementPinNum4 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2503"));
        WebElement elementPinNum5 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2504"));
        WebElement elementPinNum6 = driver.findElement(By.cssSelector("#C2__C2__C1__QUE_188DA78A3B0DB18F2505"));

        if (elementPinNum1.isEnabled()) driver.findElement(pinNum1).sendKeys("0");
        else if (elementPinNum2.isEnabled()) {
            driver.findElement(pinNum2).sendKeys("7");
            Thread.sleep(1000);
        } else if (elementPinNum3.isEnabled()) {
            driver.findElement(pinNum3).sendKeys("0");
            Thread.sleep(1000);
        } else if (elementPinNum4.isEnabled()) {
            driver.findElement(pinNum4).sendKeys("8");
            Thread.sleep(1000);
        } else if (elementPinNum5.isEnabled()) {
            driver.findElement(pinNum5).sendKeys("1");
            Thread.sleep(1000);
        } else if (elementPinNum6.isEnabled()) {
            driver.findElement(pinNum6).sendKeys("9");
            Thread.sleep(1000);
        } else {
            System.out.println("incorrect pin entered");
        }
    }

    public void clickLogin() {
        driver.findElement(loginInButton).click();
    }
}
