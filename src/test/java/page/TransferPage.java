package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
public class TransferPage {
    private final SelenideElement amount = $("[data-test-id='amount'].input__control");
    private final SelenideElement fromCard = $("[data-test-id='from'] input");
    private final SelenideElement transferButton = $("[data-test-id='action-deposit']");


    public TransferPage() {
        transferButton.should(Condition.visible);
    }

    public void setAmount() {
        amount.shouldBe(Condition.interactable).setValue("5000");
    }

    public void clickTransferButton() {
        transferButton.click();
    }

    public void setFromCard(String cardNumber) {
        fromCard.shouldBe(Condition.interactable).setValue(cardNumber);
    }
}