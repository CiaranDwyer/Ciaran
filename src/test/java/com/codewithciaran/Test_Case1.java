package com.codewithciaran;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.boi_Homepage;
import pageObjects.boi_LoginPage;
import testNG_Listener.ListenerTest;


@Listeners(ListenerTest.class)
public class Test_Case1 extends base_Test {

    /* CREATE AN OBJECT OF THE HOMEPAGE CLASS SO I CAN USE THE METHODS */
    boi_Homepage homepage1;
    boi_LoginPage loginPage;
    String name;

    public static Logger myLogs = LogManager.getLogger(Test_Case1.class.getName());

    @Test
    public void Banking365_Login() {

        System.out.println("---------- TEST 1 -----------");
        myLogs.fatal("Fatal Message");
        myLogs.info("Info Message");
        myLogs.warn("Warning Message");
        myLogs.error("Error Message");
        myLogs.debug("Debug Message");

        homepage1 = new boi_Homepage(driver);
        homepage1.acceptCookies();
    }

    @Test
    public void clickLoginButton() {
        homepage1.clickLogin();
    }

    @Test
    public void enterUserID() {
        loginPage = new boi_LoginPage(driver);
        loginPage.enterUserID();
    }
}