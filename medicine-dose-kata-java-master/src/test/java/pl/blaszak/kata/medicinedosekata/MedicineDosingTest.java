package pl.blaszak.kata.medicinedosekata;

import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.blaszak.kata.medicinedosekata.model.Medicine;
import pl.blaszak.kata.medicinedosekata.service.AlertService;
import pl.blaszak.kata.medicinedosekata.service.DoseController;
import pl.blaszak.kata.medicinedosekata.service.DoseControllerConfig;
import pl.blaszak.kata.medicinedosekata.service.HealthMonitorService;
import pl.blaszak.kata.medicinedosekata.service.MedicinePumpService;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MedicineDosingTest implements WithAssertions {

    @Mock
    private HealthMonitorService healthMonitor;

    @Mock
    private MedicinePumpService medicinePump;

    @Mock
    private AlertService alertService;

    private DoseController doseController;

    @Before
    public void setUp() {
        DoseControllerConfig configService = new DoseControllerConfig(alertService);
        doseController = new DoseController(configService.create(), healthMonitor, medicinePump, alertService);
        given(medicinePump.dose(any())).willReturn(true);
    }

    @Test
    public void shouldApplyOneDoseRaisingMedicineIfPressureIsUnder90AndOver60() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(80);
        // when
        doseController.executeControl();
        // then
        then(medicinePump).should(atLeastOnce()).dose(Medicine.PRESSURE_RAISING_MEDICINE);
    }

    @Test
    public void shouldApply2DosesRaisingMedicineIfPressureIsUnder60ButHigherThan55() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(56);
        // when
        doseController.executeControl();
        // then
        then(medicinePump).should(times(2)).dose(Medicine.PRESSURE_RAISING_MEDICINE);
    }

    @Test
    public void shouldApply3DosesRaisingMedicineIfPressureIsUnder55() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(50);
        // when
        doseController.executeControl();
        // then
        then(medicinePump).should(times(3)).dose(Medicine.PRESSURE_RAISING_MEDICINE);
    }

    @Test
    public void shouldSendAlertIfPressureIsUnder55() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(50);
        // when
        doseController.executeControl();
        // then
        then(alertService).should(times(1)).notifyDoctor();
    }

    @Test
    public void shouldApplyOneDoseLoweringMedicineIfPressureIsOver150() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(160);
        // when
        doseController.executeControl();
        // then
        then(medicinePump).should(times(1)).dose(Medicine.PRESSURE_LOWERING_MEDICINE);
    }

    @Test
    public void shouldNotApplyAnyMedicineIfLastApplicationWasAtLast30Minutes() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(80);
        // when
        doseController.executeControl();
        doseController.executeControl();
        // then
        then(medicinePump).should(atMost(1)).dose(Medicine.PRESSURE_RAISING_MEDICINE);
    }

    @Test
    public void shouldRepeatMedicineActionIfThePompDoesNotWork() throws Exception {
        // given
        given(healthMonitor.getBloodPressure()).willReturn(80);
        given(medicinePump.dose(any())).willReturn(false);
        // when
        doseController.executeControl();
        // then
        verify(medicinePump, times(10)).dose(any());
        verify(alertService, atLeastOnce()).notifyDoctor();
    }
}
