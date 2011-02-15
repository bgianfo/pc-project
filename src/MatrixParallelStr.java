
import edu.rit.pj.Comm;
import edu.rit.pj.ParallelRegion;
import edu.rit.pj.ParallelTeam;
import edu.rit.pj.IntegerForLoop;
import edu.rit.pj.IntegerSchedule;


/**
 * Parallel Matrix Operation Wrappers
 */
public class MatrixParallelStr {

  // Create a static team to avoid allocation hit
  static ParallelTeam team = new ParallelTeam();


  /** pads a matrix with 0 until it reaches the new size nbrows, nbcols
   * 
   * @param a
   * @param nbrows
   * @param nbcols
   */
  public static MatrixInt pad( MatrixInt a, int nbrows, int nbcols ) {
    int[][] data = new int[nbrows][nbcols];
    for(int i = 0; i < a.rows(); i++ ) {
      for(int j = 0; j < a.cols(); j++ ) {
        data[i][j] = a.data[i][j];
      }
    }
    return new MatrixInt( data );
  }
  /* return true if number is a power of 2
   */
  public static boolean isPow2(int number)
  {
    return ((number ^ (number-1)) == (number+(number-1))) && (number != 0);
  }

  public static MatrixInt mult( MatrixInt a, MatrixInt b ) throws Exception {

    if ( ! a.correctDim( b ) ) {
        throw new RuntimeException("Multiplication of different sized matricies");
    }

    // check if the size is a power of 2 :
  int finalrows = a.rows();
  int finalcol = b.cols();

    int rows = Math.max(a.rows(),b.rows());
    int cols = Math.max(a.cols(),b.cols());
    int resizing = Math.max(rows,cols);
    // we want a and b to be 2 matrices of size the closest power of 2 of 'resizing'

    MatrixInt result;

    if ( a.equalDim(b)  && isPow2(rows) ) {
      result =  multRunSmp( a, b );
    } else {
      if( ! isPow2(resizing) )
            resizing = (int)(Math.log((double) resizing)/Math.log(2.0f)) + 1;

      MatrixInt MatrixAnew = pad(a,(int)Math.pow(2,resizing),(int)Math.pow(2,resizing));
      MatrixInt MatrixBnew = pad(b,(int)Math.pow(2,resizing),(int)Math.pow(2,resizing));
      result =  multRunSmp( MatrixAnew, MatrixBnew );
    }

    // Copy the result and suppress the padded zeroes
    int data[][] = new int[finalrows][finalcol];
    for( int i=0; i < finalrows; i++ ) {
      for(int j=0; j< finalcol; j++ ) {
        data[i][j] = result.data[i][j];
      }
    }
    return new MatrixInt(data);
  }


  /**
   * Sequential helper function
   */
  public static MatrixInt multRunSeq( MatrixInt a, MatrixInt b ) throws Exception {

    int n = a.rows();
    // 128 seems to be the n where classic mult is more efficient (64 is still fine)
    if ( n <= 128 ) { 
      return MatrixOp.mult( a,b );
    }

    // Divide a and b each into 4 matrices of size (n-1)
    final MatrixInt[] subMatA = new MatrixInt[4];
    final MatrixInt[] subMatB = new MatrixInt[4];

    for ( int i = 0; i < 2; i++ ) { // rows
      for ( int j = 0; j < 2; j++ ) { // cols
        subMatA[i*2+j] = new MatrixInt(n/2,n/2);
        subMatB[i*2+j] = new MatrixInt(n/2,n/2);
        // Copy the data into the submatrix :
        for( int l = 0; l < n/2; l++ ) {
          for( int m = 0; m < n/2; m++ ) {
            subMatA[i*2+j].data[l][m] = a.data[i*n/2 + l][j*n/2 + m]; 
            subMatB[i*2+j].data[l][m] = b.data[i*n/2 + l][j*n/2 + m]; 
          }
        }
      }
    }

    final int STEPS = 7;
    final MatrixInt[] M = new MatrixInt[STEPS];

    M[0] = multRunSeq( MatrixOp.sub( subMatA[1], subMatA[3] ), MatrixOp.add( subMatB[2],subMatB[3]) );
    M[1] = multRunSeq( MatrixOp.add( subMatA[0], subMatA[3] ), MatrixOp.add( subMatB[0], subMatB[3] ));
    M[2] = multRunSeq( MatrixOp.sub( subMatA[0], subMatA[2] ), MatrixOp.add( subMatB[0], subMatB[1] ));
    M[3] = multRunSeq( MatrixOp.add( subMatA[0], subMatA[1]), subMatB[3] ) ;
    M[4] = multRunSeq( subMatA[0], MatrixOp.sub( subMatB[1], subMatB[3] ) );
    M[5] = multRunSeq( subMatA[3], MatrixOp.sub( subMatB[2], subMatB[0] ) );
    M[6] = multRunSeq( MatrixOp.add( subMatA[2],subMatA[3] ), subMatB[0] );

    final int SUB_STEPS = 3;

    final MatrixInt[] subMatC = new MatrixInt[4];

    subMatC[0] = MatrixOp.add( M[0], MatrixOp.add(M[5], MatrixOp.sub(M[1],M[3])));
    subMatC[1] = MatrixOp.add( M[3], M[4] );
    subMatC[2] = MatrixOp.add( M[5], M[6] );
    subMatC[3] = MatrixOp.add( MatrixOp.sub(M[1],M[2]), MatrixOp.sub(M[4],M[6] ));


    // Copy the data into the submatrix :
    MatrixInt output = new MatrixInt(n,n);
    for( int l = 0; l < 2; l++ ) {
      for( int m = 0; m < 2; m++ ) {
        for( int i = 0; i < n/2; i++ ) {
          for( int j = 0; j < n/2; j++ ) {
            output.data[l*n/2+i][m*n/2+j] = subMatC[l*2+m].data[i][j];
          }
        }
      }
    }
    return output;
  }

  public static MatrixInt multRunSmp( MatrixInt a, MatrixInt b) throws Exception {

    int n = a.rows();
    if ( !( a.equalDim(b)) || ! (a.cols()==n ) || ! MatrixOp.isPow2(n) ) {
      System.err.println("matrices dimensions aren't suitable for the algorithm");
    }

    if ( n <= 128 ) { // 128 seems to be the n where classic mult is more efficient (64 is still fine)
      return MatrixOp.mult(a,b);
    }

    // Divide a and b each into 4 matrices of size (n-1)
    final MatrixInt[] subMatA = new MatrixInt[4];
    final MatrixInt[] subMatB = new MatrixInt[4];

    for ( int i = 0; i < 2; i++ ) { // rows
      for ( int j = 0; j < 2; j++ ) { // cols
        subMatA[i*2+j] = new MatrixInt(n/2,n/2);
        subMatB[i*2+j] = new MatrixInt(n/2,n/2);
        // Copy the data into the submatrix :
        for( int l = 0; l < n/2; l++ ) {
          for( int m = 0; m < n/2; m++ ) {
            subMatA[i*2+j].data[l][m] = a.data[i*n/2 + l][j*n/2 + m]; 
            subMatB[i*2+j].data[l][m] = b.data[i*n/2 + l][j*n/2 + m]; 
          }
        }
      }
    }

    final int STEPS = 7;
    final MatrixInt[] M = new MatrixInt[STEPS];

    team.execute( new ParallelRegion() {
      public void run() throws Exception {
        execute( 0, STEPS-1, new IntegerForLoop() {

          public IntegerSchedule schedule() {
              return IntegerSchedule.dynamic();
          }

          public void run( int first, int last ) throws Exception {
            for ( int step = first; step <= last; step++ ) {
              switch ( step ) {
                case 0:
                    M[0] = multRunSeq( MatrixOp.sub( subMatA[1], subMatA[3] ), MatrixOp.add( subMatB[2],subMatB[3]) );
                    break;
                case 1:
                    M[1] = multRunSeq( MatrixOp.add( subMatA[0], subMatA[3] ), MatrixOp.add( subMatB[0], subMatB[3] ));
                    break;
                case 2:
                    M[2] = multRunSeq( MatrixOp.sub( subMatA[0], subMatA[2] ), MatrixOp.add( subMatB[0], subMatB[1] ));
                    break;
                case 3:
                    M[3] = multRunSeq( MatrixOp.add( subMatA[0], subMatA[1]), subMatB[3] ) ;
                    break;
                case 4:
                    M[4] = multRunSeq( subMatA[0], MatrixOp.sub( subMatB[1], subMatB[3] ) );
                    break;
                case 5:
                    M[5] = multRunSeq( subMatA[3], MatrixOp.sub( subMatB[2], subMatB[0] ) );
                    break;
                case 6:
                    M[6] = multRunSeq( MatrixOp.add( subMatA[2],subMatA[3] ), subMatB[0] );
                    break;
                default:
                    break;
              }
            }
          }
        });
      }
    });

    final int SUB_STEPS = 3;

    final MatrixInt[] subMatC = new MatrixInt[4];

    team.execute( new ParallelRegion() {
      public void run() throws Exception {
        execute( 0, SUB_STEPS, new IntegerForLoop() {
          public void run( int first, int last ) throws Exception{
            for ( int step = first; step <= last; step++ ) {
              switch ( step ) {
                case 0:
                    subMatC[0] = MatrixOp.add( M[0], MatrixOp.add(M[5], MatrixOp.sub(M[1],M[3])));
                    break;
                case 1:
                    subMatC[1] = MatrixOp.add( M[3], M[4] );
                    break;
                case 2:
                    subMatC[2] = MatrixOp.add( M[5], M[6] );
                    break;
                case 3:
                    subMatC[3] = MatrixOp.add( MatrixOp.sub(M[1],M[2]), MatrixOp.sub(M[4],M[6] ));
                    break;
                default:
                    break;
              }
            }
          }
        });
      }
    });


    // Copy the data into the submatrix :
    MatrixInt output = new MatrixInt( n, n );
    for( int l = 0; l < 2; l++ ) {
      for( int m = 0; m < 2; m++ ) {
        for( int i = 0; i < n/2; i++ ) {
          for( int j = 0; j < n/2; j++ ) {
            output.data[l*n/2+i][m*n/2+j] = subMatC[l*2+m].data[i][j];
          }
        }
      }
    }
    return output;
  }

  public static void main( String args[] ) throws Exception {
    // Initialize parallel infrastructure
    Comm.init( args );

    MatrixInt A = MatrixInt.random(1000,512);
    MatrixInt B = MatrixInt.random(512,1000);

    long t0 = System.currentTimeMillis();
    MatrixInt C = MatrixOp.strassenMult(A, B);
    long t1 = System.currentTimeMillis();
    MatrixInt Cprime = MatrixOp.mult(A,B);
    long t2 = System.currentTimeMillis();

    System.out.println("strassen = "+(t1-t0));
    System.out.println("classic = "+(t2-t1));

    long t3 = System.currentTimeMillis();
    MatrixInt C2prime = mult( A,B );
    long t4 = System.currentTimeMillis();

    System.out.println("parallel strassen = "+(t4-t3));

  } 
}
