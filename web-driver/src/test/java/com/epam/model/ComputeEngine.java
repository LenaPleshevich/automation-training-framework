package com.epam.model;

import java.util.Objects;

public class ComputeEngine {
    private String os;
    private int instancesNumber;
    private String platform;
    private String vmClass;
    private String typeInstance;
    private String localSSD;
    private String commitedUsage;
    private String dataCenterLocation;
    private String numberGPU;
    private String typeGPU;

    public ComputeEngine(String os, int instancesNumber, String platform, String vmClass,
                         String typeInstance, String localSSD, String commitedUsage,
                         String dataCenterLocation, String numberGPU, String typeGPU) {
        this.os = os;
        this.instancesNumber = instancesNumber;
        this.platform = platform;
        this.vmClass = vmClass;
        this.typeInstance = typeInstance;
        this.localSSD = localSSD;
        this.commitedUsage = commitedUsage;
        this.dataCenterLocation = dataCenterLocation;
        this.numberGPU = numberGPU;
        this.typeGPU = typeGPU;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getInstancesNumber() {
        return instancesNumber;
    }

    public void setInstancesNumber(int instancesNumber) {
        this.instancesNumber = instancesNumber;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getTypeInstance() {
        return typeInstance;
    }

    public void setTypeInstance(String typeInstance) {
        this.typeInstance = typeInstance;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getNumberGPU() {
        return numberGPU;
    }

    public void setNumberGPU(String numberGPU) {
        this.numberGPU = numberGPU;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputeEngine computeEngine = (ComputeEngine) o;

        return Objects.equals(os, computeEngine.os) &&
                instancesNumber == computeEngine.instancesNumber &&
                Objects.equals(platform, computeEngine.platform) &&
                Objects.equals(vmClass, computeEngine.vmClass) &&
                Objects.equals(typeInstance, computeEngine.typeInstance) &&
                Objects.equals(localSSD, computeEngine.localSSD) &&
                Objects.equals(commitedUsage, computeEngine.commitedUsage) &&
                Objects.equals(dataCenterLocation, computeEngine.dataCenterLocation) &&
                Objects.equals(numberGPU, computeEngine.numberGPU) &&
                Objects.equals(typeGPU, computeEngine.typeGPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instancesNumber, platform, vmClass, typeInstance, localSSD,
                commitedUsage, dataCenterLocation, numberGPU, typeGPU);
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "os='" + os + '\'' +
                ", instancesNumber='" + instancesNumber + '\'' +
                ", platform='" + platform + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", typeInstance='" + typeInstance + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", numberGPU='" + numberGPU + '\'' +
                ", typeGPU='" + typeGPU + '\'' +
                '}';
    }
}
