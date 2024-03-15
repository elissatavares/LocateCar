//package ada.locate.car.controller.impl.vehicle;
//
//import ada.locate.car.app.messages.MessagesVehicle;
//import ada.locate.car.controller.api.Controller;
//import ada.locate.car.core.usecase.CreateVehicle;
//import ada.locate.car.infra.dto.VehicleDTO;
//import ada.locate.car.frontend.api.Input;
//import ada.locate.car.frontend.api.Output;
//
//import java.time.LocalDate;
//
//public class CreateVehicleControllerImpl implements Controller {
//
//    private final Input<String> inputOptionString;
//    private final Input<String[]> inputMultipleFields;
//    private final Output showInformation;
//
//    private final CreateVehicle createVehicleService;
//
//    public CreateVehicleControllerImpl(Input<String> inputOptionString, Input<String[]> inputMultipleFields, Output showInformation, CreateVehicle createVehicleService) {
//        this.inputOptionString = inputOptionString;
//        this.inputMultipleFields = inputMultipleFields;
//        this.showInformation = showInformation;
//        this.createVehicleService = createVehicleService;
//    }
//
//
//    @Override
//    public void execute() {
//        String[] data = inputMultipleFields.execute(MessagesVehicle.INSERT_DATA.get(), MessagesVehicle.ALL_DATA.get());
//        String model = inputOptionString.execute(MessagesVehicle.SELECT_MODEL.get(), MessagesVehicle.ALL_MODELS.get());
//        VehicleDTO vehicleDTO = new VehicleDTO.Builder()
//                .brand(data[0])
//                .yearManufacture(LocalDate.parse(data[1]))
//                .color(data[2])
//                .plateNumber(data[3])
//                .model(model)
//                .build();
//        //createVehicleService.create(vehicleDTO);
//
//        showInformation.execute(vehicleDTO.toString(), MessagesVehicle.VEHICLE_DETAILS.get());
//        return null;
//    }
//}
