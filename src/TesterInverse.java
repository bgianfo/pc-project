import edu.rit.pj.Comm;

public class TesterInverse {

	  static int NUM_RUNS = 4;

    private static void runTest( int N ) throws Exception {

        MatrixDouble A = MatrixDouble.random(N,N);
        VectorDouble B = VectorDouble.random(N);


        long start = System.currentTimeMillis();

				for ( int i = 0; i < NUM_RUNS; i++ ) {
          VectorDouble C = MatrixInverse.solve( A, B );
				}

        long end = System.currentTimeMillis();
        System.out.println( "Classic = ("+N+") = " +(end-start)/NUM_RUNS);
    }

    private static void runPTest( int N ) throws Exception {

        MatrixDouble A = MatrixDouble.random(N,N);
        VectorDouble B = VectorDouble.random(N);

        long start = System.currentTimeMillis();

				for ( int i = 0; i < NUM_RUNS; i++ ) {
        	VectorDouble C = MatrixInverseSmp.solve( A, B );
				}

        long end = System.currentTimeMillis();
        System.out.println( "Parallel ("+N+") = "+(end-start)/NUM_RUNS);
    }

    public static void main( String[] args ) throws Exception {

        Comm.init( args );
        runTest( 100 );
        runTest( 500 );
        runTest( 1000 );

        runPTest( 100 );
        runPTest( 500 );
        runPTest( 1000 );
    }
}
