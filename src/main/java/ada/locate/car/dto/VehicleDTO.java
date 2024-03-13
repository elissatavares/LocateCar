package ada.locate.car.dto;

import java.time.LocalDate;

public record VehicleDTO(String brand, LocalDate yearManufacture, String color, String plateNumber, String model) {
    @Override
    public String toString() {
        return "VehicleDTO{" +
                "brand='" + brand + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", color='" + color + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public String brand() {
        return brand;
    }

    @Override
    public LocalDate yearManufacture() {
        return yearManufacture;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public String plateNumber() {
        return plateNumber;
    }

    @Override
    public String model() {
        return model;
    }
}


