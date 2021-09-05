package ru.netology.web.test;

import org.junit.jupiter.api.*;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.web.data.Helper.*;
import static ru.netology.web.page.DashboardPage.cardsBalance;


public class MoneyTransferTest {
    int[] cardsBalance;
    int transferAmount = transferAmount(1, 1000);

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
        new LoginPage().validLogin(getAuthInfo()).validVerify(getVerificationCodeFor(getAuthInfo()));
        cardsBalance = cardsBalance();

    }

    @DisplayName("must transfer from the first card to the second")
    @RepeatedTest(3)
    void mustTransferFromTheFirstCardToTheSecond() {
        int expectedFirst = cardsBalance[0] + transferAmount;
        int expectedSecond = cardsBalance[1] - transferAmount;
        var dashboard = new DashboardPage();
        dashboard.moneyTransfer(cards[0]).transaction(Integer.toString(transferAmount), cards[1]);
        cardsBalance = cardsBalance();

        assertEquals(expectedFirst, cardsBalance[0]);
        assertEquals(expectedSecond, cardsBalance[1]);

    }

    @DisplayName("must transfer from the second card to the first")
    @RepeatedTest(3)
    void mustTransferFromTheSecondCardToTheFirst() {
        int expectedFirst = cardsBalance[0] - transferAmount;
        int expectedSecond = cardsBalance[1] + transferAmount;
        var dashboard = new DashboardPage();
        dashboard.moneyTransfer(cards[1]).transaction(Integer.toString(transferAmount), cards[0]);
        cardsBalance = cardsBalance();

        assertEquals(expectedFirst, cardsBalance[0]);
        assertEquals(expectedSecond, cardsBalance[1]);
    }
}
