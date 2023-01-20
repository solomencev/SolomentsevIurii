package com.epam.tc.hw4;

import com.epam.pages.utils.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeImageAttachment("screenshot on failure", screenshot);
        }
    }
}
