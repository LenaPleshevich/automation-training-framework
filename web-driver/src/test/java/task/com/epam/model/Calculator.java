package task.com.epam.model;

public class Calculator {
    private String OS;
    private String instancesNumber;
    private String platform;
    private String VMClass;
    private String typeInstance;
    private String localSSD;
    private String commitedUsage;
    private String dataCenterLocation;
    private String GPUNumber;
    private String typeGPU;
    private String cost;
//TODO add checkbox
    public Calculator(String OS, String instancesNumber, String platform, String VMClass, String typeInstance, String localSSD, String commitedUsage, String dataCenterLocation, String GPUNumber, String typeGPU) {
        this.OS = OS;
        this.instancesNumber = instancesNumber;
        this.platform = platform;
        this.VMClass = VMClass;
        this.typeInstance = typeInstance;
        this.localSSD = localSSD;
        this.commitedUsage = commitedUsage;
        this.dataCenterLocation = dataCenterLocation;
        this.GPUNumber = GPUNumber;
        this.typeGPU = typeGPU;
        this.cost = "0.0001";
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getInstancesNumber() {
        return instancesNumber;
    }

    public void setInstancesNumber(String instancesNumber) {
        this.instancesNumber = instancesNumber;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
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

    public String getGPUNumber() {
        return GPUNumber;
    }

    public void setGPUNumber(String GPUNumber) {
        this.GPUNumber = GPUNumber;
    }

    public String getTypeGPU() {
        return typeGPU;
    }

    public void setTypeGPU(String typeGPU) {
        this.typeGPU = typeGPU;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        if (!OS.equals(that.OS)) return false;
        if (!instancesNumber.equals(that.instancesNumber)) return false;
        if (!platform.equals(that.platform)) return false;
        if (!VMClass.equals(that.VMClass)) return false;
        if (!typeInstance.equals(that.typeInstance)) return false;
        if (!localSSD.equals(that.localSSD)) return false;
        if (!commitedUsage.equals(that.commitedUsage)) return false;
        if (!dataCenterLocation.equals(that.dataCenterLocation)) return false;
        if (!GPUNumber.equals(that.GPUNumber)) return false;
        if (!typeGPU.equals(that.typeGPU)) return false;
        return cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        int result = OS.hashCode();
        result = 31 * result + instancesNumber.hashCode();
        result = 31 * result + platform.hashCode();
        result = 31 * result + VMClass.hashCode();
        result = 31 * result + typeInstance.hashCode();
        result = 31 * result + localSSD.hashCode();
        result = 31 * result + commitedUsage.hashCode();
        result = 31 * result + dataCenterLocation.hashCode();
        result = 31 * result + GPUNumber.hashCode();
        result = 31 * result + typeGPU.hashCode();
        result = 31 * result + cost.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "OS='" + OS + '\'' +
                ", instancesNumber='" + instancesNumber + '\'' +
                ", platform='" + platform + '\'' +
                ", VMClass='" + VMClass + '\'' +
                ", typeInstance='" + typeInstance + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", GPUNumber='" + GPUNumber + '\'' +
                ", typeGPU='" + typeGPU + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
