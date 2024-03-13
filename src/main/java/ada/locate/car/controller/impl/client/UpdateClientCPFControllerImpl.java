package ada.locate.car.controller.impl.client;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;

import java.util.Arrays;

public class UpdateClientCPFControllerImpl implements Controller {
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    public UpdateClientCPFControllerImpl(Input<String[]> inputMultipleFields, Output showInformation) {
        this.inputMultipleFields = inputMultipleFields;
        this.showInformation = showInformation;
    }

    @Override
    public void execute() {
        String[] data = inputMultipleFields.execute(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.UPDATED_CLIENT.get());

        showInformation.execute("Client updated!", Arrays.toString(data));

        System.out.println(Arrays.toString(data));
    }
}
