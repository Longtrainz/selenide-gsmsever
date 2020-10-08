package com.gsmserver;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {

    static {
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.browser = WebDriverRunner.CHROME;
//        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\geckodriver-v0.27.0-win64\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        WebDriverRunner.setWebDriver(driver);
        Configuration.pollingInterval = 200;
        Configuration.timeout = 4000;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
