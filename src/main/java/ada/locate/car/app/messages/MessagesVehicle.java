package ada.locate.car.app.messages;

import ada.locate.car.core.model.Vehicle;

public enum MessagesVehicle {
    OPTION_VEHICLE("Create\nDelete\nRead\nUpdate"),
    OPTION_READ("Search by model\nSearch by plate\nSearch by color\nSearch all"),
    OPTION_UPDATE_VEHICLE("Color\nPlate Number\nPlate Color and Number"),
    OPTION_UPDATE_PLATE_COLOR("Color\nPlateNumber"),
    OPTION_ALL_MODELS(Vehicle.getModels()),


    MENU_UPDATE_VEHICLE("Vehicle update menu"),
    MENU_READ_VEHICLE("Choose the type of search"),
    MENU_DELETE_VEHICLE("Vehicle execute"),
    MENU_SELECT_MODEL("Select vehicle model"),
    MENU_INSERT_FILTER("Insert the filter"),
    MENU_VEHICLE("Vehicle menu"),

    DESCRIPTION_UPDATE_COLOR_VEHICLE("Enter new vehicle color"),
    DESCRIPTION_UPDATE_PLATE_VEHICLE("Enter new vehicle plate"),
    DESCRIPTION_DELETE_VEHICLE("Enter the license plate number of the vehicle you want to update"),
    DESCRIPTION_INSERT_DATA("Insert vehicle data"),
    DESCRIPTION_ENTER_PLATE("Enter the license plate number you want to search for"),
    DESCRIPTION_ALL_DATA("Brand: \nYear of Manufacture: \nColor: \nPlate Number: "),
    DESCRIPTION_ENTER_COLOR("Enter the color of the car you want to search for"),
    RESULTS_SEARCH_FILTER("These are the results based on the search filter"),
    VEHICLE_DETAILS("Vehicle details");


    private final String message;

    MessagesVehicle(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
