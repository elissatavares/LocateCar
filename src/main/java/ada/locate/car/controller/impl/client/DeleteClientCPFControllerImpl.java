package ada.locate.car.controller.impl.client;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.DeleteClient;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

public class DeleteClientCPFControllerImpl implements Controller {

    public DeleteClientCPFControllerImpl(Input<String> inputField, Output showInformation, ClientCPF<ClientDTO> deleteClientCPFService) {
        this.inputField = inputField;
        this.showInformation = showInformation;
        this.deleteClientCPFService = deleteClientCPFService;
    }

    private final Input<String> inputField;
    private final Output showInformation;
    private  final DeleteClient<ClientDTO> deleteClientCPFService;


    @Override
    public void execute() {
        String identification = inputField.execute(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.DELETE_CLIENT.get());
        ClientDTO clientDTO = new ClientDTO.Builder().identification(identification).build();
        //deleteClientService.delete(clientDTO);
        showInformation.execute("Identification", identification);
    }
}

