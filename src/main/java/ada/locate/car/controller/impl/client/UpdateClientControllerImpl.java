
package ada.locate.car.controller.impl.client;


import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.UpdateClient;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

public class UpdateClientControllerImpl implements Controller {
    private final Input<String> stringOption;
    private final Input<String> inputCPF;
    private final Input<String> inputCNPJ;
    private final Output showInformation;
    private final UpdateClient updateClientService;
    private final Input<String> inputOnlyField;

    public UpdateClientControllerImpl(Input<String> stringOption, Input<String> inputCPF, Input<String> inputCNPJ,  Output showInformation, UpdateClient updateClientService, Input<String> inputOnlyField) {
        this.stringOption = stringOption;
        this.inputCPF = inputCPF;
        this.inputCNPJ = inputCNPJ;
        this.showInformation = showInformation;
        this.updateClientService = updateClientService;
        this.inputOnlyField = inputOnlyField;
    }


    @Override
    public void execute() {
        String type = stringOption.execute(MessagesClient.OPTION_UPDATE.get(), MessagesClient.SEARCH_OPTION_PROMPT.get());

        String document;
        if (type.equalsIgnoreCase("CPF")) {
            document = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());
        } else {
            document = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());
        }

        String edit = stringOption.execute(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.UPDATED_CLIENT_DATA.get());
        System.out.println(edit);
        String updateField = inputOnlyField.execute(MessagesClient.MENU_UPDATED_CLIENT.get(), edit);

        ClientDTO updatedClient = null;
        switch (edit.toLowerCase()) {
            case "name" -> updatedClient = new ClientDTO.Builder()
                    .name(updateField)
                    .document(document)
                    .description(edit)
                    .build();
            case "address" -> updatedClient = new ClientDTO.Builder()
                    .address(updateField)
                    .description(edit)
                    .document(document)
                    .build();
            case "phone number" -> updatedClient = new ClientDTO.Builder()
                    .phoneNumber(updateField)
                    .document(document)
                    .description(edit)
                    .build();
            case "email" -> updatedClient = new ClientDTO.Builder()
                    .email(updateField)
                    .document(document)
                    .description(edit)
                    .build();
        }
        updateClientService.execute(updatedClient);
        showInformation.execute("Client updated successfully.", MessagesClient.CLIENT_DETAILS.get());
    }
}


//package ada.locate.car.controller.impl.client;
//import ada.locate.car.app.messages.MessagesClient;
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.core.usecase.UpdateClient;
//import ada.locate.car.frontend.api.Input;
//import ada.locate.car.frontend.api.Output;
//import ada.locate.car.infra.dto.ClientDTO;
//
//import java.util.List;
//
//public class UpdateClientControllerImpl implements Controller {
//    private final Input<String> inputId;
//    private final Input<String[]> inputMultipleFields;
//    private final Output showInformation;
//    private final Input<String> flagIdentification;
//    private final Input<String> inputCNPJ;
//    private final Input<String> inputCPF;
//    private final UpdateClient updateClientService;
//
//    public UpdateClientControllerImpl(Input<String> inputId, Input<String[]> inputMultipleFields, Output showInformation, Input<String> flagIdentification, Input<String> inputCNPJ, Input<String> inputCPF, UpdateClient updateClientService) {
//        this.inputId = inputId;
//        this.inputMultipleFields = inputMultipleFields;
//        this.showInformation = showInformation;
//        this.flagIdentification = flagIdentification;
//        this.inputCNPJ = inputCNPJ;
//        this.inputCPF = inputCPF;
//        this.updateClientService = updateClientService;
//    }
//
//    @Override
//    public List<ClientDTO> execute() {
//        String clientId = inputId.execute(MessagesClient.ENTER_CLIENT_ID.get(), MessagesClient.ENTER_CLIENT_ID.get());
//        String[] updatedFields = inputMultipleFields.execute(MessagesClient.ENTER_UPDATED_FIELDS.get(), MessagesClient.UPDATED_CLIENT_DATA.get());
//
//        String type = flagIdentification.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.ALL_TYPES.get());
//        String document;
//        if (type.equalsIgnoreCase("CPF")) {
//            document = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());
//        } else {
//            document = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());
//        }
//
//        ClientDTO updatedClientDTO = new ClientDTO.Builder()
//                .name(updatedFields[0])
//                .address(updatedFields[1])
//                .phoneNumber(updatedFields[2])
//                .email(updatedFields[3])
//                .flagIdentification(type)
//                .document(document)
//                .build();
//
//        updateClientService.update(clientId, updatedClientDTO);
//
//        showInformation.execute("Client updated successfully.", MessagesClient.CLIENT_DETAILS.get());
//    return null;
//    }
//
//}
