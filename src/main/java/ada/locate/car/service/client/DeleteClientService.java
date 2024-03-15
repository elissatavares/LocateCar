//package ada.locate.car.service.client;
//
//import ada.locate.car.core.model.Client;
//import ada.locate.car.core.usecase.DeleteClient;
//import ada.locate.car.infra.api.Repository;
//import ada.locate.car.infra.dto.ClientDTO;
//
//public class DeleteClientService implements DeleteClient {
//    private final Repository<Client> repository;
//
//    public DeleteClientService(Repository<Client> repository) {
//        this.repository = repository;
//    }
//
//
//    @Override
//    public void delete(ClientDTO clientDTO) {
//        Client clientToDelete = repository.read(new Client(clientDTO.identification(), null, null, null, null));
//        if (clientToDelete != null) {
//            repository.delete(clientToDelete);
//        } else {
//            System.out.println("Cliente não encontrado para exclusão.");
//        }
//    }
//}
