package io.cucumber.skeleton;

import Pages.MainPage;
import Pages.RegisterPage;
import io.cucumber.java.ru.*;

import static Pages.LoginPage.*;
import static Pages.MainPage.authorizationCheck;
import static com.codeborne.selenide.Selenide.*;
import static io.cucumber.skeleton.Utils.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    static String userName = "niragoqa@cyclelove.cc";
    static String password = "f$Q:w&6,Jz6QVgA";

    @Дано("пользователь на странице авторизации")
    public void пользовательНаСтраницеАвторизации() {
        open("/");
        System.out.println(">> Открываем и ждём загрузки страницы авторизации");
        RegisterPage.waitForPageLoad();
        RegisterPage.clickLoginButton();
    }

    @Когда("^пользователь вводит (.*) логин$")
    public void пользовательВводитЛогин(String validity) {
        System.out.println(">> Параметр валидности = '" + validity + "'.");
        String login;
        if (validity.equals("неправильный")) {login = generateRandomEmail();} else {login = userName;}
        enterEmail(login);
        System.out.println(">> Введённый e-mail: " + login);
    }

    @И("^пользователь вводит (.*) пароль$")
    public void пользовательВводитПароль(String validity) {
        System.out.println(">> Параметр валидности = '" + validity + "'.");
        String pass;
        if (validity.equals("неправильный")) {pass = generateRandomPassword();} else {pass = password;}
        enterPassword(pass);
        System.out.println(">> Введённый пароль: " + pass);
    }

    @И("пользователь нажимает кнопку входа")
    public void пользовательНажимаетКнопкуВхода() {
        clickLoginButton();
        System.out.println(">> Кнопка входа нажата");
    }

    @Тогда("^пользователь (.*) на главную страницу$")
    public void пользовательПопадаетНаГлавнуюСтраницу(String expectedResult) {
        boolean valid = expectedResult.equals("попадает");
        String errorEvent = valid ? "неудачная авторизация с верными учётными данными." : "успешная авторизация с неверными учётными данными.";
        MainPage.waitForPageLoad();
        assertEquals(authorizationCheck(), valid, "\n>> Ошибка: " + errorEvent + "\n>> Тест провален.\n");
    }

}