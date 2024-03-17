package ada.locate.car.app.config.allocation;

import ada.locate.car.frontend.api.ShowInputMultipleFields;
import ada.locate.car.frontend.api.ShowInputOnlyField;
import ada.locate.car.frontend.api.ShowInputOptionsString;

public record FrontAllocationConfig(
        ShowInputOptionsString clientType,
        ShowInputOnlyField plateNumber,
        ShowInputMultipleFields dataAllocation,
        ShowInputOptionsString optionsAllocation
) {
}
