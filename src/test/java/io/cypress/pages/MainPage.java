package io.cypress.pages;

import com.codeborne.selenide.SelenideElement;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement
            buttonInstall = $("[type=\"button\"][data-cy=\"install\"]"),
            buttonLogIn = $$("a").find(exactText(" Log In ")),
            buttonNPM = $$("[type=\"button\"]").find(text("npm install cypress")),
            installOverlay = $(".pointer-events-auto.relative.flex");

    private final static String TITLE_TEXT = "With Cypress, you can easily create tests for your modern web applications, debug them visually, and automatically run them in your continous integration builds.";
    private final static String NPM_TITLE_TEXT = "Installing Cypress";
    private final static String NPM_TEXT = "Click to copy the command below to paste into your terminal:";
    private final static String DD_TEXT = "Download the Cypress application directly to give it a try:";

    public MainPage openMainPage() {
        step("открыть главную страницу", () -> {
            open("/");
            $(byText(TITLE_TEXT)).should(exist);
        });
        return this;
    }

    public MainPage checkButtonNavBar(String buttonText) {
        step("проверить наличие в навбаре кнопки с текстом " + buttonText, () -> {
            $$(".nav-bar-link").find(text(buttonText)).should(exist);
        });
        return this;
    }

    public MainPage checkButtonInstall() {
        step("проверить наличие кнопки Install ", () -> {
            buttonInstall.should(exist);
        });
        return this;
    }

    public MainPage checkButtonLogIn() {
        step("проверить наличие кнопки LogIn ", () -> {
            buttonLogIn.should(exist);
        });
        return this;
    }

    public MainPage checkButtonNPM() {
        step("проверить наличие кнопки NPM ", () -> {
            buttonNPM.should(exist);
        });
        return this;
    }

    public MainPage checkInstallOverlay() {
        step("проверить наличие кнопки NPM ", () -> {
            installOverlay.should(exist);
            $(byText(NPM_TITLE_TEXT)).should(exist);
            $(byText(NPM_TEXT)).should(exist);
            $(byText(DD_TEXT)).should(exist);
        });
        return this;
    }

    public MainPage clickButtonNPM() {
        step("кликнуть кнопку NPM ", () -> {
            buttonNPM.click();
        });
        return this;
    }

    public MainPage clickButtonLogIn() {
        step("кликнуть кнопку  LogIn ", () -> {
            buttonLogIn.click();
        });
        return this;
    }
}
