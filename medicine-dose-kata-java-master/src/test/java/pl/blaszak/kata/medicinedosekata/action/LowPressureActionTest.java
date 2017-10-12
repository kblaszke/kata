package pl.blaszak.kata.medicinedosekata.action;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.blaszak.kata.medicinedosekata.model.Medicine;
import pl.blaszak.kata.medicinedosekata.service.AlertService;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class LowPressureActionTest implements WithAssertions {

    private static final int THRESHOLD = 50;

    @Mock
    private AlertService alertService;

    private Action lowPressureAction;

    @Test
    public void shouldReturnMedicineForBloodPressureLowerThanThresholds() throws Exception {
        // given
        Medicine medicine = Medicine.PRESSURE_RAISING_MEDICINE;
        lowPressureAction = new LowPressureAction(THRESHOLD, medicine);
        // when
        Medicine result = lowPressureAction.run(40);
        // then
        assertThat(result).isNotNull().isEqualTo(medicine);
    }

    @Test
    public void shouldNotReturnAnyMedicineForBloodPressureHigherThanThreshold() throws Exception {
        Medicine medicine = Medicine.PRESSURE_RAISING_MEDICINE;
        lowPressureAction = new LowPressureAction(THRESHOLD, medicine);
        // when
        Medicine result = lowPressureAction.run(60);
        // then
        assertThat(result).isNull();
    }

    @Test
    public void shouldSendAlertForBloodPressureLowerThanThresholds() throws Exception {
        // given
        lowPressureAction = new LowPressureAction(THRESHOLD, alertService);
        // when
        Medicine result = lowPressureAction.run(40);
        // then
        assertThat(result).isNull();
        then(alertService).should(atLeastOnce()).notifyDoctor();
    }

    @Test
    public void shouldNotSendAlertForBloodPressureHigherThanThresholds() throws Exception {
        // given
        lowPressureAction = new LowPressureAction(THRESHOLD, alertService);
        // when
        Medicine result = lowPressureAction.run(60);
        // then
        assertThat(result).isNull();
        then(alertService).should(never()).notifyDoctor();
    }
}