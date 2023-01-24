package com.codewithciaran;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.boi_Homepage;
import pageObjects.boi_LoginPage;
import pageObjects.boi_PinPage;
import testNG_Listener.ListenerTest;


@Listeners(ListenerTest.class)
public class Test_Case1 extends base_Test {

    /* CREATE AN OBJECT OF THE HOMEPAGE CLASS SO I CAN USE THE METHODS */
    boi_Homepage homepage1;
    boi_LoginPage loginPage;
    boi_PinPage boi_pinPage;

    public static Logger myLogs = LogManager.getLogger(Test_Case1.class.getName());

    @Test
    public void Banking365_NavigationPages() throws InterruptedException {

        System.out.println("---------- Banking365_NavigationPages -----------");
        myLogs.fatal("Fatal Message");

        homepage1 = new boi_Homepage(driver);
        homepage1.acceptCookies();
        homepage1.clickLogin();
    }


    @Test(dependsOnMethods = "Banking365_NavigationPages")
    public void Banking365_Successful_Login() throws InterruptedException {

        loginPage = new boi_LoginPage(driver);
        loginPage.bannerLoaded();
        loginPage.enterUserID();
        loginPage.enterDOB();
        loginPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "Banking365_Successful_Login")
    public void enterPAC() throws InterruptedException {
        boi_pinPage = new boi_PinPage(driver);

    }
}
