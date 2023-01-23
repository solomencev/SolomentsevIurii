package com.epam.pages.hw4.fragments;

import com.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceMenu extends BasePage {

    @FindBy(xpath = "//li/a[text()='Different elements']")
    private WebElement differentElements;

    public ServiceMenu(WebDriver driver) {
        super(driver);
    }

    public void clickDifferentElements() {
        differentElements.click();
    }
}
