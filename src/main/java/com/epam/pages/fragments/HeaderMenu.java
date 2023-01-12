package com.epam.pages.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class HeaderMenu {

    WaitActions waitActions;
    private ServiceMenu serviceMenu;

    @FindBy(xpath = "//li[@class='dropdown']")
    private WebElement serviceMenuDropDown;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        serviceMenu = new ServiceMenu(driver);
    }

    public ServiceMenu clickServiceMenu() {
        serviceMenuDropDown.click();
        return serviceMenu;
    }

}
