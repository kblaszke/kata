package pl.blaszak.kata.letsmakeadeal.service;

import pl.blaszak.kata.letsmakeadeal.model.DoorStatus;
import pl.blaszak.kata.letsmakeadeal.strategy.SecondChoiceStrategy;

import java.util.Random;

class LetsMakeADealPlay {

    private final DealMachineService dealMachineService = new DealMachineService();

    public DoorStatus play(SecondChoiceStrategy strategy) {
        Random gen = new Random();
        int firstChoice = gen.nextInt(DealMachineService.DOOR_COUNT);
        int zonkDoorIndex = dealMachineService.showZonkDoor(firstChoice);
        return dealMachineService.choice(strategy.choice(firstChoice, zonkDoorIndex));
    }
}
