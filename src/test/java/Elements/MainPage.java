package Elements;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    /*
    //https://platform.productstar.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("logo", $x("//h4[@data-qa='my-courses__title']"));
    }};
     */

    //https://auth.rbc.ru
    private static final HashMap<String, SelenideElement> elements = new HashMap<>() {{
        put("logo", $("span.topline__logo"));
    }};

    public static final SelenideElement logo = elements.get("logo");
}