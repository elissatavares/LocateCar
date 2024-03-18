package ada.locate.car.core.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private String brand;
    private boolean available;
    private String model;
    private LocalDate yearManufacture;
    private String color;
    private String plateNumber;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String toString() {
        return "Vehicle: " +
                "Brand: " + brand +
                ", YearManufacture: " + yearManufacture +
                ", Color: " + color +
                ", PlateNumber: " + plateNumber +
                ", Model: " + model;

    }

    public Vehicle(String brand, String yearManufacture, String color, String plateNumber, String model) {
        this.brand = brand;
        this.available = true;
        this.model = model;
        this.yearManufacture = LocalDate.parse(yearManufacture);
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

    public String getYearManufacture() {
        return yearManufacture.format(formatter);
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

    public void wasRented(){
        this.available = false;
    }
    public void wasReturned(){
        this.available = true;
    }



    public void setModel(String model) {
        this.model = model;
    }



    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
