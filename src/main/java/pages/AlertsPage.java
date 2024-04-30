package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement btnAlert5Sec;

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    public AlertsPage clickAccept(Alert alert) {
        alert.accept();
        return this;
    }

    public AlertsPage clickDismiss(Alert alert) {
        alert.dismiss();
        return this;
    }

    private void typeAlert(String text, Alert alert) {
        alert.sendKeys(text);
    }

    private String getMessageAlert(Alert alert) {
        return alert.getText().trim();
    }

    public AlertsPage closeAlertIfPresent() {
        try {
            clickAccept(getAlert());
        } catch (Exception e) {
            logger.info("alert not displays");
        }
        return this;
    }

    public boolean verifyAlert5SecsOpen() {
        clickWithJSScroll(btnAlert5Sec, 0, 300);
        pause(5200);
        Alert alert = getAlert();
        String expectedRes = "This alert appeared after 5 seconds";
        String actualRes = getMessageAlert(alert);
        clickAccept(alert);
        return expectedRes.equals(actualRes);
    }
}
