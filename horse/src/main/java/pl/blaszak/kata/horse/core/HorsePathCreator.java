package pl.blaszak.kata.horse.core;

import pl.blaszak.kata.horse.Coordinates;
import pl.blaszak.kata.horse.utils.BoardUtils;
import pl.blaszak.kata.horse.validator.PointValidator;

import java.util.List;
import java.util.stream.Collectors;

/* Copyright 2017 Sabre Holdings */
public class HorsePathCreator {

    private int[][] board;
    private int endStepNumber;

    public HorsePathCreator(Coordinates boardRange) {
        board = new int[boardRange.row][boardRange.col];
        endStepNumber = boardRange.row * boardRange.col;
    }

    public int[][] findPath(Coordinates startPoint) {
        if (findPath(startPoint, 0)) {
            return board;
        } else {
            return null;
        }
    }

    private boolean findPath(Coordinates point, int step) {
        step ++;
        if (step == endStepNumber) {
            board[point.row][point.col] = step;
            return true;
        }
        List<Coordinates> possibleJumps = getPossibleJumps(point);
        if (possibleJumps.size() > 0) {
            for (Coordinates nextPoint : possibleJumps) {
                board[point.row][point.col] = step;
                Boolean pathToEnd = findPath(nextPoint, step);
                if (pathToEnd) {
                    return true;
                } else {
                    board[point.row][point.col] = 0;
                }
            }
        }
        return false;
    }

    private List<Coordinates> getPossibleJumps(Coordinates point) {
        List<Coordinates> allPossibilities = BoardUtils.getAllPossibleJumps(point);
        return allPossibilities.stream()
                .filter(jump -> {
                    PointValidator validator = PointValidator.getInstance(board);
                    return validator.validate(jump);
                })
                .collect(Collectors.toList());
    }
}
