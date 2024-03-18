package ada.locate.car.DTO.utils.client;

import ada.locate.car.DTO.ClientDTO;

public class ClientReadDTO {

    public ClientDTO buildClientDTO(String document, String type){
        return new ClientDTO.Builder().flagIdentification(type).document(document).build();
    }
}
