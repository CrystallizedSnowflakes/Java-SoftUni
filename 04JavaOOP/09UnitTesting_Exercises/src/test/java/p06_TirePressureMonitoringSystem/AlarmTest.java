package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void mockSensorAndCreateAlarm(){
        // mock sensor
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor); // alarm on pressure < 17 (alarm off) 21 < pressure alarm on
    }

    // alarm on when pressure < 17
    @Test
    public void testWhenPresserLowerThanLowPressureThreshold_ThenAlarmShouldBeOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.99);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    // alarm on when pressure > 21
    @Test
    public void testWhenPresserGreaterThanHighPressureThreshold_ThenAlarmShouldBeOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.01);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    // alarm off when pressure between 17 - 21
    @Test
    public void testWhenNormalPressure_ThenAlarmShouldBeOff(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.00);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}