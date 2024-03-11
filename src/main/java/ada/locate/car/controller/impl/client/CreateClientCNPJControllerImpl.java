package ada.locate.car.controller.impl.client;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.model.ClientCNPJ;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import ada.locate.car.controller.api.Controller;

import java.util.Arrays;

public class CreateClientCNPJControllerImpl implements Controller {

    private final Input<String> inputOptionString;
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    public CreateClientCNPJControllerImpl(Input<String> inputOptionString, Input<String[]> inputMultipleFields, Output showInformation) {
        this.inputOptionString = inputOptionString;
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
    }
    @Override
    public void execute() {
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        String cnpj = inputOptionString.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.CNPJ_REGEX.get());
        ClientCNPJ clientCNPJ = new ClientCNPJ(clientData[0], clientData[1], clientData[2], clientData[3], cnpj);
        showInformation.execute(clientCNPJ.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cnpj);
        System.out.println(clientCNPJ);
    }
}
