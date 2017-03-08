/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.horse.validator;

public abstract class Validator<T> {

    protected int[][] board;

    public Validator(int[][] board) {
        this.board = board;
    }

    abstract boolean validate(T t);
}
