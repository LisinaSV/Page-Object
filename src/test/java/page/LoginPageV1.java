package page;

import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static java.awt.SystemColor.info;

public class LoginPageV1 {
    public VerificationPage validLogin(DataHelper.AuthInfo info){
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
return new VerificationPage();
    }
}
