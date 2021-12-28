package ru.job4j.tracker.oop;

public class Error {

    private boolean active;
    private  int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printnfo() {
        System.out.println("Состояние " + active);
        System.out.println("Статус " + status);
        System.out.println("Вывод: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 1, "Access coplited");
        Error error2 = new Error(false, 0, "Access denied");
        error.printnfo();
        error1.printnfo();
        error2.printnfo();
    }
}
