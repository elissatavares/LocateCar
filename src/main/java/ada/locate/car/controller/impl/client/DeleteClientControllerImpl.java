package ada.locate.car.controller.impl.client;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.core.usecase.DeleteClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

public class DeleteClientControllerImpl implements Controller {
    private final Input<String> stringOption;
    private final Input<String> inputCPF;
    private final Input<String> inputCNPJ;
    private final Output showInformation;
    private final DeleteClient deleteClientService;

    public DeleteClientControllerImpl(Input<String> stringOption, Input<String> inputCPF, Input<String> inputCNPJ, Output showInformation, DeleteClient deleteClientService) {
        this.stringOption = stringOption;
        this.inputCPF = inputCPF;
        this.inputCNPJ = inputCNPJ;
        this.showInformation = showInformation;
        this.deleteClientService = deleteClientService;
    }


    @Override
    public void execute() {
        String type = stringOption.execute(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.SEARCH_OPTION_PROMPT.get());

        String document;
        if (type.equalsIgnoreCase("CPF")) {
            document = inputCPF.execute(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.ENTER_CPF.get());
        } else {
            document = inputCNPJ.execute(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.ENTER_CNPJ.get());
        }
        ClientDTO deleteClientDTO = new ClientDTO.Builder().document(document).build();
        deleteClientService.execute(deleteClientDTO);
        System.out.println(deleteClientDTO.toString());
    }

}
