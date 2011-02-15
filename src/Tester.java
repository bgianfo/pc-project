import edu.rit.pj.Comm;

public class Tester {

    static int NUM_RUNS = 4;

    private static void runTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        for ( int i = 0; i < NUM_RUNS; i++ ) {
          MatrixInt C = MatrixOp.mult( A, B );
        }

        long end = System.currentTimeMillis();
        System.out.println( "Classic = ("+N+") = " +(end-start)/NUM_RUNS);
    }

    private static void runStraTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        for ( int i = 0; i < NUM_RUNS; i++ ) {
          MatrixInt C = MatrixOp.strassenMult( A, B );
        }

        long end = System.currentTimeMillis();
        System.out.println( "Strassen ("+N+") = "+(end-start)/NUM_RUNS);
    }

    private static void runPTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        for ( int i = 0; i < NUM_RUNS; i++ ) {
          MatrixInt C = MatrixParallelOp.mult( A, B );
        }

        long end = System.currentTimeMillis();
        System.out.println( "Parallel ("+N+") = "+(end-start)/NUM_RUNS);
    }

    private static void runPStraTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        for ( int i = 0; i < NUM_RUNS; i++ ) {
          MatrixInt C = MatrixParallelStr.mult( A, B );
        }

        long end = System.currentTimeMillis();
        System.out.println( "Parallel Strassen ("+N+") = "+(end-start)/NUM_RUNS);
    }




    public static void main( String[] args ) throws Exception {

        Comm.init( args );
        runTest( 100 );
        runTest( 500 );
        runTest( 1000 );

        runStraTest( 100 );
        runStraTest( 500 );
        runStraTest( 1000 );

        runPTest( 100 );
        runPTest( 500 );
        runPTest( 1000 );

        runPStraTest( 100 );
        runPStraTest( 500 );
        runPStraTest( 1000 );
    }

}
