package ada.locate.car.controller.impl.client;

import ada.locate.car.app.config.client.ClientControllerImplConfig;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.ClientDTO;

public class ReadControllerClientImpl implements Controller {
    private final ClientControllerImplConfig config;

    public ReadControllerClientImpl(ClientControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String option = config.front().optionsRead().execute();

        String document;
        if (option.equalsIgnoreCase("CPF")) {
            document = config.front().CPFentry().execute();
        } else {
            document = config.front().CNPJentry().execute();
        }

        ClientDTO clientDTO = new ClientDTO.Builder().document(document).build();
        ClientDTO readClient = config.service().read().execute(clientDTO);

        config.front().read().execute(readClient.toString());

        System.out.println(readClient);
    }
}
