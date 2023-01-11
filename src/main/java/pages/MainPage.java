package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class MainPage {

    @FindBy(className = "benefit-icon")
    public List<WebElement> listOfImages;

    @FindBy(className = "benefit-txt")
    public List<WebElement> listOfTextUnderImages;

    @FindBy(id = "frame")
    public WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/li")
    public List<WebElement> leftMenu;

    private HeaderMenu headerMenu;

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

    public static  String ID_FRAME = "frame";
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String HOME_PAGE = "Home Page";


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public void login(String user, String password)  {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    public String userLogged() {

        return loginName.getText();
    }

    public List<WebElement> menuList() {
        return itemsInHeader;
    }

    public HeaderMenu headerMenu() {
        return headerMenu;
    }

    WaitActions waitActions;
}
