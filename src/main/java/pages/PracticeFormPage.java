package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement inputName;

    @FindBy(id = "lastName")
    WebElement inputLastName;

    @FindBy(id = "userEmail")
    WebElement inputEmail;

    @FindBy(id = "userNumber")
    WebElement inputPhone;

    @FindBy(xpath = "//*[contains(@id,'gender-radio')]")
    List<WebElement> allGendersRadio;


    public PracticeFormPage enterPersomalData(String name, String lastName,
                                              String email, String phone) {
        typeText(inputName, name);
        typeText(inputLastName, lastName);
        typeText(inputEmail, email);
        typeText(inputPhone, phone);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        for(WebElement el:allGendersRadio) {
            if (getTextBase(el).equals(gender)) {
                clickBase(el);
                break;
            }
        }
        return this;
    }

    public PracticeFormPage enterBirthDay(String dateBirth) {
        clickWithJSScroll(inputDateOfBirth, 0, 300);
        Keys key = getKeyForOSCommandOrControl();
        inputDateOfBirth.sendKeys(key, "a");
        inputDateOfBirth.sendKeys(dateBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }
}
