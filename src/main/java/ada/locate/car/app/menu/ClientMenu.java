package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.List;

public class ClientMenu implements Menu {

//    private final Controller updateClientCNPJ;

//    public ClientMenu(Input<String> inputOptionString, Controller createClientControllerCPF, Controller updateClientControllerCPF, Controller createClientControllerCNPJ, Controller updateClientControllerCNPJ) {
//        this.inputOptionString = inputOptionString;
//        this.createClientCPF = createClientControllerCPF;
//        this.updateClientCPF = updateClientControllerCPF;
//        this.createClientCNPJ = createClientControllerCNPJ;
//        this.updateClientCNPJ = updateClientControllerCNPJ;
//    }
private final Input<String> inputOptionString;

    private final Output showInformation;

    private final Controller createClient;
//    private final Controller readAllClients;
//    private final Controller updateClient;
    public ClientMenu(Input<String> inputOptionString, Output showInformation, Controller createClient /*,Controller readAllClients, Controller updateClient*/) {
        this.inputOptionString = inputOptionString;
        this.showInformation = showInformation;
        this.createClient = createClient;
//        this.readAllClients = readAllClients;
//        this.updateClient = updateClient;
    }

    @Override
    public void run() {
        String option = inputOptionString.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get());

        if (option.isEmpty() ) {
            return;
        }

        switch (option.toLowerCase().trim()) {
            case "create" -> {
                createClient.execute();
            }
//            case "read" -> {
//                List<ClientDTO> clients = readAllClients.execute();
//                if (clients.isEmpty()) {
//                    showInformation.execute("No clients found.", "Client Details");
//                } else {
//                    StringBuilder message = new StringBuilder();
//                    for (ClientDTO client : clients) {
//                        message.append("Id:").append(client.id()).append("\n")
//                                .append("Name: ").append(client.name()).append("\n")
//                                .append("Address: ").append(client.address()).append("\n")
//                                .append("Phone Number: ").append(client.phoneNumber()).append("\n")
//                                .append("Email: ").append(client.email()).append("\n")
//                                .append("Identification: ").append(client.identification()).append("\n\n");
//                    }
//                    showInformation.execute(message.toString(), "Client Details");
//                }
            }



//            case "update" -> updateClient.execute();
            //case "delete" -> (type.equalsIgnoreCase("CNPJ")) ? deleteCNPJ() : deleteCPF();
        }
    }

