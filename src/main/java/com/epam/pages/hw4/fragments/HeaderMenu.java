package com.epam.pages.hw4.fragments;

import com.epam.pages.BasePage;
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
