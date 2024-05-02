package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='card-body']//h5[contains(text(),'Alerts')]")
    WebElement btnAlertsFrames;

    @FindBy(xpath="//div[@class='card-body']//h5[contains(text(),'Widgets')]")
    WebElement btnWidgets;

    public AlertsWindowsPage clickOnAlertsFrames() {
        clickWithJSScroll(btnAlertsFrames, 0, 300);
        return new AlertsWindowsPage(driver);
    }

    public HomePage navigateToHomePage() {
        driver.navigate().to("https://demoqa.com/");
        return  this;
    }

    public WidgetsPage clickOnWidgets() {
        clickWithJSScroll(btnWidgets, 0, 300);
        return new WidgetsPage(driver);
    }
}
