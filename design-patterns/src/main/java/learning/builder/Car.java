package learning.builder;

import lombok.Data;

@Data
public class Car {
    private String engine;
    private String gearbox;
    private String chassis;

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", chassis='" + chassis + '\'' +
                '}';
    }
}
