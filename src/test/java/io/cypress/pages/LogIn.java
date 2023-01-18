package io.cypress.pages;

import com.codeborne.selenide.SelenideElement;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LogIn {
    private SelenideElement
            buttonLogInByEmail = $(".btn-provider-email"),
            buttonLogInByGitHub = $(".btn-provider-github"),
            buttonLogInBySSO = $(".btn-provider-sso"),
            buttonLogInByGoogle = $(".btn-provider-google"),
            inputEmail = $("input[type=\"email\"]"),
            inputPassword = $("input[type=\"password\"]"),
            submitButton = $("button[type=\"submit\"]");

    public LogIn checkLogInProviderButtonGoogle() {
        step("проверить наличие кнопки провайдера входа Google ", () -> {
            buttonLogInByGoogle.should(exist);
        });
        return this;
    }

    public LogIn checkLogInProviderButtonSSO() {
        step("проверить наличие кнопки провайдера входа SSO ", () -> {
            buttonLogInBySSO.should(exist);
        });
        return this;
    }

    public LogIn checkLogInProviderButtonGitHub() {
        step("проверить наличие кнопки провайдера входа GitHub ", () -> {
            buttonLogInByGitHub.should(exist);
        });
        return this;
    }

    public LogIn checkLogInProviderButtonEmail() {
        step("проверить наличие кнопки провайдера входа Email ", () -> {
            buttonLogInByEmail.should(exist);
        });
        return this;
    }

    public LogIn clickLogInProviderButtonEmail() {
        step("нажать на кнопку провайдера входа Email ", () -> {
            buttonLogInByEmail.click();
        });
        return this;
    }

    public LogIn fillEmailField(String emailText) {
        step("заполнить поле Email ", () -> {
            inputEmail.setValue(emailText);
        });
        return this;
    }

    public LogIn fillPasswordField(String passwordText) {
        step("заполнить поле Password", () -> {
            inputPassword.setValue(passwordText);
        });
        return this;
    }

    public LogIn clickSubmit() {
        step("нажать на кнопку входа ", () -> {
            submitButton.click();
        });
        return this;
    }

}
