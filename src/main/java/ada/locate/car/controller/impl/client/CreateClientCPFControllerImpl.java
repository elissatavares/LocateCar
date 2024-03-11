package ada.locate.car.controller.impl.client;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.model.ClientCPF;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import java.util.Arrays;
public class CreateClientCPFControllerImpl implements Controller{
    private final Input<String> inputOptionString;
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    public CreateClientCPFControllerImpl(Input<String> inputOptionString, Input<String[]> inputMultipleFields, Output showInformation) {
        this.inputOptionString = inputOptionString;
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
    }

    @Override
    public void execute() {
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        String cpf = inputOptionString.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.CPF_REGEX.get());
        ClientCPF clientCPF = new ClientCPF(clientData[0], clientData[1], clientData[2], clientData[3], clientData[4]);
        showInformation.execute(clientCPF.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cpf);
        System.out.println(clientCPF);
    }

}
