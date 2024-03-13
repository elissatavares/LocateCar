package ada.locate.car.app.messages;

import ada.locate.car.core.model.Vehicle;

public enum MessagesVehicle {
    ALL_DATA("Brand: \nYear of Manufacture: \nColor: \nPlate Number: "),
    OPTION_VEHICLE("Create\nDelete\nSearch by model\n Search by plate\nUpdate"),
    MENU_UPDATE_VEHICLE("Vehicle update menu"),
    DELETE_VEHICLE("Enter the license plate number of the vehicle you want to delete"),
    TITLE_DELETE_VEHICLE("Vehicle delete"),
    UPDATE_VEHICLE("Color\nPlate Number"),
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
