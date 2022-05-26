package SensorsAndTemperature;

public class StandardSensor implements Sensor{
    int parameter;

    public StandardSensor(int parameter){
        this.parameter = parameter;
    }

    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() {
        return this.parameter;
    }
    
}
