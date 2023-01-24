package com.epam.pages;

import com.epam.pages.utils.WaitActions;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    private WebElement checkBoxWater;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    private WebElement checkBoxWind;

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    private WebElement radioButtonSelen;

    @FindBy(xpath = "//*[text()='Yellow']")
    private WebElement dropdownYellow;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void selectRadioButtonSelen() {
        radioButtonSelen.click(); //  private WebElement radioButtonSelen;
    }

    public void selectCheckBoxWind() {
        checkBoxWind.click(); // private WebElement checkBoxWind;
    }

    public void selectCheckBoxWater() {
        checkBoxWater.click(); // private WebElement checkBoxWater;
    }

    public void selectDropDownYellow() {
        dropdownYellow.click(); // private WebElement dropdownYellow;
    }

    public WebElement getCheckBoxWater() {
        return checkBoxWater;
    }

    public WebElement getCheckBoxWind() {
        return checkBoxWind;
    }

    public WebElement getRadioButtonSelen() {
        return radioButtonSelen;
    }

    public WebElement getDropdownYellow() {
        return dropdownYellow;
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
