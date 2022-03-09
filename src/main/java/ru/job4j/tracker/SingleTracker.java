package ru.job4j.tracker;

public class SingleTracker {

    private Tracker tracker = new Tracker();
    private static SingleTracker track = null;

    public static SingleTracker getTrack() {
        if (track == null) {
            track = new SingleTracker();
        }
        return track;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
