import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            boolean result = signUp("user131231", "pass_213_", "pass_213_");
            System.out.println("Регистрация прошла успешно ");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }

    }

    public static boolean signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логин введен неверно");

            }
            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль введен неверно или не совпадает");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            throw e;
        }

    }

    static class WrongLoginException extends Exception {
        public WrongLoginException() {
            super();
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
            super();
        }

        public WrongPasswordException(String message) {
            super(message);
        }


    }
}
