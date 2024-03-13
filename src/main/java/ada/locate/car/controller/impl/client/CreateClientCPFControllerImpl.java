package ada.locate.car.controller.impl.client;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.core.model.ClientCPF;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.Arrays;

public class CreateClientCPFControllerImpl implements Controller {
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;
    private final Input<String> inputCPF;

    public CreateClientCPFControllerImpl(Input<String[]> inputMultipleFields, Output showInformation, Input<String> inputCPF) {
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
        this.inputCPF = inputCPF;
    }

    @Override
    public void execute() {
        String cpf = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        ClientDTO clientDTO = new ClientDTO.Builder().
                name(clientData[0]).
                address(clientData[1]).
                phoneNumber(clientData[2]).
                email(clientData[3]).
                identification(cpf).build();
        showInformation.execute(clientDTO.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cpf);
        System.out.println(cpf);
    }
}
