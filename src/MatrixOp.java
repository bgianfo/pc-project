/**
 * Serial Matrix Operation Wrappers
 */
public class MatrixOp {

  /**
   * Add a double matrix with a scalar integer value.
   * 
   * @param m Matrix of type double 
   * @param v The integer value to add the matrix with
   * @return The resulting matrix
   */
  public static MatrixDouble add(MatrixDouble m, int v) {
    return add(v,m);
  }

  /**
   * Add a double matrix with a scalar integer value.
   * 
   * @param v The integer value to add the matrix by
   * @param m Matrix of type double 
   * @return The resulting matrix
   */
  public static MatrixDouble add(int v, MatrixDouble m) {
    MatrixDouble output = new MatrixDouble(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] + v;
      }
    }
    return output;
  }

  /**
   * Add a integer matrix with a scalar integer value.
   * 
   * @param m Matrix of type integer
   * @param v The integer value to add the matrix with
   * @return The resulting matrix
   */
  public static MatrixInt add(MatrixInt m, int v) {
    return add(v,m);
  }

  /**
   * Add a integer matrix with a scalar integer value.
   * 
   * @param v The integer value to add the matrix by
   * @param m Matrix of type double 
   * @return The resulting matrix
   */
  public static MatrixInt add(int v, MatrixInt m) {
    MatrixInt output = new MatrixInt(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] + v;
      }
    }
    return output;
  }


  /**
   * Multiply a double matrix by a scalar integer value.
   * 
   * @param m Matrix of type double 
   * @param v The integer value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixDouble mult(MatrixDouble m, int v) {
    return mult(v, m);
  }

  /**
   * Multiply a double matrix by a scalar integer value.
   * 
   * @param v The integer value to multiply the matrix by
   * @param m Matrix of type double 
   * @return The resulting matrix
   */
  public static MatrixDouble mult(int v, MatrixDouble m) {
    MatrixDouble output = new MatrixDouble(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] * v;
      }
    }
    return output;
  }

  /**
   * Multiply a double matrix by a scalar double value.
   * 
   * @param m Matrix of type double 
   * @param v The double value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixDouble mult(MatrixDouble m, double v) {
    return mult(v, m);
  }

  /**
   * Multiply a double matrix by a scalar double value.
   * 
   * @param v The double value to multiply the matrix by
   * @param m Matrix of type double 
   * @return The resulting matrix
   */
  public static MatrixDouble mult(double v, MatrixDouble m) {
    MatrixDouble output = new MatrixDouble(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] * v;
      }
    }
    return output;
  }

  /**
   * Multiply a integer matrix by a scalar double value.
   * 
   * @param m Matrix of type integer
   * @param v The double value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixDouble mult(MatrixInt m, double v) {
    return mult(v, m);
  }

  /**
   * Multiply a integer matrix by a scalar double value.
   * 
   * @param v The double value to multiply the matrix by
   * @param m Matrix of type integer
   * @return The resulting matrix
   */
  public static MatrixDouble mult(double v, MatrixInt m) {
    MatrixDouble output = new MatrixDouble(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] * v;
      }
    }
    return output;
  }

  /**
   * Multiply a integer matrix by a scalar integer value.
   * 
   * @param m Matrix of type integer
   * @param v The integer value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixInt mult(MatrixInt m, int v) {
    return mult(v, m);
  }

  /**
   * Multiply a integer matrix by a scalar integer value.
   * 
   * @param v The integer value to multiply the matrix by
   * @param m Matrix of type integer
   * @return The resulting matrix
   */
  public static MatrixInt mult(int v, MatrixInt m) {
    MatrixInt output = new MatrixInt(m.rows(), m.cols());
    for (int r = 0; r < m.rows(); r++) {
      for (int c = 0; c < m.cols(); c++) {
        output.data[r][c] = m.data[r][c] * v;
      }
    }
    return output;
  }

  /**
   * Multiply a integer matrix by a integer matrix.
   * 
   * @param a The integer value to multiply the matrix by
   * @param a The other integer value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixInt mult( MatrixInt a, MatrixInt b ) {

    if ( ! a.equalDim( b ) ) {
      throw new RuntimeException("Multiplication of different sized matricies");
    }

    MatrixInt output = new MatrixInt(a.rows(), a.cols());

    for (int r = 0; r < output.rows(); r++) {
      for (int c = 0; c < output.cols(); c++) {
        for (int k = 0; k < a.cols(); k++) {
          output.data[r][c] += (a.data[r][k] * b.data[k][c]);
        }
      }
    }
    return output;
  }


  public static void main( String args[] ) {

    MatrixInt A = MatrixInt.random( 900, 900 );
    MatrixInt B = MatrixInt.random( 900, 900 );

    int loop = 20;
    long start = System.currentTimeMillis();
    for (int i = 0; i < loop; i++ ) {
      long lstart = System.currentTimeMillis();
      MatrixInt C = MatrixOp.mult( A, B );
      System.out.println( "Running time = " +
                        (System.currentTimeMillis()-lstart) + " msec" );
    }
    System.out.println( "Avg time = " +
                        (System.currentTimeMillis()-start)/loop + " msec" );

  }

}
