package SensorsAndTemperature;

import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {

    List<Sensor> list;
    List<Integer> readings;

    public AverageSensor() {
        this.list = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.list.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : list) {
            if (sensor.isOn()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : list) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : list) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (isOn()) {
            double average = list.stream()
                    .mapToInt(s -> s.read())
                    .average()
                    .getAsDouble();
            this.readings.add((int) average);
            return (int) average;
        }
        throw new IllegalStateException("The sensor is off.");
    }

}
