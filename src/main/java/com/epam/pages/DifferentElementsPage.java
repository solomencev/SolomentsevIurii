package com.epam.pages;

import com.epam.pages.utils.WaitActions;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {

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

    WaitActions waitActions;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
    }

    public void selectRadioButton(WebElement element) {
        element.click();
    }

    public void selectCheckboxes(WebElement element) {
        element.click();
    }

    public void selectDropDown(WebElement element) {
        element.click();
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
