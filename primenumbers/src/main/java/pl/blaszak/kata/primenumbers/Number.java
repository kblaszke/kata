/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.primenumbers;

public class Number {

    private int value;
    private boolean canceled;


    public Number(int value) {
        this.value = value;
        this.canceled = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled() {
        this.canceled = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return value == number.value;
    }

    @Override
    public int hashCode() {
        return (value ^ (value >>> 32));
    }
}
