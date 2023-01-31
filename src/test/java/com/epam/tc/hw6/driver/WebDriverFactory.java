package com.epam.tc.hw6.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.management.openmbean.InvalidOpenTypeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    private static final String REMOTE_DRIVER_TYPE = "remote";
    private static final String LOCAL_DRIVER_TYPE = "local";

    public static WebDriver createWebDriver(final String driverType, final String browserName) {
        if (REMOTE_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createRemoteWebDriver(browserName);
        } else if (LOCAL_DRIVER_TYPE.equalsIgnoreCase(driverType)) {
            return createLocalDriver(browserName);
        } else {
            throw new WebDriverTypeException(String.format("unsupported driver type: %s", driverType));
        }
    }

    /*Local Web Driver creation*/
    private static WebDriver createLocalDriver(final String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Unsupported browser: %s", browserName));
        }
        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /*Remote Web Driver creation*/
    private static WebDriver createRemoteWebDriver(final String browserName) {
        Capabilities capabilities = null;
        if (CHROME.equalsIgnoreCase(browserName)) {
            capabilities = createRemoteChromeCapabilities();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            capabilities = createRemoteFireFoxCapabilities();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser: %s", browserName));
        }
        try {
            return new RemoteWebDriver(new URL("http://192.168.100.15:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException("Incorrect selenium grid URL");
        }
    }

    private static Capabilities createRemoteChromeCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createRemoteFireFoxCapabilities() {
        return new ChromeOptions();
    }
}
