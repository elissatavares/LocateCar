
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
        String type = config.front().updateCPForCNPJ().execute();

        String document;
        if (type.equalsIgnoreCase("CPF")) {
            document = config.front().CPFentry().execute();
        } else {
            document = config.front().CNPJentry().execute();
        }

        String edit = config.front().optionsUpdate().execute();
        System.out.println(edit);

        ClientDTO updatedClient = null;
        switch (edit.toLowerCase()) {
            case "name" -> updatedClient = new ClientDTO.Builder()
                    .name(nameUpdate())
                    .document(document)
                    .description(edit)
                    .build();
            case "address" -> updatedClient = new ClientDTO.Builder()
                    .address(addressUpdate())
                    .description(edit)
                    .document(document)
                    .build();
            case "phone number" -> updatedClient = new ClientDTO.Builder()
                    .phoneNumber(phoneNumberUpdate())
                    .document(document)
                    .description(edit)
                    .build();
            case "email" -> updatedClient = new ClientDTO.Builder()
                    .email(emailUpdate())
                    .document(document)
                    .description(edit)
                    .build();
        }
        ClientDTO clientDTO = config.service().update().execute(updatedClient);
        config.front().updatedSuccessfully().execute(clientDTO.toString());
    }

    private String nameUpdate(){
        return config.front().updateName().execute();
    }
    private String addressUpdate(){
        return config.front().updateAddress().execute();
    }

    private String phoneNumberUpdate(){
        return config.front().updatePhoneNumber().execute();
    }
    private String emailUpdate(){
        return config.front().updateEmail().execute();
    }

}


