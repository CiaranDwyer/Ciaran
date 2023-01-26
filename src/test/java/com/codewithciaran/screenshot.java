package com.codewithciaran;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class screenshot {


        public static void main(String[] args) throws IOException {

            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

            WebDriver driver = new FirefoxDriver();
            try {
                // Your test code here
                Assert.assertTrue(false);
            } catch (AssertionError e) {
                // Navigate to the page
                driver.get("http://www.google.com");
                // Take a screenshot
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("./CiaranJonathanDwyer/picture.png"));
                screenshot.renameTo(new File(" screenshot.png"));
            }
            // Close the browser
            //  REMOVED COMMENTS
            driver.quit();
        }
    }

