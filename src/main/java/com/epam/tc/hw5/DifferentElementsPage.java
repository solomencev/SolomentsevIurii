package com.epam.tc.hw5;

import java.util.Collection;
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
        radioButtonSelen.click();
    }

    public void selectCheckBoxWind() {
        checkBoxWind.click();
    }

    public void selectCheckBoxWater() {
        checkBoxWater.click();
    }

    public void selectDropDownYellow() {
        dropdownYellow.click();
    }

    public boolean areLogsContainsItem(Collection<WebElement> logs, String expectedEntry) {
        for (var logElement : logs) {
            if (logElement.getText().contains(expectedEntry)) {
                return true;
            }
        }
        return false;
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
