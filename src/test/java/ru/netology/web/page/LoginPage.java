package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;
import ru.netology.web.data.Helper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @CacheLookup
    private final SelenideElement loginField = $("[data-test-id=login] input");
    @CacheLookup
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    @CacheLookup
    private final SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(Helper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
