package ada.locate.car.app.messages;

public enum MessagesVehicle {
    ALL_DATA("Brand: \nYear of Manufacture: \nColor: \nPlate Number: \nIdentification Number: "),
    ALL_MODELS("Small\nMedium\nSUV"),
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
