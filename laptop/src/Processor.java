public class Processor {

    private String generation;
    private int ghz;

    public Processor(String gen, int ghz) {
        this.generation = gen;
        this.ghz = ghz;
    }

    public String getGen() {
        return generation;
    }

    public void setGen(String gen) {
        this.generation = gen;
    }

    public int getGhz() {
        return ghz;
    }

    public void setGhz(int ghz) {
        this.ghz = ghz;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "generation='" + generation + '\'' +
                ", ghz=" + ghz +
                '}';
    }
}

