package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.HomePage;
import pages.LeftSideMenu;

public class BrowserWindowsTests extends BaseTest{

    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnAlertsFrames();
        //new LeftSideMenu(driver).clickOnWindows();
    }

    @AfterClass
    public void classPostConditions() {
        // go to main tab and close all other tabs
        // close all tabs, except current
        new HomePage(driver).navigateToHomePage();
    }

    @Test
    public void isNewHandlerOpen() {
//        Assert.assertTrue(new BrowserWindowsPage(driver)
//                .openSamplePage()
//                .switchToSamplePage()
//                .verifySamplePageOpen());
    }
}
