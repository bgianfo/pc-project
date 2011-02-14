import edu.rit.pj.Comm;

public class TesterVector {

	  static int NUM_RUNS = 4;

    private static void runTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        VectorInt B = VectorInt.random(N);

        long start = System.currentTimeMillis();

				for ( int i = 0; i < NUM_RUNS; i++ ) {
          MatrixInt C = MatrixOp.mult( A, B );
				}

        long end = System.currentTimeMillis();
        System.out.println( "Classic = ("+N+") = " +(end-start)/NUM_RUNS);
    }

    private static void runPTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        VectorInt B = VectorInt.random(N);

        long start = System.currentTimeMillis();

				for ( int i = 0; i < NUM_RUNS; i++ ) {
        	MatrixInt C = MatrixParallelOp.mult( A, B );
				}

        long end = System.currentTimeMillis();
        System.out.println( "Parallel ("+N+") = "+(end-start)/NUM_RUNS);
    }

    public static void main( String[] args ) throws Exception {

        Comm.init( args );
        runTest( 1000 );
        runTest( 2000 );
        runTest( 4000 );

        runPTest( 1000 );
        runPTest( 2000 );
        runPTest( 4000 );
    }
}
