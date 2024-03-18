package ada.locate.car.app.messages;

public enum MessagesAllocation {
    ALLOCATION_MENU("Vehicle rental"),
    OPTION_ALLOCATION("Rent Vehicle\nReturn Vehicle"),
    ENTER_CREATE_TYPE_CLIENT("Select the type of customer you want to make the allocation"),
    SEARCH_OPTION_PROMPT("CPF\nCNPJ"),
    MENU_RENT("Rent Menu"),
    MENU_RETURN("Return Menu"),
    VEHICLE_IDENTIFICATION("Enter the vehicle license plate number"),
    ALL_ALLOCATION_DATA("Date & Hour(yyyy-mm-dd HH:mm)\nLocale"),
    ENTER_RETURN_TYPE_CLIENT("Select the type of customer you want to make the return"),
    ALLOCATION_ClIENT_CAR("Vehicles located by the customer"),

    ENTER_FINAL_DAY("Final day"),

    DESCRIPTION_FINAL_DAY("Enter Date and hour to return vehicle (YYYY-mm-dd HH:mm)"),
    VALUE_FINAL("Total amount R$ to be paid"),
    ALLOCATION_SUCESS_MSG("Vehicle successfully allocated!"),
    RETURN_SUCESS_MSG("Vehicle returned successfully!");
    private final String message;

    MessagesAllocation(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}

