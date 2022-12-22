package ru.job4j.collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;
    private final Queue<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder build = new StringBuilder();
        int stSize = evenElements.size();
        for (int i = 0; i < stSize; i++) {
            if (i % 2 == 0) {
                build.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return build.toString();
    }

    private String getDescendingElements() {
        StringBuilder build = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            build.append(iterator.next());
        }
        return build.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
