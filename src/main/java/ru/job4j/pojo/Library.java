package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Solaris", 322);
        Book book2 = new Book("Great something", 425);
        Book book3 = new Book("Dead souls", 333);
        Book book4 = new Book("Clean code", 120);
        Book[] library = new Book[4];
        library[0] = book1;
        library[1] = book2;
        library[2] = book3;
        library[3] = book4;
        System.out.println("Library:");
        for (int i = 0; i < library.length; i++) {
            System.out.println("Name:" + library[i].getName()
                    + " - " + library[i].getPages());
        }
        Book switchh = new Book("0", 0);
        switchh = library[0];
        library[0] = library[2];
        library[2] = switchh;
        System.out.println("Switch Library:");
        for (int i = 0; i < library.length; i++) {
            System.out.println("Name:" + library[i].getName()
                    + " - " + library[i].getPages());
        }
        System.out.println("Just Clean code");
        for (int i = 0; i < library.length; i++) {
            if (library[i].getName() == "Clean code") {
                System.out.println("Name:" + library[i].getName()
                        + " - " + library[i].getPages());
            }
        }
    }
}

