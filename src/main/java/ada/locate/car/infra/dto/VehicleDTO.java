package ada.locate.car.infra.dto;

import ada.locate.car.core.model.Vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record VehicleDTO(String brand, LocalDate yearManufacture,
                         String color, String plateNumber,
                         String model, String description, String newPlateNumber) {

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


    @Override
    public String toString() {
        return "Vehicle: " +
                "Brand: " + brand +
                ", YearManufacture: " + yearManufacture +
                ", Colo: " + color +
                ", PlateNumber: " + plateNumber +
                ", Model: " + model;
    }

    public static class Builder {
        private String brand;
        private LocalDate yearManufacture;
        private String color;
        private String plateNumber;
        private String model;
        private String newPlateNumber;
        private String description;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder yearManufacture(LocalDate yearManufacture) {
            this.yearManufacture = yearManufacture;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder plateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder newPlateNumber(String newPlateNumber) {
            this.newPlateNumber = newPlateNumber;
            return this;
        }

        public VehicleDTO build() {
            return new VehicleDTO(brand, yearManufacture, color, plateNumber, model, description, newPlateNumber);
        }
    }
    public static List<VehicleDTO> convertToVehicleDTO(List<Vehicle> vehicleList){
        return vehicleList.stream()
                .map(vehicle -> new Builder().
                        brand(vehicle.getBrand()).
                        yearManufacture(vehicle.getYearManufacture()).
                        color(vehicle.getColor()).
                        plateNumber(vehicle.getPlateNumber()).
                        model(vehicle.getModel()).
                        build()).
                collect(Collectors.toList());
    }
    public static String formatVehicleList(List<VehicleDTO> vehicles) {
        return vehicles.stream()
                .map(vehicle -> "Vehicle: " +
                        "Brand: " + vehicle.brand() +
                        ", YearManufacture: " + vehicle.yearManufacture() +
                        ", Color: " + vehicle.color() +
                        ", PlateNumber: " + vehicle.plateNumber() +
                        ", Model: " + vehicle.model())
                .collect(Collectors.joining("\n"));
    }
}
