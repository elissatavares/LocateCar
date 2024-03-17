package ada.locate.car.infra.provider.builder.client;

import ada.locate.car.infra.dto.ClientDTO;

public class ClientReadBuilder {

    public ClientDTO buildClientDTO(String document){
        return new ClientDTO.Builder().document(document).build();
    }
}
