package hw4;

class Tanker {
    private String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    protected String getFuelType() {
        return "A500";
    }
    public void refuel(int amount) {
        System.out.print("Add " + amount);
        System.out.print(" of " + getFuelType());
        System.out.println(", tanker serial number is " + serialNumber);
    }
}
class XFuelTanker extends Tanker {
    protected String getFuelType() {
        return "XFuel";
    }
}
class MX200Tanker extends Tanker {
    protected String getFuelType() {
        return "MX200";
    }

    public static void main(String[] args) {
        Tanker tanker = new MX200Tanker();
        tanker.setSerialNumber("SN504030");
        tanker.refuel(300);
    }
}