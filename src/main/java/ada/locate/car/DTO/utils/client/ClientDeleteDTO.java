package ada.locate.car.DTO.utils.client;

import ada.locate.car.DTO.ClientDTO;

public class ClientDeleteDTO {

    public ClientDTO buildClientDTO(String document){
        return new ClientDTO.Builder().document(document).build();
    }

}
