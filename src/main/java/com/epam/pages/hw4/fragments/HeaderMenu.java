package com.epam.pages.hw4.fragments;

import com.epam.pages.BasePage;
import com.epam.pages.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends BasePage {

    WaitActions waitActions;
    private ServiceMenu serviceMenu;

    @FindBy(xpath = "//li[@class='dropdown']")
    private WebElement serviceMenuDropDown;

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsServiceElement;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void clickServiceMenu() {
        serviceMenuDropDown.click();
    }

    public void clickOnDifferentElementsServiceElement() {
        differentElementsServiceElement.click();
    }


}
