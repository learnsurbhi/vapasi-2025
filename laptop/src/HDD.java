public class HDD {

    private int size;
    private String type;

    public HDD(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
