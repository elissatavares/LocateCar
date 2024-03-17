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
        String type = config.front().optionCreate().execute();
        String[] clientData = config.front().dataClient().execute();
        ClientDTO clientDTO;
        //verifica qual tipo é
        if (type.equalsIgnoreCase("CPF")) {
            String cpf = config.front().CPFentry().execute();
            clientDTO = new ClientDTO.Builder()
                    .name(clientData[0])
                    .address(clientData[1])
                    .phoneNumber(clientData[2])
                    .email(clientData[3])
                    .flagIdentification(type)
                    .document(cpf)
                    .build();

        } else {
            String cnpj = config.front().CNPJentry().execute();
            clientDTO = new ClientDTO.Builder()
                    .name(clientData[0])
                    .address(clientData[1])
                    .phoneNumber(clientData[2])
                    .email(clientData[3])
                    .flagIdentification(type)
                    .document(cnpj)
                    .build();
        }
        config.service().create().execute(clientDTO);

        config.front().createdSuccessfully().execute(clientDTO.toString());

        System.out.println("SUCCESS! Enter Read option to see details.");
    }
}
