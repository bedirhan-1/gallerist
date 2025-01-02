package com.zoden.handler;

import java.util.Date;

public class Exception<E> {
    private String path;
    private Date createdAt;
    private String hostName;
    private E message;

    public Exception(String path, Date createdAt, String hostName, E message) {
        this.path = path;
        this.createdAt = createdAt;
        this.hostName = hostName;
        this.message = message;
    }

    public Exception() {}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public E getMessage() {
        return message;
    }

    public void setMessage(E message) {
        this.message = message;
    }
}
