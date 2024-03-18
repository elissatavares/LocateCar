package ada.locate.car.app.config.vehicle;

import ada.locate.car.frontend.api.ShowInputMultipleFields;
import ada.locate.car.frontend.api.ShowInputOnlyField;
import ada.locate.car.frontend.api.ShowInputOptionsString;
import ada.locate.car.frontend.api.ShowOutputDetails;

public record FrontVehicleConfig(
        ShowInputMultipleFields showDataVehicleEntry,
        ShowInputMultipleFields showColorAndPlateNumberUpdateDataEntry,

        ShowInputOnlyField showExclusionField,
        ShowInputOnlyField showUpdatePlateEntry,
        ShowInputOnlyField showUpdateColorEntry,
        ShowInputOnlyField showNewPlateNumberEntry,
        ShowInputOnlyField showFilterPlateEntry,
        ShowInputOnlyField showFilterColorEntry,

        ShowInputOptionsString showInputOptionsModel,
        ShowInputOptionsString showInputOptionsReadVehicle,
        ShowInputOptionsString showInputOptionsUpdateVehicle,
        ShowInputOptionsString showInputOptionsVehicle,
        ShowInputOptionsString showInputOptionsInsertModelFilter,

        ShowOutputDetails readVehicle
) {
}
