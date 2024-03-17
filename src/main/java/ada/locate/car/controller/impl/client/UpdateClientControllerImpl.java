
package ada.locate.car.controller.impl.client;


import ada.locate.car.app.config.client.ClientControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.ClientDTO;

public class UpdateClientControllerImpl implements Controller {
    private final ClientControllerImplConfig config;

    public UpdateClientControllerImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String type = config.provider().update().typeClientUpdate();
        String document = config.provider().documentEntry().document(type);

        String edit = config.provider().update().optionsUpdate();

        ClientDTO updatedClient = config.DTO().update().buildClientDTO(document, edit);
        ClientDTO clientDTO = config.service().update().execute(updatedClient);

        config.provider().output().updatedSuccessfully(clientDTO.toString());
    }

}


