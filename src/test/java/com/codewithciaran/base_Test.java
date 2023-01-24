package com.codewithciaran;

import base_Setup.base_Setup_Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class base_Test {

    base_Setup_Browser baseSetupBrowser;
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void launchBrowser() throws IOException {

        /* CREATE AN OBJECT OF THE base_Setup_Browser CLASS */
        baseSetupBrowser = new base_Setup_Browser();
        driver = baseSetupBrowser.setupBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}