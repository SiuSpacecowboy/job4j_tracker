package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] action = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, action);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output output = new StubOutput();
        Item item = new Item("New item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String id = String.valueOf(item.getId());
        String edited = "Edited name";
        Input in = new StubInput(
                new String[] {"0", id, edited, "1"}
        );
        UserAction[] action = {
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is(edited));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("ForDelete"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                 new String[] {"0", id, "1"}
        );
        UserAction[] action = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, action);
        assertNull(tracker.findById(item.getId()));
    }
}

