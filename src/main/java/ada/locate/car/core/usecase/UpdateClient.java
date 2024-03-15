package ada.locate.car.core.usecase;


import ada.locate.car.infra.dto.ClientDTO;

public interface UpdateClient {

  void update(String clientId, String[] updatedFields);
//    void update(String id, ClientDTO clientDTO);
}
