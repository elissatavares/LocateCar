package ada.locate.car.controller.impl.client;

import ada.locate.car.app.config.client.ClientControllerImplConfig;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.DTO.ClientDTO;

public class ReadControllerClientImpl implements Controller {
    private final ClientControllerImplConfig config;

    public ReadControllerClientImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String type = config.provider().read().optionsRead();

        String document = config.provider().documentEntry().document(type);

        ClientDTO clientDTO = config.DTO().search().buildClientDTO(document, type);
        ClientDTO readClient = config.service().read().execute(clientDTO);

        config.provider().output().details(readClient.toString());

        System.out.println(readClient);
    }
}
