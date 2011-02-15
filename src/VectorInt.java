import java.util.Random;

public class VectorInt {

    private int size;
    public int[] data;

    public VectorInt( int size ) {
        this.size = size;
        this.data = new int[size];
    }

    /**
     * Data copy constructor
     *
     * @param cdata The data to copy
     */
    public VectorInt( int[] cdata ) {
        this.size = cdata.length;

        data = new int[size];
        this.copyData( cdata );
    }

    /**
     * Copy the data from a given array into
     * the vector own allocated data.
     *
     * @param cdata The array to copy from
     */
    private void copyData( int[] cdata ) {
        for ( int r = 0; r < size ; r++ ) {
                this.data[r] = cdata[r];
        }
    }

    /**
     * Obtain the lenght of the vector
     */
    public int length() {
        return  size;
    }

    /**
     * Zero out the current vector
     */
    public void zero() {
        for ( int i = 0; i < size; i++ ) {
            this.data[i] = 0;
        }
    }

    /**
     * Generates a new vector of the specified size, filled with random data.
     *
     * @param row The number of rows in the vector
     * @return The new random Double Vector
     */
    public static VectorInt random( int row ) {
        VectorInt rand = new VectorInt( row ); 
        Random prng = new Random( 1000 );
        for ( int r = 0; r < rand.length(); r++ ) {
            rand.data[r] = prng.nextInt();
        }
        return rand;
    }

}
