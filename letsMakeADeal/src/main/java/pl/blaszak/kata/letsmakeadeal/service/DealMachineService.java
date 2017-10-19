package pl.blaszak.kata.letsmakeadeal.service;

import pl.blaszak.kata.letsmakeadeal.model.Door;
import pl.blaszak.kata.letsmakeadeal.model.DoorStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class DealMachineService {

    public static final int DOOR_COUNT = 3;
    private final List<Door> doors = new ArrayList<>();
    private Integer firstChoice;
    private Integer zonkDoor;

    public DealMachineService() {
        Random gen = new Random();
        int winIndex = gen.nextInt(DOOR_COUNT);
        for (int i = 0; i < DOOR_COUNT; i++) {
            DoorStatus status = i == winIndex ? DoorStatus.WIN : DoorStatus.ZONK;
            doors.add(new Door(i, status));
        }
    }

    public DoorStatus choice(int choice) {
        if (zonkDoor == null || choice == zonkDoor) {
            return null;
        }
        return doors.stream().filter(door -> door.getIndex() == choice).findFirst().get().getStatus();
    }

    public int showZonkDoor(int choice) {
        firstChoice = choice;
        List<Door> rest = doors.stream()
                .filter(door -> door.getIndex() != firstChoice)
                .collect(Collectors.toList());
        zonkDoor = choiceDoor(rest).getIndex();
        return zonkDoor;
    }

    private Door choiceDoor(List<Door> rest) {
        if (rest.get(0).getStatus() == DoorStatus.WIN) {
            return rest.get(1);
        } else if (rest.get(1).getStatus() == DoorStatus.WIN) {
            return rest.get(0);
        }
        Random gen = new Random();
        return rest.get(gen.nextInt(2));
    }


}
