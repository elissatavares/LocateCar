package ada.locate.car.app.messages;

public enum MessagesClient {
    ALL_CLIENT_DATA("Name: \nAddress: \nPhone Number: \nEmail:  \nCPF: "),
    ENTER_CPF("Enter CPF"),
    ENTER_CNPJ("Enter CNPJ"),
    CPF_REGEX("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"),
    CNPJ_REGEX("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}"),
    INSERT_CLIENT_DATA("Insert client data"),
    CLIENT_DETAILS("Client details");

    private final String message;

    MessagesClient(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
