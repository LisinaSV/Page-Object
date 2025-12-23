package page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV2 {
    private final SelenideElement loginFinal = $("[data-test-id=login] input");
    private final SelenideElement passwordFinal = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorMessage = $("[data-test-id=error]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginFinal.setValue(info.getLogin());
        passwordFinal.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();

    }
}
