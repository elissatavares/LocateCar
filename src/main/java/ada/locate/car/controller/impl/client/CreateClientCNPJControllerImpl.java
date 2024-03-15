//package ada.locate.car.controller.impl.client;
//
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.app.messages.MessagesClient;
//import ada.locate.car.core.usecase.CreateClient;
//import ada.locate.car.frontend.api.Input;
//import ada.locate.car.frontend.api.Output;
//import ada.locate.car.infra.dto.ClientDTO;
//
//public class CreateClientCNPJControllerImpl implements Controller {
//    private final Input<String[]> inputMultipleFields;
//    private final Output showInformation;
//    private final Input<String> inputCNPJ;
//    private final CreateClient clientCreateService;
//
//    public CreateClientCNPJControllerImpl(Input<String[]> inputMultipleFields, Output showInformation, Input<String> inputCNPJ, CreateClient clientCreateService) {
//        this.inputMultipleFields = inputMultipleFields;
//        this.showInformation = showInformation;
//        this.inputCNPJ = inputCNPJ;
//        this.clientCreateService = clientCreateService;
//    }
//
//    @Override
//    public void execute() {
//        //recebe se é cpf ou cnpj
//        String type = inputOptionString.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.ALL_TYPES.get());
//        //verifica qual tipo é
//        if(type.equalsIgnoreCase("CPF")){
//            String cpf = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());
//                ClientDTO clientDTO2 = new ClientDTO.Builder().flagIdentification(type).document(cpf).
//
//        } else {
//            String cnpj = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());
//            ClientDTO clientDTO2 = new ClientDTO.Builder().flagIdentification(type).document(cnpj).
//        }
//        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
//        ClientDTO clientDTO = new ClientDTO.Builder()
//                .name(clientData[0])
//                .address(clientData[1])
//                .phoneNumber(clientData[2])
//                .email(clientData[3])
//                .flagIdentification(cnpj)
//                .build();
//
//        clientCreateService.create(clientDTO);
//
//        showInformation.execute("Client created successfully.", MessagesClient.CLIENT_DETAILS.get());
//
//
//        System.out.println("Client Details:");
//        System.out.println("Id: " + clientDTO.id());
//        System.out.println("Name: " + clientDTO.name());
//        System.out.println("Address: " + clientDTO.address());
//        System.out.println("Phone Number: " + clientDTO.phoneNumber());
//        System.out.println("Email: " + clientDTO.email());
//        System.out.println("Identification: " + clientDTO.identification());
//        return null;
//    }
//
//
//}
