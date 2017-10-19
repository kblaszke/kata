package pl.blaszak.kata.letsmakeadeal.strategy;

public class SaveFirstDecision implements SecondChoiceStrategy {

    @Override
    public int choice(int firstChoiceIndex, int zonkDoorIndex) {
        return firstChoiceIndex;
    }
}
