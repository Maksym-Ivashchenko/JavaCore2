package hw4;

class Engine {
    private int power;

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getFuelType() {
        return "A500";
    }
}
class XFuelEngine extends Engine {
    public String getFuelType() {
        return "XFuel";
    }

    protected String serialNumber;

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
class AdvancedXFuelEngine extends XFuelEngine {
    public void printInfo() {
        System.out.print("Serial number is " + serialNumber);
        System.out.println(", power is " + getPower());
    }
    public static void main(String[] args) {
        AdvancedXFuelEngine engine = new AdvancedXFuelEngine();
        engine.setPower(1000);
        engine.setSerialNumber("SN504030");
        engine.printInfo(); //Serial number is SN504030, power is 1000
    }
}

