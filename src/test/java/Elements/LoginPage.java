package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    /*
    //https://platform.productstar.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("email", $("#email"));
        put("password", $("#password"));
        put("loginButton", $x("//button[@data-qa='login-btn']"));
        put("registerButton", $("span.register-button"));
        put("forgotPassword", $x("//span[@data-qa='forgot-password-btn']"));
    }};
    */

    //https://auth.rbc.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("email", $$(byName("email")).filter(visible).first());
        put("password", $$(byName("password")).filter(visible).first());
        put("loginButton", $(".paywall__auth__form__submit.js-yandex-counter"));
        put("registerButton", $x("//div[@data-type='regist']"));
        put("forgotPassword", $x("//a[text()='Забыли пароль?']"));
    }};

    public static final SelenideElement email = elements.get("email");
    public static final SelenideElement password = elements.get("password");
    public static final SelenideElement loginButton = elements.get("loginButton");
    public static final SelenideElement registerButton = elements.get("registerButton");
    public static final SelenideElement forgotPassword = elements.get("forgotPassword");

}
