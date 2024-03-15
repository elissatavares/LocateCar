package ada.locate.car.app.messages;

import ada.locate.car.core.model.Client;

public enum MessagesClient {
    ALL_CLIENT_DATA("Name: \nAddress: \nPhone Number: \nEmail: "),
    ENTER_CPF("Enter CPF"),
    ENTER_CNPJ("Enter CNPJ"),
//    CPF_REGEX("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"),
//    CNPJ_REGEX("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}"),
    INSERT_CLIENT_DATA("Insert client data"),
    CLIENT_DETAILS("Client details"),
    CLIENT_MENU("Client Menu"),
    OPTION_CLIENT("Create\nRead\nUpdate\nDelete\nSearch\n"),

    ALL_TYPES(Client.getModels()),
    MENU_UPDATED_CLIENT("Client execute menu"),
    UPDATED_CLIENT("Nome\nEndereço\nTelefone\nEmail\n"),
    OPTION_UPDATE("Update with CPF\n Update with CNPJ"),
    UPDATE_MENU("Update Menu"),

    OPTION_CREATE("Create with CPF\nCreate with CNPJ"),
    TITLE_DELETE_CLIENT("Client execute"),
    DELETE_CLIENT("Enter the identification number of the client you want to execute");


    private final String message;

    MessagesClient(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
