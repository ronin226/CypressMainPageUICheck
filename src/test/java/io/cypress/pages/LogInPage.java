package io.cypress.pages;

import com.codeborne.selenide.SelenideElement;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LogInPage {
    private SelenideElement
            buttonLogInByEmail = $(".btn-provider-email"),
            buttonLogInByGitHub = $(".btn-provider-github"),
            buttonLogInBySSO = $(".btn-provider-sso"),
            buttonLogInByGoogle = $(".btn-provider-google"),
            inputEmail = $("input[type=\"email\"]"),
            inputPassword = $("input[type=\"password\"]"),
            submitButton = $("button[type=\"submit\"]");

    public LogInPage checkLogInProviderButtonGoogle() {
        step("проверить наличие кнопки провайдера входа Google ", () -> {
            buttonLogInByGoogle.should(exist);
        });
        return this;
    }

    public LogInPage checkLogInProviderButtonSSO() {
        step("проверить наличие кнопки провайдера входа SSO ", () -> {
            buttonLogInBySSO.should(exist);
        });
        return this;
    }

    public LogInPage checkLogInProviderButtonGitHub() {
        step("проверить наличие кнопки провайдера входа GitHub ", () -> {
            buttonLogInByGitHub.should(exist);
        });
        return this;
    }

    public LogInPage checkLogInProviderButtonEmail() {
        step("проверить наличие кнопки провайдера входа Email ", () -> {
            buttonLogInByEmail.should(exist);
        });
        return this;
    }

    public LogInPage clickLogInProviderButtonEmail() {
        step("нажать на кнопку провайдера входа Email ", () -> {
            buttonLogInByEmail.click();
        });
        return this;
    }

    public LogInPage fillEmailField(String emailText) {
        step("заполнить поле Email ", () -> {
            inputEmail.setValue(emailText);
        });
        return this;
    }

    public LogInPage fillPasswordField(String passwordText) {
        step("заполнить поле Password", () -> {
            inputPassword.setValue(passwordText);
        });
        return this;
    }

    public LogInPage clickSubmit() {
        step("нажать на кнопку входа ", () -> {
            submitButton.click();
        });
        return this;
    }

}
