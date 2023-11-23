package com.example.exampledb;

public class MeteringDevice {
    private String deviceNumber;
    private String status;
    private String type;
    private String address;
    private String verificationDate;
    private String verificationExpirationDate;
    private String stamp;
    private String lastReadings;

    public MeteringDevice(String deviceNumber, String status, String type, String address,
                          String verificationDate, String verificationExpirationDate, String stamp,
                          String lastReadings) {
        this.deviceNumber = deviceNumber;
        this.status = status;
        this.type = type;
        this.address = address;
        this.verificationDate = verificationDate;
        this.verificationExpirationDate = verificationExpirationDate;
        this.stamp = stamp;
        this.lastReadings = lastReadings;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerificationExpirationDate() {
        return verificationExpirationDate;
    }

    public void setVerificationExpirationDate(String verificationExpirationDate) {
        this.verificationExpirationDate = verificationExpirationDate;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getLastReadings() {
        return lastReadings;
    }

    public void setLastReadings(String lastReadings) {
        this.lastReadings = lastReadings;
    }
}
