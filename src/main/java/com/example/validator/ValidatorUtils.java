package com.example.validator;


import com.example.validator.Exeption.WrongLoginException;
import com.example.validator.Exeption.WrongPasswordException;

import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final Pattern RESTRICTION = Pattern.compile("\\w{0,20}$");

    public static void toCheckLoginPasswordConfirmPassword(String login, String password, String confirmPassword)
            throws Exception {

        checkLogin(login);
        checkPassword(password);
        checkConfirmPassword(password, confirmPassword);

    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(RESTRICTION.pattern()))
            throw new WrongLoginException("Логин содержит в себе только латинские буквы, цифры и знак подчеркивания," +
                    " логин должен быть равен или меньше 20 символов.");
    }

    private static void checkPassword(String password) throws WrongPasswordException {
        if (!password.matches(RESTRICTION.pattern()))
            throw new WrongPasswordException("Пароль содержит в себе только латинские буквы, цифры и знак подчеркивания," +
                    " пароль должен быть равен или меньше 20 символов.");

    }

    private static void checkConfirmPassword(String password, String confirmPassword) throws Exception {
        if (!password.equals(confirmPassword)) {
            throw new Exception("Пароли не совпадают");
        }
    }
}