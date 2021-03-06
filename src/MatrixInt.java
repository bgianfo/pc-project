
import java.util.Random;

/**
 * A integer based matrix
 */
public class MatrixInt {

  private final int rows;
  private final int cols;
  public int[][] data;

  /**
   * Integer Matrix constructor for an new empty object.
   *
   * @param rows How many rows in the matrix
   * @param cols How many columns in the matrix
   */
  public MatrixInt( final int rows, final int cols ) {
    this.rows = rows;
    this.cols = cols;

    data = new int[rows][cols];
  }

  /**
   * Data copy constructor
   *
   * @param cdata The data to copy
   */
  public MatrixInt( int[][] cdata ) {
    this.rows = cdata.length;
    this.cols = cdata[0].length;

    data = new int[rows][cols];
    this.copyData( cdata );
  }

  /**
   * Matrix copy constructor
   */
  private MatrixInt( final MatrixInt copy ) { 
    this( copy.data );
  }

  /** return the identity matrix
   * @param size the size of a side of a matrix (identity->square matrix)
   * @return the identity matrix of size (sixe*sixe)
   */
  public static MatrixInt getIdentity(int size)
  {
    int[][] data = new int[size][size];
    // should be initialized at 0 by default
    for(int i=0; i<size; i++)
      data[i][i] = 1; 

    MatrixInt m = new MatrixInt(data);
    return m;
  }

  /** Get the number of rows in the matrix */
  public int rows() { return rows; }

  /** Get the number of columns of in the matrix */
  public int cols() { return cols; }

  /** 
   * Copy the data from a given array into 
   * the matrix own allocated data.
   *
   * @param cdata The multidemensional array to copy from
   */
  private void copyData( int[][] cdata ) {
    for ( int r = 0; r < rows ; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        this.data[r][c] = cdata[r][c];
      }
    }
  }


  /**
   * Generate a identity matrix of type int.
   * @param row The number of rows in the matrix
   * @param col The number of columns in the matrix
   * @return The new identity matrix
   */
  public static MatrixInt identity( final int row, final int col ) {
    MatrixInt ident = new MatrixInt( row, col );
    for ( int i = 0; i < row && i < col; i++ ) {
        ident.data[i][i] = 1;
    }
    return ident;
  }

  /**
   * Generates a new matrix of the specified size, filled with random data.
   *
   * @param row The number of rows in the matrix
   * @param col The number of columns in the matrix
   * @return The new random Integer Matrix
   */
  public static MatrixInt random( final int row, final int col ) {
    MatrixInt rand = new MatrixInt( row, col ); 
    Random prng = new Random();
    
    for ( int r = 0; r < rand.rows(); r++ ) {
      for ( int c = 0; c < rand.cols(); c++ ) {
        rand.data[r][c] = prng.nextInt();
      }
    }

    return rand;
  }

  /**
   * Generates a new matrix of the specified size, filled with random data.
   *
   * @param row The number of rows in the matrix
   * @param col The number of columns in the matrix
   * @return The new random Integer Matrix
   */
  public static MatrixInt randomSmall( final int row, final int col ) {
    int REDUCTION = 10000000;
    MatrixInt rand = MatrixInt.random( row, col );
    for ( int r = 0; r < rand.rows(); r++ ) {
      for ( int c = 0; c < rand.cols(); c++ ) {
        rand.data[r][c] = Math.abs(rand.data[r][c]/REDUCTION);
      }
    }
    return rand;
  }

  /** Determine if two matricies are dimensionally equal */
  public boolean equalDim( final MatrixInt x ) {
    return x.rows() == rows() && x.cols() == cols();
  }

  /** Determine if two matricies are dimensionally equal */
  public boolean equalDim( final MatrixDouble x ) {
    return x.rows() == rows() && x.cols() == cols();
  }

  /** determine whether the dimension of the 2 matrices allows us to perform a matrix multiplication 
   * @param this the left matrix
   * @param b the right matrix
   * @return true if the dimension match
   */
  public boolean correctDim( MatrixDouble b)
  {
    return this.cols() == b.rows();
  }
  
  /** determine whether the dimension of the 2 matrices allows us to perform a matrix multiplication 
   * @param this the left matrix
   * @param b the right matrix
   * @return true if the dimension match
   */
  public boolean correctDim( MatrixInt b)
  {
    return this.cols() == b.rows();
  }

  /**
   * Member function to display the current matrix on the command line.
   */
  public void display() {
    System.out.println( "Dimensions: " + rows() + " X " + cols() );
    for ( int r = 0; r < rows(); r++ ) {
      for ( int c = 0; c < cols(); c++ ) {
        System.out.print( data[r][c] + " " );
      }
      System.out.println();
    }
  }

  /** Tester main argument */
  public static void main( String args[] ) {
    //MatrixInt test = MatrixInt.random(40, 40);
    MatrixInt test = new MatrixInt(50, 50);
    test.display();
    System.out.println("\n\n");

    MatrixInt r = MatrixInt.randomSmall( 20, 20 );
    r.display();
  }

}
