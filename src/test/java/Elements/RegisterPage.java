package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    /*
    //https://platform.productstar.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("email", $("#email"));
        put("password", $("#password"));
        put("confirmPassword", $("#password_confirmation"));
        put("checkBox", $("input#terms"));
        put("loginButton", $("span.register-button"));
        put("registerButton", $x("//button[@data-qa='register-btn']"));
    }};
    */

    //https://auth.rbc.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("email", $$(byName("email")).filter(visible).first());
        put("password", $$(byName("password")).filter(visible).first());
        put("confirmPassword", $(byName("confirm_password")));
        put("checkBox", $("label.paywall__auth__form__checkbox__label"));
        put("loginButton", $x("//div[@data-type='enter']"));
        put("registerButton", $$("input.paywall__auth__form__submit").filter(visible).first());
    }};

    public static final SelenideElement email = elements.get("email");
    public static final SelenideElement password = elements.get("password");
    public static final SelenideElement confirmPassword = elements.get("confirmPassword");
    public static final SelenideElement checkBox = elements.get("checkBox");
    public static final SelenideElement loginButton = elements.get("loginButton");
    public static final SelenideElement registerButton = elements.get("registerButton");
}
