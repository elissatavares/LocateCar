package ada.locate.car.app.messages;

public enum MessagesApp {
    MAIN_OPTIONS_MENU("Client \nVehicle \nLocation Vehicle"),
    MAIN_MENU("Principal menu");

    private final String message;

    MessagesApp(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
