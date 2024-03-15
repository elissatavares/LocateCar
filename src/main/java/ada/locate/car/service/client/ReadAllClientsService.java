//package ada.locate.car.service.client;
//
//import ada.locate.car.core.model.Client;
//import ada.locate.car.infra.api.Repository;
//import ada.locate.car.infra.dto.ClientDTO;
//import ada.locate.car.infra.repository.ClientRepository;
//import ada.locate.car.core.usecase.ReadAllClients;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ReadAllClientsService implements ReadAllClients {
//    private final Repository<Client> clientRepository;
//
//    public ReadAllClientsService(Repository<Client> clientRepository) {
//        this.clientRepository = clientRepository;
//    }
//
//
//
////    @Override
////    public List<ClientDTO> readAll() {
////        return clientRepository.findAll().stream()
////                .map(client -> new ClientDTO(
////                        client.getId(),
////                        client.getName(),
////                        client.getAddress(),
////                        client.getPhoneNumber(),
////                        client.getEmail(),
////                        client.getIdentification()))
////                .collect(Collectors.toList());
////
////    }
//
//}
