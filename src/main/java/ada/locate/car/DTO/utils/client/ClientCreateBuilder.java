package ada.locate.car.DTO.utils.client;

import ada.locate.car.DTO.ClientDTO;

public class ClientCreateBuilder {

    public ClientDTO buildClientDTO(String type, String[] data, String document){
            return new ClientDTO.Builder()
                    .name(data[0])
                    .address(data[1])
                    .phoneNumber(data[2])
                    .email(data[3])
                    .flagIdentification(type)
                    .document(document)
                    .build();
    }
}
