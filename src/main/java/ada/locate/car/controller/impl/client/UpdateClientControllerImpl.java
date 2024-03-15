////package ada.locate.car.controller.impl.client;
////
////import ada.locate.car.app.messages.MessagesClient;
////import ada.locate.car.controller.api.Controller;
////import ada.locate.car.core.usecase.UpdateClient;
////import ada.locate.car.frontend.api.Input;
////import ada.locate.car.frontend.api.Output;
////import ada.locate.car.infra.dto.ClientDTO;
////
////import java.util.List;
////
////public class UpdateClientControllerImpl implements Controller {
////    private final Input<String> inputId;
////    private final Input<String[]> inputMultipleFields;
////    private final Output showInformation;
////    private final UpdateClient updateClientService;
////
////    public UpdateClientControllerImpl(Input<String> inputId, Input<String[]> inputMultipleFields, Output showInformation, UpdateClient updateClientService) {
////        this.inputId = inputId;
////        this.inputMultipleFields = inputMultipleFields;
////        this.showInformation = showInformation;
////        this.updateClientService = updateClientService;
////    }
////
////    @Override
////    public List<ClientDTO> execute() {
////        String clientId = inputId.execute(MessagesClient.ENTER_CLIENT_ID.get(), MessagesClient.ENTER_CLIENT_ID.get());
////        String[] updatedFields = inputMultipleFields.execute(MessagesClient.ENTER_UPDATED_FIELDS.get(), MessagesClient.UPDATED_CLIENT_DATA.get());
////
////        updateClientService.update(clientId, updatedFields);
////
////        showInformation.execute("Client updated successfully.", MessagesClient.CLIENT_DETAILS.get());
////        return null;
////    }
////}
//package ada.locate.car.controller.impl.client;
//
//import ada.locate.car.app.messages.MessagesClient;
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.core.usecase.UpdateClient;
//import ada.locate.car.frontend.api.Input;
//import ada.locate.car.frontend.api.Output;
//
//public class UpdateClientControllerImpl implements Controller {
//    private final Input<String> inputId;
//    private final Input<String[]> inputMultipleFields;
//    private final Output showInformation;
//    private final UpdateClient updateClientService;
//
//    public UpdateClientControllerImpl(Input<String> inputId, Input<String[]> inputMultipleFields, Output showInformation, UpdateClient updateClientService) {
//        this.inputId = inputId;
//        this.inputMultipleFields = inputMultipleFields;
//        this.showInformation = showInformation;
//        this.updateClientService = updateClientService;
//    }
//
//    @Override
//    public void execute() {
//        String clientId = inputId.execute(MessagesClient.ENTER_CLIENT_ID.get(), MessagesClient.ENTER_CLIENT_ID.get());
//
//        String[] updatedFields = inputMultipleFields.execute(MessagesClient.ENTER_UPDATED_FIELDS.get(), MessagesClient.UPDATED_CLIENT_DATA.get());
//
//        updateClientService.update(clientId, updatedFields);
//
//        showInformation.execute("Client updated successfully.", MessagesClient.CLIENT_DETAILS.get());
////    return null;
//    }
//
//}
//
