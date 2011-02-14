import java.util.Random;

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
