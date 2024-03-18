package ada.locate.car.app.config.allocation;

import ada.locate.car.frontend.api.ShowInputMultipleFields;
import ada.locate.car.frontend.api.ShowInputOnlyField;
import ada.locate.car.frontend.api.ShowInputOptionsString;
import ada.locate.car.frontend.api.ShowOutputDetails;

public record FrontAllocationConfig(
        ShowInputOptionsString clientTypeCreate,
        ShowInputOnlyField plateNumberCreate,
        ShowInputMultipleFields dataAllocation,
        ShowInputOptionsString optionsAllocation,
        ShowInputOptionsString clientTypeDelete,
        ShowInputOnlyField plateNumberDelete,
        ShowOutputDetails allocationDetails,
        ShowInputOnlyField finalDay,
        ShowOutputDetails finalValue
) {
}
