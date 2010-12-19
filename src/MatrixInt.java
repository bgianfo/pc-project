
import java.util.Random;

public class MatrixInt {

  private final int rows;
  private final int cols;
  public final int[][] data;

  public MatrixInt( int rows, int cols ) {
    this.rows = rows;
    this.cols = cols;

    data = new int[rows][cols];
  }

  public MatrixInt( int[][] cdata ) {
    this.rows = cdata.length;
    this.cols = cdata[0].length;

    data = new int[rows][cols];
    this.copyData( cdata );
  }

  private MatrixInt( MatrixInt copy ) { 
    this( copy.data );
  }

  public int rows() { return rows; }

  public int cols() { return cols; }

  private void copyData( int[][] cdata ) {
    for ( int r = 0; r < rows ; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        this.data[r][c] = cdata[r][c];
      }
    }
  }

  public static MatrixInt random( int row, int col ) {

    MatrixInt rand = new MatrixInt( row, col ); 

    Random prng = new Random( 1000 );
    
    for ( int r = 0; r < rand.rows(); r++ ) {
      for ( int c = 0; c < rand.cols(); c++ ) {
        rand.data[r][c] = prng.nextInt();
      }
    }

    return rand;
  }

  public void display() {

  }
  
}
