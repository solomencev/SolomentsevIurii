package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class DifferentElementsPage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public WebElement checkBoxWater;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public WebElement checkBoxWind;

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    public WebElement radioButtonSelen;

    @FindBy(xpath = "//*[text()='Yellow']")
    public WebElement dropdownYellow;

    @FindBy(css = ".panel-body-list.logs > li")
    public List<WebElement> logs;

    WaitActions waitActions;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
    }


}
