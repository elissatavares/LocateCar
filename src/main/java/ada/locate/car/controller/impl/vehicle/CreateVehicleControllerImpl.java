package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.model.Vehicle;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;

import java.time.LocalDate;
import java.util.Arrays;

public class CreateVehicleControllerImpl implements Controller {

    private final Input<String> inputOptionString;
    private final Input<String[]> inputMultipleFields;
    private final Output showInformation;

    public CreateVehicleControllerImpl(Input<String> inputModel, Input<String[]> inputCampus, Output showInformation) {
        this.inputOptionString = inputModel;
        this.inputMultipleFields = inputCampus;
        this.showInformation = showInformation;
    }

    @Override
    public void execute() {
        String[] campus = inputMultipleFields.execute(MessagesVehicle.INSERT_DATA.get(), MessagesVehicle.ALL_DATA.get());
        String model = inputOptionString.execute(MessagesVehicle.SELECT_MODEL.get(), MessagesVehicle.ALL_MODELS.get());
        Vehicle vehicle = new Vehicle(campus[0], LocalDate.parse(campus[1]), campus[2], campus[3], campus[4], model);
        showInformation.execute(vehicle.toString(), MessagesVehicle.VEHICLE_DETAILS.get());

        System.out.println(Arrays.toString(campus));
        System.out.println(model);
        System.out.println(vehicle);
    }
}
