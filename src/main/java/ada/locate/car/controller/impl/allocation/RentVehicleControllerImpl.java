package ada.locate.car.controller.impl.allocation;

import ada.locate.car.app.config.allocation.AllocationControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public class RentVehicleControllerImpl implements Controller {
    private final AllocationControllerImplConfig config;

    public RentVehicleControllerImpl(AllocationControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        //escolhe o tipo da pessoa que vai alugar
        //mostrar o menu que vai perguntar pra qual tipo de pessoa vai querer alugar;
        String typePerson = config.providerAllocation().create().typeCleint();

        //pega o tipo do cliente e recebe o documento dele
        String documentPerson = config.providerClient().documentEntry().document(typePerson);

        //coloca o documento num clientDTOBuilder, pois vai servir pra buscar o client por document
        ClientDTO clientDTO = config.dtoClient().search().buildClientDTO(documentPerson);

        //seleciona por qual tipo ele quer buscar o vehicle
        String searchVehicles = config.providerVehicle().read().showInputOptionsReadVehicle();

        //vai gerar o objeto dtoBaseado na busca; vai fornece o filtro da busca
        VehicleDTO vehicleDTOSearch = config.dtoVehicle().search().buildSearchDTO(searchVehicles);

        //vai chamar a função do service que vai mostrar os veículos disponíveis pra alocação
        List<VehicleDTO> listAvailableVehicles = config.service().create().availableVehicles(vehicleDTOSearch);
        config.providerVehicle().output().details(VehicleDTO.formatVehicleList(listAvailableVehicles));

        //printar pro usuário ver a lista

        //vai chamar a função que recebe o placa do veículo a ser alogado
        String plateNumberAllocation = config.providerAllocation().create().numberPlate();
        VehicleDTO vehicleDTOAllocation = config.dtoVehicle().search().buildSearchDTOPlateNumber(plateNumberAllocation);

        String[] dataAllocation = config.providerAllocation().create().dataAllocation();
        //gerar o objeto
        //e passar pro service implmentar

        //printa os veículos disponíveis
        //recebe a placa do veículo e passa o o client com o documento
        config.service().create().create(vehicleDTOAllocation, clientDTO);
        //passa pro service RentVehicle e lá ele vai passar o dto pro service do vehicle, que vai pegar o dto e devolver a lista
    }
}
