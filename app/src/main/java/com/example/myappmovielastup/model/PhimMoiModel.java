package com.example.myappmovielastup.model;

import java.util.List;

public class PhimMoiModel {
    boolean success;
    String message;
    List<PhimMoi> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PhimMoi> getResult() {
        return result;
    }

    public void setResult(List<PhimMoi> result) {
        this.result = result;
    }
}
