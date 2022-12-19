package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractChromeTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractChromeTest {
    public SoftAssertions softly = new SoftAssertions();

    /** Assert Browser title. */
    @Test(priority = 1)
    public void exercise2() {
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        /* Perform login. */
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
            driver.findElement(By.id("name")).sendKeys("Roman");
            driver.findElement(By.id("password")).sendKeys("Jdi1234");
            driver.findElement(By.id("login-button")).click();
        } catch (NoSuchElementException e) {
            System.err.println("No element: " + e);
        }

        /* Assert Username is loggined. */
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        /* Open through the header menu Service -> Different Elements Page. */
        driver.findElement(By.cssSelector("ul.m-l8>li>a.dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[text()='Different elements']")).click();
        softly.assertThat(driver.getTitle()).isEqualTo("Different Elements");

        /* Select checkboxes. */
        WebElement checkBoxWater = driver.findElement(By.xpath("//label[text()[contains(., "
                + "' Water')]]/*[@type='checkbox']"));
        WebElement checkBoxWind = driver.findElement(By.xpath("//label[text()[contains(., "
                + "' Wind')]]/*[@type='checkbox']"));
        checkBoxWater.click();
        checkBoxWind.click();
        boolean statusCheckBoxWater = checkBoxWater.isSelected();
        boolean statusCheckBoxWind = checkBoxWind.isSelected();
        softly.assertThat(statusCheckBoxWater).isTrue();
        softly.assertThat(statusCheckBoxWind).isTrue();
        softly.assertAll();

        /* Select radio. */
        WebElement radioButtonSelen = driver.findElement(By.xpath("//label[text()[contains(., "
                + "' Selen')]]/*[@type='radio']"));
        radioButtonSelen.click();
        boolean statusRadioButtonSelen = radioButtonSelen.isSelected();
        softly.assertThat(statusRadioButtonSelen).isTrue();

        /* Select in dropdown. */
        Select dropDownColors = new Select(driver.findElement(By.cssSelector("div.colors>.uui-form-element")));
        dropDownColors.selectByVisibleText("Yellow");
        softly.assertThat(dropDownColors.getFirstSelectedOption().getText()).isEqualTo("Yellow");

        /* Assert that: for each checkbox there is an individual log row and value is corresponded to the status of
         * checkbox; for radio button there is a log row and value is corresponded to the status of radio button; for
         * dropdown there is a log row and value is corresponded to the selected value. */
        softly.assertThat(driver.findElements(By.xpath("//*[contains(text(),'Water: condition "
                + "changed to true')]")).size() != 0).isTrue();
        softly.assertThat(driver.findElements(By.xpath("//*[contains(text(),'Wind: condition "
                + "changed to true')]")).size() != 0).isTrue();
        softly.assertThat(driver.findElements(By.xpath("//*[contains(text(),'Wind: condition changed"
                + " to true')]")).size() != 0).isTrue();
        softly.assertThat(driver.findElements(By.xpath("//*[contains(text(),'Colors: value changed"
                + " to Yellow')]")).size() != 0).isTrue();
        softly.assertAll();
    }
}
