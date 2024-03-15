package ada.locate.car.app.config.front;

import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;

public record FrontConfig(Input<String[]> inputMultipleFields, Input<String> inputOnlyField, Input<String> inputOptionString,
                          Input<String> inputCPF, Input<String> inputCNPJ, Output showInformation) {
}
