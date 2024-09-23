package io.cucumber.skeleton;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.*;
import org.junit.platform.suite.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("io.cucumber.skeleton")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.skeleton")

public class RunCucumberTest {

    private static boolean isDriverInitialized = false;

    @Before
    public static void setUp() {
        if (!isDriverInitialized) {
            System.out.println(">> Настройка конфигураций веб-драйвера");
            Configuration.baseUrl = "https://auth.rbc.ru";
            Configuration.browser = "firefox";
            Configuration.browserCapabilities = new FirefoxOptions().setPageLoadStrategy(PageLoadStrategy.EAGER).addArguments("--headless", "--window-size=1920,1080", "--disable-notifications", "--disable-gpu", "--disable-dev-tools", "--fastSetValue");
            Configuration.timeout = 2000;
            isDriverInitialized = true;
            System.out.println(">> Настройка завершена");
        }
    }

    @After
    public static void cleanUp() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        executeJavaScript("window.sessionStorage.clear()");
        System.out.println(">> Веб-драйвер очищен");
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
        System.out.println("\n>> Веб-драйвер закрыт");
    }

}