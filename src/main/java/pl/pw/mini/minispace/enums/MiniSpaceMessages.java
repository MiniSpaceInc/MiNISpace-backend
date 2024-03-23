package pl.pw.mini.minispace.enums;

public enum MiniSpaceMessages {
    ENTITY_ALREADY_EXISTS_MESSAGE("%s with id %d already exists"),

    // VALIDATION MESSAGES
    FIELD_IS_EMPTY_MESSAGE("%s field is empty"),
    FIELD_IS_NULL("%s field is null"),
    ;

    MiniSpaceMessages(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return this.message;
    }

}
