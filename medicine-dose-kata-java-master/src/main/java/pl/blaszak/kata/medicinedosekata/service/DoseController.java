package pl.blaszak.kata.medicinedosekata.service;

import org.apache.log4j.Logger;
import pl.blaszak.kata.medicinedosekata.action.Action;
import pl.blaszak.kata.medicinedosekata.model.Medicine;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

public class DoseController {

    private final Logger LOGGER = Logger.getLogger(DoseController.class);
    private final static int TRY_TIMES = 10;

    private final List<Action> config;
    private final HealthMonitorService healthMonitor;
    private final MedicinePumpService medicinePump;
    private final AlertService alertService;

    private LocalDateTime lastApplicationTime;

    public DoseController(List<Action> config, HealthMonitorService healthMonitor, MedicinePumpService medicinePump, AlertService alertService) {
        LOGGER.debug("Create Dose Controller...");
        this.config = config;
        this.healthMonitor = healthMonitor;
        this.medicinePump = medicinePump;
        this.alertService = alertService;
    }

    public void executeControl() {
        int bloodPressure = healthMonitor.getBloodPressure();
        LOGGER.info("Execute control for blood pressure = " + bloodPressure);
        boolean validApplicationTime = validateLastApplicationTime(LocalDateTime.now());
        config.stream()
                .map(action -> action.run(bloodPressure))
                .filter(Objects::nonNull)
                .filter(medicine -> validApplicationTime)
                .forEach(medicine -> applyMedicine(medicine));
    }

    private void applyMedicine(Medicine medicine) {
        int i = 0;
        boolean result = false;
        do{
            result = medicinePump.dose(medicine);
            i++;
        } while(i < TRY_TIMES && result == false);
        if (result == false) {
            LOGGER.info("Medicine " + medicine + " could NOT be allied");
            alertService.notifyDoctor();
        } else {
            LOGGER.info("Medicine: " + medicine + " applied");
        }

    }

    private boolean validateLastApplicationTime(LocalDateTime now) {
        if (lastApplicationTime == null || ChronoUnit.MINUTES.between(lastApplicationTime, now) > 30) {
            lastApplicationTime = now;
            LOGGER.debug("Medicines can be applied...");
            return true;
        }
        LOGGER.debug("Medicines can NOT be applied...");
        return false;
    }

}
