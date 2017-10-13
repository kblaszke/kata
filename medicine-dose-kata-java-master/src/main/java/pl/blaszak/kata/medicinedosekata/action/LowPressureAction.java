package pl.blaszak.kata.medicinedosekata.action;

import org.apache.log4j.Logger;
import pl.blaszak.kata.medicinedosekata.model.Medicine;
import pl.blaszak.kata.medicinedosekata.service.AlertService;

public class LowPressureAction extends Action {

    private static final Logger LOGGER = Logger.getLogger(LowPressureAction.class);

    public LowPressureAction(int threshold, AlertService alertService) {
        this(threshold, null, alertService);
        LOGGER.debug("LowPressureAction created for threshold = " + threshold + " and alertService");
    }

    public LowPressureAction(int threshold, Medicine medicine) {
        this(threshold, medicine, null);
        LOGGER.debug("HighPressureAction created for threshold = " + threshold + " and medicine = " + medicine);
    }

    private LowPressureAction(int threshold, Medicine medicine, AlertService alertService) {
        super(bloodPressure -> bloodPressure < threshold, medicine, alertService);
    }
}
