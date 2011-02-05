
public class VectorInt {

    private int size;
    public int[] data;

    public VectorInt( int size ) {
        this.size = size;
        this.data = new int[size];
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
