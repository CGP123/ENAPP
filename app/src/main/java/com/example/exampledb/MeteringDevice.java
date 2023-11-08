package com.example.exampledb;

public class MeteringDevice {
    private String deviceNumber;
    private String nameOfOwner;
    private String status;
    private String stamp;

    public MeteringDevice(String deviceNumber, String nameOfOwner, String status, String stamp) {
        this.deviceNumber = deviceNumber;
        this.nameOfOwner = nameOfOwner;
        this.status = status;
        this.stamp = stamp;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}
