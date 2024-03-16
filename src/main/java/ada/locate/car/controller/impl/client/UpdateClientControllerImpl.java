
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


