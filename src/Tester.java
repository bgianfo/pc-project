import edu.rit.pj.Comm;

public class Tester {


    private void runTest( int N ) {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        MatrixInt C = MatrixOp.mult( A, B );

        long end = System.currentTimeMillis();
        System.out.println( "Classic = ("+N+") = " +(end-start));
    }

    private void runStraTest( int N ) {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        MatrixInt C = MatrixOp.strassenMult( A, B );

        long end = System.currentTimeMillis();
        System.out.println( "Strassen ("+N+") = "+(end-start));
    }

    private void runPTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        MatrixInt C = MatrixParallelOp.mult( A, B );

        long end = System.currentTimeMillis();
        System.out.println( "Parallel ("+N+") = "+(end-start));
    }

    private void runPStraTest( int N ) throws Exception {

        MatrixInt A = MatrixInt.random(N,N);
        MatrixInt B = MatrixInt.random(N,N);

        long start = System.currentTimeMillis();

        MatrixInt C = MatrixParallelStr.mult( A, B );

        long end = System.currentTimeMillis();
        System.out.println( "Parallel Strassen ("+N+") = "+(end-start));
    }




    public static void main( String[] args ) {

        Comm.init( args );
        runTest( 100 );
        runTest( 500 );
        runTest( 1000 );
        runTest( 1024 );

        runStraTest( 100 );
        runStraTest( 500 );
        runStraTest( 1000 );
        runStraTest( 1024 );

        runPTest( 100 );
        runPTest( 500 );
        runPTest( 1000 );
        runPTest( 1024 );

        runPStraTest( 100 );
        runPStraTest( 500 );
        runPStraTest( 1000 );
        runPStraTest( 1024 );
    }

}
