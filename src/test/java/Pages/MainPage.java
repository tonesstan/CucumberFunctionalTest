package Pages;


import com.codeborne.selenide.ex.ElementNotFound;

import static Elements.MainPage.*;
import static com.codeborne.selenide.Condition.exist;

public class MainPage {

    public static void waitForPageLoad() {try {logo.shouldBe(exist);} catch (ElementNotFound e) {System.out.println("Авторизация провалена.");}}

    public static boolean authorizationCheck() {return logo.exists();}

}