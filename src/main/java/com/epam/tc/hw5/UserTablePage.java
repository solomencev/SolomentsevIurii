package com.epam.tc.hw5;

import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends BasePage {
    
    public static final String USER_TABLE_TAB = "User Table";
    public static final String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";

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

    @FindBy(xpath = "//tbody//tr[1]//td//select//option")
    public List<WebElement> firstDropdownValues;

    @FindBy(css = "#user-table > tbody > tr")
    private List<WebElement> userTableRows;

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

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

    public List<WebElement> getUserTableRows() {
        return userTableRows;
    }

    public List<WebElement> getLogs() {
        return logs;
    }

    public List<WebElement> getListOfDropdowns() {
        return listOfDropdowns;
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getFirstDropdownValues() {
        return firstDropdownValues;
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
}
