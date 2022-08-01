package com.example.demo_maven;

public class DataVM {
    private String header;
    private String body;
    private String signature;

    public DataVM() {
    }

    public DataVM(String header, String body, String signature) {
        this.header = header;
        this.body = body;
        this.signature = signature;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getSignature() {
        return signature;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
