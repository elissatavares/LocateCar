package ada.locate.car.app.messages;

import ada.locate.car.core.model.Client;

public enum MessagesClient {
    ALL_CLIENT_DATA("Name:\nAddress:\nPhone Number:\nEmail:"),
    ENTER_CPF("Enter CPF"),
    ENTER_CNPJ("Enter CNPJ"),
    INSERT_CLIENT_DATA("Insert client data"),
    CLIENT_DETAILS("Client details"),
    CLIENT_MENU("Client Menu"),
    CREATE_CLIENT("Create client"),
    OPTION_CLIENT("Create\nRead\nUpdate\nDelete\n"),
    ALL_TYPES(Client.getModels()),
    MENU_UPDATED_CLIENT("Client update menu"),
    TITLE_DELETE_CLIENT("Client delete"),
    UPDATED_CLIENT_DATA("Name\nAddress\nPhone Number\nEmail"),
    ENTER_SEARCH_OPTION("Read by CPF\nRead by CNPJ"),
    SEARCH_OPTION_PROMPT("CPF\nCNPJ"),

    CREATE_SUCESS_MSG("Client created successfully!"),
    DELETE_SUCESS_MSG("Client deleted successfully!"),
    UPDATE_SUCESS_MSG("Client updated successfully!");

    private final String message;

    MessagesClient(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
