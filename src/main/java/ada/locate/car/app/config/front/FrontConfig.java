package ada.locate.car.app.config.front;

import ada.locate.car.frontend.api.Input;

public record FrontConfig(
        Input<String> showInputOptionsInsertModelFilter,
        Input<String> showInputOptionsModel,
        Input<String> showInputOptionsReadVehicle,
        Input<String> showInputOptionsUpdateVehicle,
        Input<String> showInputOptionsVehicle,
        Input<String[]> showDataVehicleEntry,
        Input<String[]> showColorAndPlateNumberUpdateDataEntry,
        Input<String> showExclusionField,
        Input <String> showUpdatePlateEntry,
        Input <String> showUpdateColorEntry,
        Input <String> showNewPlateNumberEntry,
        Input <String> showFilterPlateEntry,
        Input <String> showFilterColorEntry
) {
}
