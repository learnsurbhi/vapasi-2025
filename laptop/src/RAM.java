public class RAM{
    private int size;
    private String generation;

    public RAM(int size, String generation) {
        this.size = size;
        this.generation = generation;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "size=" + size +
                ", generation='" + generation + '\'' +
                '}';
    }
}
