package Q3.TireMonitor;


public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    public Alarm(ISensor sensor) {
    	this._sensor = sensor;
    	alarmOn = false;
    }

    public void check()
    {
        double psiPressureValue = this._sensor.popNextPressurePsiValue();
        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
    
    private ISensor _sensor;
    boolean alarmOn;
}