package io.cypress;

import com.codeborne.selenide.Selenide;
import io.cypress.helpers.Attach;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static io.cypress.config.UserProperties.*;

public class TestBase {

    @BeforeAll
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.baseUrl = "https://www.cypress.io";
        Configuration.browserSize = "1920x1080";
        if (STAND.equals("selenoid")) {
            Configuration.remote = "https://"+SELENOIDUSER+":"+SELENOIDKEY+"@selenoid.autotests.cloud/wd/hub";
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (STAND.equals("selenoid")) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}

