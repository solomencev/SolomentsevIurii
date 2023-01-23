package com.epam.pages;

import com.epam.pages.hw4.fragments.HeaderMenu;
import com.epam.pages.utils.WaitActions;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    private HeaderMenu headerMenu;
    WaitActions waitActions;
    //WebDriver driver;
    //WebDriver driver = new ChromeDriver();

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
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        headerMenu = new HeaderMenu(driver);
    }

    /*public void openWebSite(String website) {
        driver.get(website);
    }*/

    public void login(String user, String password)  {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    public String getUserName() {
        return loginName.getText();
    }

    public List<WebElement> getMenuList() {
        return itemsInHeader;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
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
