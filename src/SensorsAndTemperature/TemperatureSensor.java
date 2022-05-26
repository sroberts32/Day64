package SensorsAndTemperature;
import java.util.Random;

public class TemperatureSensor implements Sensor{

    boolean sensorOn;
    int parameter;

    public TemperatureSensor() {
        this.sensorOn = false;
    }

    @Override
    public boolean isOn() {
        return this.sensorOn;
    }

    @Override
    public void setOn() {
        this.sensorOn = true;
    }

    @Override
    public void setOff() {
        this.sensorOn = false;
    }

    @Override
    public int read() {
        if (isOn()) {
            this.parameter = new Random().nextInt(61)-60;
            return this.parameter;
        }
        throw new IllegalStateException("The sensor is off.");
    }
    
}
