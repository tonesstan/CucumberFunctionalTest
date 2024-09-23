# language: ru
# encoding: utf-8

  Функционал: Авторизация пользователя
    Как зарегистрированный пользователь, чтобы зайти в свой аккаунт, я хочу иметь возможность авторизоваться в системе.

  Сценарий: правильный логин и правильный пароль
    Дано пользователь на странице авторизации
    Когда пользователь вводит правильный логин
    И пользователь вводит правильный пароль
    И пользователь нажимает кнопку входа
    Тогда пользователь попадает на главную страницу

  Сценарий: правильный логин и неправильный пароль
    Дано пользователь на странице авторизации
    Когда пользователь вводит правильный логин
    И пользователь вводит неправильный пароль
    И пользователь нажимает кнопку входа
    Тогда пользователь не попадает на главную страницу

  Сценарий: неправильный логин и правильный пароль
    Дано пользователь на странице авторизации
    Когда пользователь вводит неправильный логин
    И пользователь вводит правильный пароль
    И пользователь нажимает кнопку входа
    Тогда пользователь не попадает на главную страницу