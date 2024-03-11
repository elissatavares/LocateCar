package ada.locate.car.app.messages;

import ada.locate.car.model.Vehicle;

public enum MessagesVehicle {
    ALL_DATA("Brand: \nYear of Manufacture: \nColor: \nPlate Number: "),
    OPTION_VEHICLE("Create\nSearch by board\nDelete\nSearch by model"),
    MENU_VEHICLE("Vehicle menu"),
    ALL_MODELS(Vehicle.getModels()),
    INSERT_DATA("Insert vehicle data"),
    SELECT_MODEL("Select vehicle model"),
    VEHICLE_DETAILS("Vehicle details");

    private final String message;

    MessagesVehicle(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
