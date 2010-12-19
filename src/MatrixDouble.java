import java.util.Random;

public class MatrixDouble {

  private final int rows;
  private final int cols;
  public final double[][] data;

  public MatrixDouble( int rows, int cols ) {
    this.rows = rows;
    this.cols = cols;

    data = new double[rows][cols];
  }

  public MatrixDouble( double[][] cdata ) {
    this.rows = cdata.length;
    this.cols = cdata[0].length;

    data = new double[rows][cols];
    this.copyData( cdata );
  }

  private MatrixDouble( MatrixDouble copy ) { 
    this( copy.data );
  }

  public int rows() { return rows; }

  public int cols() { return cols; }

  private void copyData( double[][] cdata ) {
    for ( int r = 0; r < rows ; r++ ) {
      for ( int c = 0; c < cols; c++ ) {
        this.data[r][c] = cdata[r][c];
      }
    }
  }

  public static MatrixDouble random( int row, int col ) {

    MatrixDouble rand = new MatrixDouble( row, col ); 

    Random prng = new Random( 1000 );
    
    for ( int r = 0; r < rand.rows(); r++ ) {
      for ( int c = 0; c < rand.cols(); c++ ) {
        rand.data[r][c] = prng.nextDouble();
      }
    }

    return rand;
  }

  public void display() {

  }
}
