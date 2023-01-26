package io.cypress.tests;

import io.cypress.TestBase;
import io.cypress.pages.LogInPage;
import io.cypress.pages.MainPage;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.*;
import static io.cypress.config.UserProperties.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageCheck extends TestBase {
    MainPage mainPage = new MainPage();
    LogInPage loginPage = new LogInPage();

    @Test
    @Owner("Kalachev D.")
    @DisplayName("Проверка наличия элементов на главной странице")
    void MainPageElements() {

        mainPage
                .openMainPage()
                .checkButtonNavBar("Product")
                .checkButtonNavBar("Company")
                .checkButtonNavBar("Community")
                .checkButtonNavBar("Pricing")
                .checkButtonNavBar("Docs")
                .checkButtonNPM()
                .checkButtonLogIn()
                .checkButtonInstall();

    }

    @Test
    @Owner("Kalachev D.")
    @DisplayName("Проверка оверлея при вызове кнопки NPM Install")
    void MainPageNPMOverlay() {

        mainPage
                .openMainPage()
                .checkButtonNPM()
                .clickButtonNPM()
                .checkInstallOverlay();

    }

    @Test
    @Owner("Kalachev D.")
    @DisplayName("Проверка логина через UI")
    void MainPagelogInUI() {

        mainPage
                .openMainPage()
                .clickButtonLogIn();

        switchTo().window(1);

        loginPage
                .checkLogInProviderButtonGoogle()
                .checkLogInProviderButtonSSO()
                .checkLogInProviderButtonGitHub()
                .checkLogInProviderButtonEmail()
                .clickLogInProviderButtonEmail()
                .fillEmailField(EMAIL)
                .fillPasswordField(PASSWORD)
                .clickSubmit();
        $(byText(USERNAME)).should(exist);
    }

}
