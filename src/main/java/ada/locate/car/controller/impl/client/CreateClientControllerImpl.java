package ada.locate.car.controller.impl.client;

import ada.locate.car.app.config.client.ClientControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.ClientDTO;

public class CreateClientControllerImpl implements Controller {

    private final ClientControllerImplConfig config;

    public CreateClientControllerImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String type = config.provider().create().optionCreate();
        String document = config.provider().documentEntry().document(type);
        String[] clientData = config.provider().create().dataClient();
        ClientDTO clientDTO = config.DTO().create().buildClientDTO(type, clientData, document);
        config.service().create().execute(clientDTO);
        config.provider().output().createdSuccessfully(clientDTO.toString());

        System.out.println("SUCCESS! Enter Read option to see details.");
    }
}
