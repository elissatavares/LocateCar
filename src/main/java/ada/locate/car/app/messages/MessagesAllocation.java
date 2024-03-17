package ada.locate.car.app.messages;

public enum MessagesAllocation {
    ALLOCATION_MENU("Vehicle rental"),
    OPTION_ALLOCATION("Rent Vehicle\nReturn Vehicle"),
    SEARCH_OPTION_PROMPT("CPF\nCNPJ"),
    MENU_RENT("Rent Menu"),
    MENU_RETURN("Return Menu"),
    VEHICLE_IDENTIFICATION("Enter the vehicle to return"),
    ALL_ALLOCATION_DATA("Vehicle\nLocal\nDate"),
    CREATED_SUCESS_MSG("Allocation created successfully!");
//  UPDATED_SUCESS_MSG("Allocation updated successfully!");


    private final String message;

    MessagesAllocation(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}

