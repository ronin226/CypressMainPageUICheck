package io.cypress;

import io.cypress.helpers.Attach;

import static io.cypress.config.UserProperties.STAND;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class TestBase {

    @BeforeAll
    static void configure() {
//    Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://www.cypress.io/";
        Configuration.browserSize = "1920x1080";
        if (STAND == "selenoid") {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

