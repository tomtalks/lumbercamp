package com.soprasteria.lumbercamp.service;

public class OakException extends RuntimeException {
    public OakException(String message) {
        super(message);
    }

    public OakException(Integer ask, Integer available) {
        super(String.format("Oak can only be delivered if all is honored %d < %d",available,ask));
    }
}
