package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenu extends BasePage{
    public LeftSideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement btnAlerts;

    @FindBy(xpath ="//span[contains(text(),'Browser Windows')]")
    WebElement btnOpenWindowsPage;

    public AlertsPage clickOnAlerts() {
        clickBase(btnAlerts);
        return new AlertsPage(driver);
    }

    public BrowserWindowsPage clickOnWindows() {
        clickWithJSScroll(btnOpenWindowsPage, 0, 200);
        return new BrowserWindowsPage(driver);
    }
}
