package ada.locate.car.config.record.client;

import ada.locate.car.frontend.api.ShowInputMultipleFields;
import ada.locate.car.frontend.api.ShowInputOnlyField;
import ada.locate.car.frontend.api.ShowInputOptionsString;
import ada.locate.car.frontend.api.ShowOutputDetails;
import ada.locate.car.frontend.impl.client.ShowInputCNPJ;
import ada.locate.car.frontend.impl.client.ShowInputCPF;

public record ClientFrontendConfig(
        ShowInputOptionsString optionsClient,
        ShowInputOptionsString optionCreate,
        ShowInputMultipleFields dataClient,
        ShowInputCPF CPFentry,
        ShowInputCNPJ CNPJentry,
        ShowOutputDetails createdSuccessfully,
        ShowInputOptionsString optionDelete,
        ShowOutputDetails deletedSuccessfully,
        ShowInputOptionsString optionsRead,
        ShowOutputDetails read,
        ShowInputOptionsString optionsUpdate,
        ShowInputOptionsString updateCPForCNPJ,
        ShowInputOnlyField updateName,
        ShowInputOnlyField updateAddress,
        ShowInputOnlyField updatePhoneNumber,
        ShowInputOnlyField updateEmail,
        ShowOutputDetails updatedSuccessfully
        ) {
}
