//package ada.locate.car.app.menu;
//
//import ada.locate.car.app.messages.MessagesClient;
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.swing.api.Input;
//
//public class ClientMenu implements Menu {
//    private final Input<Integer> inputOptionInt;
//    private final Controller createClientCPF;
//    private final Controller createClientCNPJ;
//
//    private final Controller updatedClientCPF;
//    private final Controller updatedClientCNPJ;
//
//    public ClientMenu(Input<Integer> inputOptionInt, Controller createClientCPF, Controller createClientCNPJ, Controller updatedClientCPF, Controller updatedClientCNPJ) {
//        this.inputOptionInt = inputOptionInt;
//        this.createClientCPF = createClientCPF;
//        this.createClientCNPJ = createClientCNPJ;
//        this.updatedClientCPF = updatedClientCPF;
//        this.updatedClientCNPJ = updatedClientCNPJ;
//    }
//
//    @Override
//    public void run() {
//        Integer option = inputOptionInt.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get());
//        if (option == null) {
//            return;
//        }
//        switch (option) {
//            case 1 -> createClientCPF.execute();
//            case 2 -> createClientCNPJ.execute();
//            case 3 -> updatedClientCPF.execute();
//            case 4 -> updatedClientCNPJ.execute();
//        }
//    }
//}
package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.backup.frontend.api.Input;

public class ClientMenu implements Menu {
    private final Input<String> inputOptionString;

    private final Controller createClientCPF;
    private final Controller updateClientCPF;
    private final Controller createClientCNPJ;
    private final Controller updateClientCNPJ;

    public ClientMenu(Input<String> inputOptionString, Controller createClientControllerCPF, Controller updateClientControllerCPF, Controller createClientControllerCNPJ, Controller updateClientControllerCNPJ) {
        this.inputOptionString = inputOptionString;
        this.createClientCPF = createClientControllerCPF;
        this.updateClientCPF = updateClientControllerCPF;
        this.createClientCNPJ = createClientControllerCNPJ;
        this.updateClientCNPJ = updateClientControllerCNPJ;
    }

    @Override
    public void run() {
        String option = inputOptionString.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get());
        String type = inputOptionString.execute(MessagesClient.CLIENT_MENU.get(), MessagesClient.ALL_TYPES.get());


        if (option.isEmpty() || type.isEmpty()) {
            return;
        }

        switch (option.toLowerCase().trim()) {
            case "create" -> {
                if (type.equalsIgnoreCase("CNPJ")) {
                    createClientCNPJ.execute();
                } else {
                    createClientCPF.execute();
                }
            }
            case "update" -> {
                if (type.equalsIgnoreCase("CNPJ")) {
                    updateClientCNPJ.execute();
                } else {
                    updateClientCPF.execute();
                }
            }
            //case "delete" -> (type.equalsIgnoreCase("CNPJ")) ? deleteCNPJ() : deleteCPF();
        }
    }

//    private void runCreateMenu() {
//        Integer createOption = inputOptionInt.execute(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.OPTION_CLIENT.get());
//        if (createOption == null) {
//            return;
//        }
//
//        switch (createOption) {
//            case 1 -> createClientController.execute();
//            case 2 -> createClientController.execute();
//        }
//    }
//
//    private void runUpdateMenu() {
//        Integer updateOption = inputOptionInt.execute(MessagesClient.UPDATE_MENU.get(), MessagesClient.OPTION_UPDATE.get());
//        if (updateOption == null) {
//            return;
//        }
//
//        switch (updateOption) {
//            case 1 -> updateClientControllerCNPJ.execute();
//            case 2 -> updateClientControllerCNPJ.execute();
//        }
//    }
}
