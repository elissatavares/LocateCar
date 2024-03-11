package ada.locate.car.model;

import java.time.LocalDate;

public class Vehicle {
    private String brand;
    private boolean available;
    private String model;
    private LocalDate yearManufacture;
    private String color;
    private String plateNumber;
    private String identificationNumber;

    @Override
    public String toString() {
        return "vehicle{" +
                "brand='" + brand + '\'' +
                ", available=" + available +
                ", model='" + model + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }

    public Vehicle(String brand, LocalDate yearManufacture, String color, String plateNumber, String identificationNumber,String model) {
        this.brand = brand;
        this.available = true;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.color = color;
        this.plateNumber = plateNumber;
        this.identificationNumber = identificationNumber;
    }
}
