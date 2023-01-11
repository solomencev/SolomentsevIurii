package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class DifferentElementsPage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    private WebElement checkBoxWater;

    public WebElement getCheckBoxWater() {
        return checkBoxWater;
    }

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    private WebElement checkBoxWind;

    public WebElement getCheckBoxWind() {
        return checkBoxWind;
    }

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    private WebElement radioButtonSelen;

    public WebElement getRadioButtonSelen() {
        return radioButtonSelen;
    }

    @FindBy(xpath = "//*[text()='Yellow']")
    private WebElement dropdownYellow;

    public WebElement getDropdownYellow() {
        return dropdownYellow;
    }

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logs;

    public List<WebElement> getLogs() {
        return logs;
    }

    WaitActions waitActions;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
    }
}
