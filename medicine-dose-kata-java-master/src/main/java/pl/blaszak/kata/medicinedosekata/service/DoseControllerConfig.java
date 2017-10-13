package pl.blaszak.kata.medicinedosekata.service;

import org.apache.log4j.Logger;
import pl.blaszak.kata.medicinedosekata.action.Action;
import pl.blaszak.kata.medicinedosekata.action.HighPressureAction;
import pl.blaszak.kata.medicinedosekata.action.LowPressureAction;
import pl.blaszak.kata.medicinedosekata.model.Medicine;

import java.util.Arrays;
import java.util.List;

public class DoseControllerConfig {

    private static final Logger LOGGER = Logger.getLogger(DoseControllerConfig.class);

    private final AlertService alertService;

    public DoseControllerConfig(AlertService alertService) {
        LOGGER.debug("Create DoseControllerConfig...");
        this.alertService = alertService;
    }

    public List<Action> create() {
        LOGGER.debug("Create create configuration...");
        return Arrays.asList(
                new LowPressureAction(90, Medicine.PRESSURE_RAISING_MEDICINE),
                new LowPressureAction(60, Medicine.PRESSURE_RAISING_MEDICINE),
                new LowPressureAction(55, Medicine.PRESSURE_RAISING_MEDICINE),
                new LowPressureAction(55, alertService),
                new HighPressureAction(150, Medicine.PRESSURE_LOWERING_MEDICINE)
        );
    }
}
