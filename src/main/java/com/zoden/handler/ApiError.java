package com.zoden.handler;

public class ApiError<E> {

    private Integer status;
    private Exception<E> exception;

    public ApiError(Integer status, Exception<E> exception) {
        this.status = status;
        this.exception = exception;
    }

    public ApiError() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Exception<E> getException() {
        return exception;
    }

    public void setException(Exception<E> exception) {
        this.exception = exception;
    }
}
