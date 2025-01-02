package com.zoden.exception;

import com.zoden.enums.MessageType;

public class ErrorMessage {
    private String ofStatic;
    private MessageType messageType;

    public String prepareErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(messageType.getCode()).append("] ").append(messageType.getMessage());

        if (this.ofStatic != null) {
            sb.append(": ").append(ofStatic);
        }

        return sb.toString();
    }

    public ErrorMessage(MessageType messageType, String ofStatic) {
        this.ofStatic = ofStatic;
        this.messageType = messageType;
    }

    public ErrorMessage() {
    }

    public String getOfStatic() {
        return ofStatic;
    }

    public void setOfStatic(String ofStatic) {
        this.ofStatic = ofStatic;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
