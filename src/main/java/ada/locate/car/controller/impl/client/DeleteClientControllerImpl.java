package ada.locate.car.controller.impl.client;

import ada.locate.car.app.config.client.ClientControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.ClientDTO;

public class DeleteClientControllerImpl implements Controller {
    private final ClientControllerImplConfig config;

    public DeleteClientControllerImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String type = config.front().optionDelete().execute();

        String document;
        if (type.equalsIgnoreCase("CPF")) {
            document = config.front().CPFentry().execute();
        } else {
            document = config.front().CNPJentry().execute();
        }
        ClientDTO deleteClientDTO = new ClientDTO.Builder().document(document).build();
        config.service().delete().execute(deleteClientDTO);
        config.front().deletedSuccessfully().execute(deleteClientDTO.toString());
        System.out.println(deleteClientDTO);
    }

}
