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
public class CreateClientCPFControllerImpl implements Controller{
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    public CreateClientCPFControllerImpl(Input<String[]> inputMultipleFields, Output showInformation) {
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
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

        JFrame frame = new JFrame("Create Client CPF");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        CPFInput cpfInput = new CPFInput();
        frame.add(cpfInput);


        cpfInput.getSubmitButton().addActionListener(e -> {
            String[] clientData = inputMultipleFields.execute(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get());
            String cpf = cpfInput.getCpfField().getText();
            ClientCPF clientCPF = new ClientCPF(clientData[0], clientData[1], clientData[2], clientData[3], cpf);
            showInformation.execute(clientCPF.toString(), MessagesClient.CLIENT_DETAILS.get());

            System.out.println(Arrays.toString(clientData));
            System.out.println(cpf);
            System.out.println(clientCPF);


            frame.dispose();
        });


        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
