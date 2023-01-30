package com.epam.tc.hw6;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTextUnderImages;

    @FindBy(id = "frame")
    private WebElement frame;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/li")
    private List<WebElement> leftMenu;

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

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li")
    private List<WebElement> itemsInHeader;

    public static final String ID_FRAME = "frame";
    public static final String HOME_PAGE = "Home Page";
    public static final String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(URL_HOME_PAGE);
    }

    public void login(String user, String password)  {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToHomePage() {
        driver.switchTo().defaultContent();
    }

    public String getUserName() {
        return loginName.getText();
    }

    public List<WebElement> getMenuList() {
        return itemsInHeader;
    }

    public List<WebElement> getListOfImages() {
        return listOfImages;
    }

    public List<WebElement> getListOfTextUnderImages() {
        return listOfTextUnderImages;
    }

    public WebElement getFrame() {
        return frame;
    }

    public List<WebElement> getLeftMenu() {
        return leftMenu;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }
}
