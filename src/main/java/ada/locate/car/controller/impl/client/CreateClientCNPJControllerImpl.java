package ada.locate.car.controller.impl.client;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.core.model.Client;
import ada.locate.car.core.model.ClientCNPJ;
import ada.locate.car.core.usecase.CreateClient;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.Arrays;

public class CreateClientCNPJControllerImpl implements Controller {
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;
    private final Input<String> inputCNPJ;

    private final CreateClient clientCreateService;

    public CreateClientCNPJControllerImpl(Input<String[]> inputMultipleFields, Output showInformation, Input<String> inputCNPJ, CreateClient clientCreateService) {
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
        this.inputCNPJ = inputCNPJ;
        this.clientCreateService = clientCreateService;
    }

    @Override
    public void execute() {
        String cnpj = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        ClientDTO clientDTO = new ClientDTO.Builder().
                name(clientData[0]).
                address(clientData[1]).
                phoneNumber(clientData[2]).
                email(clientData[3]).
                identification(cnpj).build();

        System.out.println("Client data entered: " + Arrays.toString(clientData));
        showInformation.execute(clientDTO.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cnpj);
        System.out.println(clientDTO);
    }
}
