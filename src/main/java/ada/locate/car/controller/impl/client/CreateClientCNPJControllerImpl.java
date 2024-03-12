package ada.locate.car.controller.impl.client;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.model.ClientCNPJ;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import ada.locate.car.swing.impl.CNPJInput;

import javax.swing.*;
import java.util.Arrays;

public class CreateClientCNPJControllerImpl implements Controller {
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;
    private final Input<String> inputCNPJ;

    public CreateClientCNPJControllerImpl(Input<String[]> inputMultipleFields, Output showInformation, Input<String> inputCNPJ) {
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
        this.inputCNPJ = inputCNPJ;
    }

    @Override
    public void execute() {
        String cnpj = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        ClientCNPJ clientCNPJ = new ClientCNPJ(clientData[0], clientData[1], clientData[2], clientData[3], cnpj);
        System.out.println("Client data entered: " + Arrays.toString(clientData));
        showInformation.execute(clientCNPJ.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cnpj);
        System.out.println(clientCNPJ);
    }
}
