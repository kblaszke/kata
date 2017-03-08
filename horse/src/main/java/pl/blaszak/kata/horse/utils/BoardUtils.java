/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.horse.utils;

import pl.blaszak.kata.horse.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {

    public static List<Coordinates> getAllPossibleJumps(Coordinates point) {
        List<Coordinates> points = new ArrayList<>();
        points.add(new Coordinates(point.row - 2, point.col + 1));
        points.add(new Coordinates(point.row - 1, point.col + 2));
        points.add(new Coordinates(point.row + 1, point.col + 2));
        points.add(new Coordinates(point.row + 2, point.col + 1));
        points.add(new Coordinates(point.row + 2, point.col - 1));
        points.add(new Coordinates(point.row + 1, point.col - 2));
        points.add(new Coordinates(point.row - 1, point.col - 2));
        points.add(new Coordinates(point.row - 2, point.col - 1));
        return points;
    }
}
