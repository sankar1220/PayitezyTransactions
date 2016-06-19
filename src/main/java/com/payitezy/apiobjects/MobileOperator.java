package com.payitezy.apiobjects;

import org.springframework.stereotype.Component;

@Component("mobileOperator")
public class MobileOperator {
    private String error;
    private String circle;
    private String message;
    private String operator;

    public String getCircle() {
        return circle;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getOperator() {
        return operator;
    }

    public void setCircle(final String circle) {
        this.circle = circle;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

}
