package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.swing.api.Input;

public class ClientMenu implements Menu {
    private final Input<Integer> inputOptionInt;
    private final Controller createClientCPF;
    private final Controller createClientCNPJ;

    public ClientMenu(Input<Integer> inputOptionInt, Controller createClientCPF, Controller createClientCNPJ) {
        this.inputOptionInt = inputOptionInt;
        this.createClientCPF = createClientCPF;
        this.createClientCNPJ = createClientCNPJ;
    }

    @Override
    public void run() {
        Integer option = inputOptionInt.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get());
        if (option == null) {
            return;
        }
        switch (option) {
            case 1 -> createClientCPF.execute();
            case 2 -> createClientCNPJ.execute();
        }
    }
}
