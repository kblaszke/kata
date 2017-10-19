package pl.blaszak.kata.letsmakeadeal.model;

public class Door {

    private final int index;
    private final DoorStatus status;


    public Door(int index, DoorStatus status) {
        this.index = index;
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public DoorStatus getStatus() {
        return status;
    }
}
