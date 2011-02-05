import java.util.Random;

public class VectorDouble {

    private int size;
    public double[] data;

    public VectorDouble( int size ) {
        this.size = size;
        this.data = new double[size];
    }

    /**
     * Data copy constructor
     *
     * @param cdata The data to copy
     */
    public VectorDouble( double[] cdata ) {
        this.size = cdata.length;

        data = new double[size];
        this.copyData( cdata );
    }

    /** 
     * Copy the data from a given array into 
     * the vector own allocated data.
     *
     * @param cdata The array to copy from
     */
    private void copyData( double[] cdata ) {
        for ( int r = 0; r < size ; r++ ) {
                this.data[r] = cdata[r];
        }
    }

    /**
     * Generates a new vector of the specified size, filled with random data.
     *
     * @param row The number of rows in the vector
     * @return The new random Double Vector
     */
    public static VectorDouble random( int row ) {
        VectorDouble rand = new VectorDouble( row ); 
        Random prng = new Random( 1000 );
        for ( int r = 0; r < rand.length(); r++ ) {
            rand.data[r] = prng.nextDouble();
        }
        return rand;
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
