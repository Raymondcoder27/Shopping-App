package com.example.demo.contracts;

import java.util.UUID;

public class ProductResponse{
    private String message;
    private int status;
    private UUID transactionId;

    public ProductResponse(String message, int status, UUID transactionId) {
        this.message = message;
        this.status = status;
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }
}
