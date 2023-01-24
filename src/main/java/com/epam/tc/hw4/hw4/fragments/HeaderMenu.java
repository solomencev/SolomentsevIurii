package com.epam.tc.hw4.hw4.fragments;

import com.epam.tc.hw4.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends BasePage {

    @FindBy(xpath = "//li[@class='dropdown']")
    private WebElement serviceMenuDropDown;

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsServiceElement;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void clickServiceMenuAndThenDifferentElementService() {
        serviceMenuDropDown.click();
        differentElementsServiceElement.click();
    }
}
