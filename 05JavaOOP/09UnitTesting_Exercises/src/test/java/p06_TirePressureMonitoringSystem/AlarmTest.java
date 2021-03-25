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
        alarm = new Alarm(sensor);
    }

    @Test
    public void testWhenPresserLowerThanLowPressureThresholdThenAlarmShouldBeOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.5);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testWhenPresserGreaterThanHighPressureThresholdThenAlarmShouldBeOn(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(125.5);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testWhenNormalPressureThenAlarmShouldBeOff(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}