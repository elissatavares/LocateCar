package ada.locate.car.app.messages;

import ada.locate.car.core.model.Client;

public enum MessagesClient {
    ALL_CLIENT_DATA("Name:\nAddress:\nPhoneNumber:\nEmail:"),
    ENTER_CPF("Enter CPF"),
    ENTER_CNPJ("Enter CNPJ"),
    INSERT_CLIENT_DATA("Insert client data"),
    CLIENT_DETAILS("Client details"),
    CLIENT_MENU("Client Menu"),
    OPTION_CLIENT("Create\nRead\nUpdate\nDelete\n"),
    ALL_TYPES(Client.getModels()),
    MENU_UPDATED_CLIENT("Client update menu"),
    OPTION_UPDATE("Update with CPF\nUpdate with CNPJ"),
    UPDATE_MENU("Update Menu"),

    OPTION_CREATE("Create with CPF\nCreate with CNPJ"),
    TITLE_DELETE_CLIENT("Client delete"),
    DELETE_CLIENT("Enter the identification number of the client you want to delete"),
    ENTER_CLIENT_ID("Enter client id"),
    ENTER_UPDATED_FIELDS("Enter client data to update"),
    UPDATED_CLIENT_DATA("Name\nAddress\nPhone Number\nEmail"),
    ENTER_SEARCH_OPTION("Read by CPF\nRead by CNPJ"),
    SEARCH_OPTION_PROMPT("CPF\nCNPJ"),
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
