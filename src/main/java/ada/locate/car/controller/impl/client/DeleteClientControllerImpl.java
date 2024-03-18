package ada.locate.car.controller.impl.client;

import ada.locate.car.app.config.client.ClientControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.DTO.ClientDTO;

public class DeleteClientControllerImpl implements Controller {
    private final ClientControllerImplConfig config;

    public DeleteClientControllerImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String type = config.provider().delete().optionDelete();

        String document = config.provider().documentEntry().document(type);
        ClientDTO deleteClientDTO = config.DTO().delete().buildClientDTO(document);
        config.service().delete().execute(deleteClientDTO);
        config.provider().output().deletedSuccessfully(deleteClientDTO.document());
        System.out.println(deleteClientDTO);
    }

}
