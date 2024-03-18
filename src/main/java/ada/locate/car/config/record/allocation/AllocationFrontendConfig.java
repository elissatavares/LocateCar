package ada.locate.car.config.record.allocation;

import ada.locate.car.frontend.api.ShowInputMultipleFields;
import ada.locate.car.frontend.api.ShowInputOnlyField;
import ada.locate.car.frontend.api.ShowInputOptionsString;
import ada.locate.car.frontend.api.ShowOutputDetails;

public record AllocationFrontendConfig(
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
