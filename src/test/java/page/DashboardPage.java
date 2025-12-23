package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.impl.Html.text;

public class DashboardPage {
    private final SelenideElement header = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        header.should(Condition.visible);
    }

    public SelenideElement getCard(DataHelper.CartInfo cartInfo) {
        return cards.find(Condition.attribute("data-test-id", cartInfo.getTestId()));
    }
    public int getCardBalance(DataHelper.CartInfo cartInfo){
        var text = getCard(cartInfo).getText();
        return extractBalance(text);
    }
    public TransferPage selectCard (DataHelper.CartInfo cartInfo){
        getCard(cartInfo).$("button").click();
        return new TransferPage();
    }
    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    public TransferPage goToTransfer() {
        // Здесь может быть логика клика по кнопке перевода
        return new TransferPage();
    }

    public void performTransfer(DataHelper.CartInfo firstCartInfo) {
        var transferPage = goToTransfer();
        transferPage.setAmount();
        transferPage.setFromCard(firstCartInfo.getNumber());
        transferPage.clickTransferButton();
    }
}