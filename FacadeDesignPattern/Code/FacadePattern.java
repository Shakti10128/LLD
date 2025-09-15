package FacadeDesignPattern.Code;

class PowerSupply {
    public void providePower(){
        System.out.println("Power Supply: Providing power...");
    }
}

class CoolingSystem{
    public void startFans(){
        System.out.println("Cooling System: Fans started...");
    }
}

class CPU{
    public void initialize(){
        System.out.println("CPU: initialization started...");
    }
}

class Memory {
    public void selfTest(){
        System.out.println("Memory: Self test started...");
    }
}

class HardDrive{
    public void spinUp(){
        System.out.println("Hard Drive: Spinning Up...");
    }
}

class BIOS{
    public void boot(Memory memory,CPU cpu) {
        System.out.println("BIOS Booting: CPU and Memory checks...");
        cpu.initialize();
        memory.selfTest();
    }
}

class OperatingSystem{
    public void load(){
        System.out.println("Operating System: Loading into memory...");
    }
}

class ComputerFacade{
    private final PowerSupply powerSupply = new PowerSupply();
    private final CoolingSystem coolingSystem = new CoolingSystem();
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();
    private final BIOS bios = new BIOS();
    private final OperatingSystem operatingSystem = new OperatingSystem();

    public void startComputer(){
        System.out.println("--------- Starting Computer ----------");
        powerSupply.providePower();
        coolingSystem.startFans();
        bios.boot(memory, cpu);
        hardDrive.spinUp();
        operatingSystem.load();
    }
}



public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade comp = new ComputerFacade();
        comp.startComputer();
    }
}
