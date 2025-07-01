public class Laptop {

private Processor proc;
private RAM ram;
private HDD hdd;

    public Laptop(Processor proc, RAM ram, HDD hdd) {
        this.proc = proc;
        this.ram = ram;
        this.hdd = hdd;
    }

    public Processor getProc() {
        return proc;
    }

    public void setProc(Processor proc) {
        this.proc = proc;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "proc=" + proc +
                ", ram=" + ram +
                ", hdd=" + hdd +
                '}';
    }
}


