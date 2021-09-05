package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;

import static com.codeborne.selenide.Selenide.$;


public class TransferPage {
    @CacheLookup
    private final SelenideElement totField = $(".money-input .input__control");
    @CacheLookup
    private final SelenideElement sourceCardField = $("[data-test-id='from'] .input__control");
    @CacheLookup
    private final SelenideElement addFundsButton = $("[data-test-id='action-transfer'] .button__text");

    public void transaction(String value, String source) {
        totField.doubleClick().append(value);
        sourceCardField.doubleClick().append(source);
        addFundsButton.click();

    }
}
