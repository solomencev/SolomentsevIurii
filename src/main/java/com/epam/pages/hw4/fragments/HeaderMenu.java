package com.epam.pages.hw4.fragments;

import com.epam.pages.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
