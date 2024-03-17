package ada.locate.car.controller.impl.allocation;

import ada.locate.car.DTO.AllocationDTO;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.DTO.VehicleDTO;
import ada.locate.car.app.config.allocation.AllocationControllerImplConfig;
import ada.locate.car.controller.api.Controller;

import java.util.List;

public class ReturnRentedVehicleControllerImpl implements Controller {

    private final AllocationControllerImplConfig config;

    public ReturnRentedVehicleControllerImpl(AllocationControllerImplConfig config) {
        this.config = config;
    }

    @Override
    public void execute() {
        //escolhe o tipo da pessoa que vai devolver
        //mostrar o menu que vai perguntar pra qual tipo de pessoa vai devolver;
        //MUDAR PRA delete().
        String typePerson = config.providerAllocation().create().typeCleint();

        //pega o tipo do cliente e recebe o documento dele
        String documentPerson = config.providerClient().documentEntry().document(typePerson);

        //coloca o documento num clientDTOBuilder, pois vai servir pra buscar o client por document
        ClientDTO clientDTO = config.dtoClient().search().buildClientDTO(documentPerson);

        List<AllocationDTO> allocationDTOS = config.service().delete().getAllAllocations(clientDTO);
        String formated = AllocationDTO.formatAllocationDTOList(allocationDTOS);

        //receber a placa do carro que quer devolver
        String plateNumberAllocation = config.providerAllocation().create().numberPlate();
        VehicleDTO vehicleDTOReturn = config.dtoVehicle().search().buildSearchDTOPlateNumber(plateNumberAllocation);

        //exibe o valor a ser pago: mostra a opção devolver ou cancelar

        AllocationDTO allocationDTO = config.DTO().deleteAllocation(clientDTO, vehicleDTOReturn);
        //passa pro service desalocar
        config.service().delete().execute(allocationDTO);
        //mostra a mensagem devolvido com sucesso
    }
}
