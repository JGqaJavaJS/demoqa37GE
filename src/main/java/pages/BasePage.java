package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

    WebDriver driver;
    JavascriptExecutor js;
    static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // with chain and @FindBy
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void clickBase(WebElement element) {
        element.click();
    }

    public void clickWithJSScroll(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        clickBase(element);
    }

    public void typeText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
