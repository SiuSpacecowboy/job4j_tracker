package ru.job4j.encapsulation;

public class Init {

    private  String[] array;

    public Init(String[] array) {
        this.array = array;
    }

    public void init(Input input, Sort sort, Output output, Mass[] arr) {
        boolean begin = true;
        while (begin) {
            showVac(arr);
            int select = input.askInt("Select: ");
            if (select != 0 && select != 1) {
                System.out.println("Неверный ввод, введите пункт выведенный выше");
                continue;
            }
            Mass mass = arr[select];
            boolean run = true;
            while (true) {
                String name = input.askStr("Введите слово: ");
                if (name.equals("exit")) {
                    break;
                } else if (name.equals("sort")) {
                    array = sort.sort(input, array);
                    if (array[0] != null) {
                        output.out(array);
                    }
                } else {
                    array = mass.addWords(name);
                    output.out(array);
                }
            }
            begin = false;
        }
    }

    public void showVac(Mass[] arr) {
        System.out.println("Создать словарь или добавить и продолжать существующий?");
        for (int index = 0; index < arr.length; index++) {
            System.out.println(index + " - " + arr[index].name());
        }
    }

    public static void main(String[] args) {
        String[] array = new String[1];
        Input input = new Input();
        Getter add = new Getter();
        Sort sort = new Sort();
        Output output = new Output();
        Mass[] arr = {
                NewArray.getArr(),
                new AddArray(add, add.getMass())
        };
        new Init(array).init(input, sort, output, arr);
    }
}
