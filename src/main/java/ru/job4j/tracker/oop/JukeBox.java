package ru.job4j.tracker.oop;

public class JukeBox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        JukeBox car = new JukeBox();
        int a = 1;
        int b = 2;
        int c = 0;
        int c1 = 12;
        car.music(a);
        car.music(b);
        car.music(c);
        car.music(c1);
    }
}
