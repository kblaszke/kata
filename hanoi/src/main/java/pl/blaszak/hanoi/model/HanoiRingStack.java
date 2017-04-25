package pl.blaszak.hanoi.model;

import pl.blaszak.hanoi.exception.HanoiException;

import java.util.LinkedList;

/**
 * Created by SG0945943 on 2017-04-18.
 */
public class HanoiRingStack {

    private final LinkedList<Ring> context;
    private final String name;

    HanoiRingStack(String name, LinkedList<Ring> context) {
        this.context = context;
        this.name = name;
    }

    public void put(Ring ring) {
        if (!context.isEmpty() && context.peekLast().getDia() < ring.getDia()) {
            throw new HanoiException("Not allowed operation!");
        }
        context.add(ring);
    }

    public Ring get() {
        if (context.isEmpty()) {
            return null;
        }
        return context.pollLast();
    }

    public int getRingsNumber() {
        return context.size();
    }

    public String getName() {
        return name;
    }
}
