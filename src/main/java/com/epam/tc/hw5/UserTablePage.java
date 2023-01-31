package com.epam.tc.hw5;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {
    
    public static final String USER_TABLE_TAB = "User Table";
    @FindBy(xpath = "//tbody//select")
    public List<WebElement> listOfDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> listOfUsernames;

    @FindBy(xpath = "//tbody//span")
    public List<WebElement> listOfDescriptionsUnderImages;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css = "tbody > tr")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> listOfDescriptionText;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberOfItemInTable;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getBrowserTitleName() {
        return driver.getTitle();
    }

    public List<WebElement> getUsers() {
        return listOfUsernames;
    }

    public List<WebElement> getDescriptions() {
        return listOfDescriptionsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<String> getNumberFromTable() {
        return numberOfItemInTable.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());
    }

    public List<String> getUserFromTable() {
        return listOfUsernames.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
    }

    public List<String> getDescriptionFromTable() {
        return listOfDescriptionText.stream()
                               .map(WebElement::getText)
                               .map(n -> n.replaceAll("\\s", " "))
                               .collect(Collectors.toList());
    }

    public List<String> getDroplistValues(String userName) {
        List<WebElement> dropdownValues = driver
            .findElements(By.xpath(".//a[contains(text(),'" + userName + "')]/ancestor::tr//option"));
        return dropdownValues.stream()
                             .map(WebElement::getText)
                             .collect(Collectors.toList());
    }

    public void selectVipCheckbox(String userName) {
        driver.findElement(By.xpath(".//*[contains(text(),'" + userName + "')]/../..//input"))
              .click();
    }

    public boolean logsAfterSelectingVipCheckbox(String logText) {
        By logPath = new By.ByXPath("//li[contains(. ,'" + logText + "')]");
        WebElement log = driver.findElement(logPath);
        return log.isDisplayed();
    }
}
