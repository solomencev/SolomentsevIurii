package com.epam.tc.hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = "li.uui-profile-menu")
    private WebElement loginDropdown;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginSubmit;

    @FindBy(id = "user-name")
    private WebElement loginName;

    public static final String HOME_PAGE = "Home Page";
    public static final String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(URL_HOME_PAGE);
    }

    public String getBrowserTitleName() {
        return driver.getTitle();
    }

    public void login(String user, String password)  {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    public String getUserName() {
        return loginName.getText();
    }
}
