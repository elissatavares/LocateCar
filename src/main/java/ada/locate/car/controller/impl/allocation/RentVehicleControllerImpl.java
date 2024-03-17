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
        String option = config.front().optionsRead().execute();

        String document;
        if (option.equalsIgnoreCase("CPF")) {
            document = config.front().CPFentry().execute();
        } else {
            document = config.front().CNPJentry().execute();
        }

        ClientDTO clientDTO = new ClientDTO.Builder().document(document).build();
        ClientDTO readClient = config.service().read().execute(clientDTO);
        String searchType = config.front().showInputOptionsReadVehicle().execute();
        List<VehicleDTO> vehicleDTOList = config.service().create().create();
    }
}
