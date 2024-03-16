package ada.locate.car.core.model;

import java.time.LocalDate;

public class Vehicle {
    private String brand;
    private boolean available;
    private String model;
    private LocalDate yearManufacture;
    private String color;
    private String plateNumber;

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

    public Vehicle(String brand, LocalDate yearManufacture, String color, String plateNumber, String model) {
        this.brand = brand;
        this.available = true;
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.color = color;
        this.plateNumber = plateNumber;
    }


    private enum Model {
        SMALL("Small"),
        MEDIUM("Medium"),
        SUV("SUV");

        private String description;

        Model(String description) {
            this.description = description;
        }

        public String get() {
            return description;
        }

        private static String allModels() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Model model : Model.values()) {
                stringBuilder.append(model.description).append("\n");
            }
            return stringBuilder.toString();
        }

    }

    public static String getModels(){
        return Model.allModels();
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    public LocalDate getYearManufacture() {
        return yearManufacture;
    }

    public String getColor() {
        return color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearManufacture(LocalDate yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
