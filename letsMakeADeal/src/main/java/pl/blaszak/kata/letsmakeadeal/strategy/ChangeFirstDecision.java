package pl.blaszak.kata.letsmakeadeal.strategy;

import java.util.Arrays;
import java.util.List;

public class ChangeFirstDecision implements SecondChoiceStrategy {
    @Override
    public int choice(int firstChoiceIndex, int zonkDoorIndex) {
        List<Integer> decisions = Arrays.asList(0, 1, 2);
        return decisions.stream().filter(decision -> decision != firstChoiceIndex && decision != zonkDoorIndex).findFirst().get();
    }
}
