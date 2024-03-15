//package ada.locate.car.controller.impl.client;
//
//import ada.locate.car.app.messages.MessagesClient;
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.core.usecase.ReadAllClients;
//import ada.locate.car.frontend.api.Output;
//import ada.locate.car.infra.dto.ClientDTO;
////import ada.locate.car.service.client.ReadAllClientsService;
//
//import java.util.List;
//
//public class ListAllClientsControllerImpl implements Controller {
//    private final Output showInformation;
//    private final ReadAllClients readAllClientsService;
//
//
//    public ListAllClientsControllerImpl(Output showInformation, ReadAllClients readAllClientsService) {
//        this.showInformation = showInformation;
//        this.readAllClientsService = readAllClientsService;
//    }
//
//    @Override
//    public void execute() {
//        List<ClientDTO> allClients = readAllClientsService.readAll();
//        showInformation.execute(MessagesClient.CLIENT_DETAILS.get(), "All Clients:");
//
//        for (ClientDTO client : allClients) {
//            displayClientDetails(client);
//        }
//    }
//
//    private void displayClientDetails(ClientDTO clientDTO) {
//        System.out.println("Id: " + clientDTO.id());
//        System.out.println("Name: " + clientDTO.name());
//        System.out.println("Address: " + clientDTO.address());
//        System.out.println("Phone Number: " + clientDTO.phoneNumber());
//        System.out.println("Email: " + clientDTO.email());
//        System.out.println("Identification: " + clientDTO.identification());
//        System.out.println();
//    }
//}
