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
        String typePerson = config.providerAllocation().delete().typeClient();

        //pega o tipo do cliente e recebe o documento dele
        String documentPerson = config.providerClient().documentEntry().document(typePerson);

        //coloca o documento num clientDTOBuilder, pois vai servir pra buscar o client por document
        ClientDTO clientDTO = config.dtoClient().search().buildClientDTO(documentPerson, typePerson);

        List<AllocationDTO> allocationDTOS = config.service().delete().getAllAllocations(clientDTO);
        config.providerAllocation().delete().details(AllocationDTO.formatAllocationDTOList(allocationDTOS));

        //receber a placa do carro que quer devolver
        String plateNumberAllocation = config.providerAllocation().delete().plateNumber();
        VehicleDTO vehicleDTOReturn = config.dtoVehicle().search().buildSearchDTOPlateNumber(plateNumberAllocation);

        //inserir a data que esta devolvendo
        String finalDay = config.providerAllocation().delete().finalDay();
        AllocationDTO allocationDTO = config.DTO().delete().deleteAllocation(clientDTO, vehicleDTOReturn, finalDay);
        double finalValue = config.service().delete().allocationValue(allocationDTO);

        config.providerAllocation().delete().displaysTotalAmount(String.valueOf(finalValue));

        //passa pro service desalocar
        config.service().delete().execute(allocationDTO);
        //mostra a mensagem devolvido com sucesso
    }
}
