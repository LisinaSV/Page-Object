package test;


import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPageV1;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getAuthInfo;


public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        var info = getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(info);
        open("http://localhost:9999/");

        var loginPage = new LoginPageV1();
        var verificationPage = loginPage.validLogin(info);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCartInfo = DataHelper.getFirstCartInfo();
        var secondCartInfo = DataHelper.getSecondCartInfo();
        var transferPage = dashboardPage.goToTransfer();

        var amount = DataHelper.getTransferAmount();
        transferPage.setAmount();
        transferPage.setFromCard(firstCartInfo.getNumber());
        transferPage.clickTransferButton();
    }
}
