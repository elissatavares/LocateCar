package ada.locate.car.app.messages;

import ada.locate.car.model.Vehicle;

public enum MessagesClient {
    ALL_CLIENT_DATA("Name: \nAddress: \nPhone Number: \nEmail: "),
    ENTER_CPF("Enter CPF"),
    ENTER_CNPJ("Enter CNPJ"),
//    CPF_REGEX("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"),
//    CNPJ_REGEX("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}"),
    INSERT_CLIENT_DATA("Insert client data"),
    CLIENT_DETAILS("Client details"),
    CLIENT_MENU("Client Menu"),
    OPTION_CLIENT("Client with CPF\n Client with CNPJ"),

    ALL_MODELS(Vehicle.getModels());

    private final String message;

    MessagesClient(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
