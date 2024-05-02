package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Select Option')]")
    WebElement fieldSelectMenu;

    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElement selectDropDown;

    @FindBy(xpath="//div[@id='selectOne']")
    WebElement selectOne;

    @FindBy(id = "react-select-4-input")
    WebElement multiselect;

    @FindBy(className = "text-center")
    WebElement pageTitle;

    public SelectMenuPage fillSelectValue(String str) {
        clickWithJSScroll(fieldSelectMenu, 0, 400);
        //some function to click on text
        return this;
    }

    public SelectMenuPage fillSelectOne(String str) {

        return this;
    }

    public SelectMenuPage fillOldStyleSelectMenu(String str) {
        Select select = new Select(selectDropDown);
        select.selectByVisibleText(str);

        List<WebElement> options = select.getOptions();
        for(WebElement element: options) {
            if(getTextBase(element).equals(str)) {
                clickBase(element);
                break;
            }
        }
        return this;
    }

    public SelectMenuPage fillMultiSelect(String[] colors) {
        for(String color: colors) {
            multiselect.sendKeys(color);
            multiselect.sendKeys(Keys.ENTER);
        }
        clickBase(pageTitle);
        pause(5000);
        return this;
    }
}
