package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.infra.dto.VehicleDTO;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;

public class DeleteVehicleControllerImpl implements Controller {

    private final Input<String> inputField;
    private final Output showInformation;

    private final DeleteVehicle deleteVehicleService;

    public DeleteVehicleControllerImpl(Input<String> inputField, Output showInformation, DeleteVehicle deleteVehicleService) {
        this.inputField = inputField;
        this.showInformation = showInformation;
        this.deleteVehicleService = deleteVehicleService;
    }


    @Override
    public void execute() {
        String plateNumber = inputField.execute(MessagesVehicle.TITLE_DELETE_VEHICLE.get(), MessagesVehicle.DELETE_VEHICLE.get());
        VehicleDTO vehicleDTO = new VehicleDTO.Builder().plateNumber(plateNumber).build();
        deleteVehicleService.delete(vehicleDTO);
        //deleteVehicleService.delete(vehicleDTO);
        showInformation.execute("Plate Number", plateNumber);
    }
}
