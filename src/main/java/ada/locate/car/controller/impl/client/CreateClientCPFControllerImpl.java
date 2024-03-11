package ada.locate.car.controller.impl.client;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.model.ClientCPF;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import ada.locate.car.swing.impl.CPFInput;

import javax.swing.*;
import java.awt.*;
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

//    @Override
//    public void execute() {
//        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
////        String cpf = Arrays.toString(inputMultipleFields.execute(MessagesClient.ENTER_CPF.get(),));
//        ClientCPF clientCPF = new ClientCPF(clientData[0], clientData[1], clientData[2], clientData[3], clientData[4]);
//        showInformation.execute(clientCPF.toString(), MessagesClient.CLIENT_DETAILS.get());
//
//        System.out.println(Arrays.toString(clientData));
//        System.out.println(clientData[4]);
//        System.out.println(clientCPF);
//    }

    @Override
    public void execute() {
        String cpf = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());
        String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
        ClientCPF clientCPF = new ClientCPF(clientData[0], clientData[1], clientData[2], clientData[3], cpf);
        showInformation.execute(clientCPF.toString(), MessagesClient.CLIENT_DETAILS.get());

        System.out.println(Arrays.toString(clientData));
        System.out.println(cpf);
        System.out.println(clientCPF);
    }
}
