
public class VectorDouble {

    private int size;
    public double[] data;

    public VectorDouble( int size ) {
        this.size = size;
        this.data = new double[size];
    }

    public int length() {
        return  size;
    }

    public void zero() {
        for ( int i = 0; i < size; i++ ) {
            this.data[i] = 0;
        }
    }
}
