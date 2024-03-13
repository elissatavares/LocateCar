package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.CreateVehicle;
import ada.locate.car.dto.VehicleDTO;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;

import java.time.LocalDate;
public class CreateVehicleControllerImpl implements Controller {

    private final Input<String> inputOptionString;
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    private final CreateVehicle createVehicleService;

    public CreateVehicleControllerImpl(Input<String> inputModel, Input<String[]> inputCampus, Output showInformation, CreateVehicle createVehicleService) {
        this.inputOptionString = inputModel;
        this.inputMultipleFields = inputCampus;
        this.showInformation = showInformation;
        this.createVehicleService = createVehicleService;
    }

    @Override
    public void execute() {
        String[] data = inputMultipleFields.execute(MessagesVehicle.INSERT_DATA.get(), MessagesVehicle.ALL_DATA.get());
        String model = inputOptionString.execute(MessagesVehicle.SELECT_MODEL.get(), MessagesVehicle.ALL_MODELS.get());
        VehicleDTO vehicleDTO = new VehicleDTO(data[0], LocalDate.parse(data[1]), data[2], data[3], model);

        createVehicleService.create(vehicleDTO);

        showInformation.execute(vehicleDTO.toString(), MessagesVehicle.VEHICLE_DETAILS.get());
    }
}
