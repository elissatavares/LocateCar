package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

public class ClientMenu implements Menu {

    private final Input<String> inputOptionString;

    private final Output showInformation;

    private final Controller createClient;
    private final Controller readAllClients;
    private final Controller updateClient;
    private final Controller deleteClient;

    public ClientMenu(Input<String> inputOptionString, Output showInformation, Controller createClient, Controller readAllClients, Controller updateClient, Controller deleteClient) {
        this.inputOptionString = inputOptionString;
        this.showInformation = showInformation;
        this.createClient = createClient;
        this.readAllClients = readAllClients;
        this.updateClient = updateClient;
        this.deleteClient = deleteClient;
    }


    @Override
    public void run() {
        String option = inputOptionString.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get());

        if (option.isEmpty()) {
            return;
        }

        switch (option.toLowerCase().trim()) {
            case "create" -> createClient.execute();
            case "read" -> readAllClients.execute();
            case "update" -> updateClient.execute();
            case "delete" -> deleteClient.execute();
        }
    }
}

