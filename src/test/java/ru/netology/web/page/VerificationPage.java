package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;
import ru.netology.web.data.Helper;

import static com.codeborne.selenide.Selenide.$;


public class VerificationPage {
    @CacheLookup
    private final SelenideElement codeField = $("[data-test-id=code] input");
    @CacheLookup
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public void validVerify(Helper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        new DashboardPage();
    }
}
