package com.zoden.enums;

public enum MessageType {
    NO_RECORD_EXISTS("1004", "No record exists"),
    GENERAL_ERROR("1005", "General error"),
    TOKEN_EXPIRED("1006", "Token expired"),
    USER_NOT_FOUND("1007", "User not found"),
    USERNAME_OR_PASSWORD_INCORRECT("1008", "Username or password incorrect"),
    REFRESH_TOKEN_NOT_FOUND("1009", "Refresh token not found"),
    REFRESH_TOKEN_EXPIRED("1010", "Refresh token expired"),
    REFRESH_TOKEN_IS_EMPTY("1010", "Refresh token is empty"),
    USERNAME_ALREADY_EXISTS("1011", "Username already exists");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
