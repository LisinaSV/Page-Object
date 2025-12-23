package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeFiled = $("[data-test-id=code] input");
    private final SelenideElement verityButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeFiled.should(Condition.visible);
    }


    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeFiled.setValue(verificationCode.getCode());
        verityButton.click();

        return new DashboardPage();
    }
}
