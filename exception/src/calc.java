public class calc {

    public calc() {}

    public double calcdouble(int n) {

        if (n == 0) {
            throw new MyArithExcep("Zero not allowed");
        }
        else if (n < 0) {
            throw new MyArithExcep("Negative not allowed");
        }
        else {
            return n*2;
        }
    }
}