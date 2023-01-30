package com.epam.tc.hw5.fragments;

import com.epam.tc.hw5.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends BasePage {

    @FindBy(xpath = "//li[@class='dropdown']")
    private WebElement serviceMenuDropDown;

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsServiceElement;

    @FindBy(xpath = "//a[text()='User Table ']")
    private WebElement userTablePageElement;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void openDifferentElementPage() {
        serviceMenuDropDown.click();
        differentElementsServiceElement.click();
    }

    public void clickServiceMenu() {
        serviceMenuDropDown.click();
    }

    public void clickUserTablePageElement() {
        userTablePageElement.click();
    }


}
