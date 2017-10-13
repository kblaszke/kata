package pl.blaszak.kata.medicinedosekata.action;

import org.apache.log4j.Logger;
import pl.blaszak.kata.medicinedosekata.model.Medicine;
import pl.blaszak.kata.medicinedosekata.service.AlertService;

import java.util.function.Predicate;

public abstract class Action {

    private static final Logger LOGGER = Logger.getLogger(Action.class);

    private final Predicate<Integer> predicate;
    private final Medicine medicine;
    private final AlertService alertService;

    Action(Predicate<Integer> predicate, Medicine medicine, AlertService alertService) {
        this.predicate = predicate;
        this.medicine = medicine;
        this.alertService = alertService;
    }

    public Medicine run(int bloodPressure) {
        if (predicate.test(bloodPressure)) {
            LOGGER.debug("Medicine " + medicine + " is prepared for application, for bloodPressure = " + bloodPressure);
            if (alertService != null) {
                LOGGER.debug("Notify doctor about blood pressure = " + bloodPressure);
                alertService.notifyDoctor();
            }
            return medicine;
        }
        return null;
    }
}
