package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            output.println("Заявка успешно удалена.");
        } else {
            output.println("Ошибка удаления заявки.");
        }
        return true;
    }
}

