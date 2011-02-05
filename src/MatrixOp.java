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
   * Add two matrices together
   * 
   * @param a the left matrix
   * @param b the right matrix
   * @return The resulting matrix
   */
  public static MatrixInt add(MatrixInt a, MatrixInt b) 
  {
	  if ( ! a.equalDim( b ) ) 
	  {
	      throw new RuntimeException("Multiplication of different sized matricies");
	  }
	  int[][] data = new int[a.rows()][a.cols()];
	  for(int i=0; i<a.rows(); i++ )
	  {
		  for( int j=0; j<a.cols(); j++ )
		  {
			  data[i][j] = a.data[i][j] + b.data[i][j];
		  }
	  }
	  return new MatrixInt(data);
  }

  /**
   * substract two matrices together
   * 
   * @param a the left matrix
   * @param b the right matrix
   * @return The resulting matrix
   */
  public static MatrixInt sub(MatrixInt a, MatrixInt b) 
  {
	  if ( ! a.equalDim( b ) ) 
	  {
	      throw new RuntimeException("Multiplication of different sized matricies");
	  }
	  int[][] data = new int[a.rows()][a.cols()];
	  for(int i=0; i<a.rows(); i++ )
	  {
		  for( int j=0; j<a.cols(); j++ )
		  {
			  data[i][j] = a.data[i][j] - b.data[i][j];
		  }
	  }
	  return new MatrixInt(data);
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

  public static MatrixDouble mult( MatrixInt b, MatrixDouble a ) {
    return mult( a, b );
  }

  /**
   * Multiply a integer matrix by a integer matrix.
   * 
   * @param a The integer value to multiply the matrix by
   * @param a The other integer value to multiply the matrix by
   * @return The resulting matrix
   */
  public static MatrixDouble mult( MatrixDouble a, MatrixInt b ) {

    if ( ! a.correctDim( b ) ) {
      throw new RuntimeException("Multiplication of different sized matricies");
    }

    MatrixDouble output = new MatrixDouble(a.rows(), b.cols());

    for (int r = 0; r < output.rows(); r++) {
      for (int c = 0; c < output.cols(); c++) {
        for (int k = 0; k < a.cols(); k++) {
          output.data[r][c] += (a.data[r][k] * b.data[k][c]);
        }
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

    if ( ! a.correctDim( b ) ) {
      throw new RuntimeException("Multiplication of different sized matricies");
    }

    MatrixInt output = new MatrixInt(a.rows(), b.cols());

    for (int r = 0; r < output.rows(); r++) {
      for (int c = 0; c < output.cols(); c++) {
        for (int k = 0; k < a.cols(); k++) {
          output.data[r][c] += (a.data[r][k] * b.data[k][c]);
        }
      }
    }
    return output;
  }
  
  /** pads a matrix with 0 until it reaches the new size nbrows, nbcols
   * 
   * @param a
   * @param nbrows
   * @param nbcols
   */
  public static MatrixInt pad(MatrixInt a, int nbrows, int nbcols )
  {
	  System.out.println("resizing to "+nbrows+","+nbcols);
	  int[][] data = new int[nbrows][nbcols];
	  for(int i=0; i<a.rows(); i++ )
	  {
		  for(int j=0; j<a.cols(); j++ )
		  {
			  data[i][j] = a.data[i][j];
		  }
	  }
	  return new MatrixInt(data);	  
  }

  /* return true if number is a power of 2
   */
  public static boolean isPow2(int number)
  {
	  return(   ( (number ^ (number-1)) == number+(number-1) )  &&  (number != 0)    );
	  
  }
  
  public static MatrixInt StrassenMult( MatrixInt a, MatrixInt b )
  {
	  // check if the size is a power of 2 :
	  int rows = Math.min(a.rows(),b.rows());
	  int cols = Math.min(a.cols(),b.cols());
	  int rowsnextpow2 = rows;
	  int colsnextpos2 = cols;
	  
	  if( ! isPow2(rows) )  
	  {
		  rowsnextpow2 = (int)(Math.log((double) rows)/Math.log(2.0f)) + 1;
		  System.out.println(rows+" closest power = "+rowsnextpow2+" = "+Math.pow(2, rowsnextpow2) );
	  }
	  if( ! isPow2(cols) )  
	  {
		  colsnextpos2 = (int)(Math.log((double) cols)/Math.log(2.0f)) + 1;
		  System.out.println(cols+"closest power = "+colsnextpos2+" = "+Math.pow(2, colsnextpos2) );
	  }
	  
	  MatrixInt MatrixAnew = pad(a,(int)Math.pow(2,rowsnextpow2),(int)Math.pow(2,colsnextpos2));
	  MatrixInt MatrixBnew = pad(b,(int)Math.pow(2,rowsnextpow2),(int)Math.pow(2,colsnextpos2));
		
	  return StrassenMultRun(MatrixAnew, MatrixBnew);
  }
  
  
  public static MatrixInt StrassenMultRun( MatrixInt a, MatrixInt b)
  {
	  int n = a.rows();
	  if( !( a.equalDim(b)) || ! (a.cols()==n ) || ! isPow2(n) )
	  {
		  System.out.println("matrices dimensions aren't suitable for the algorithm");
	  }
	  if( n <= 128 ) // 128 seems to be the n where classic mult is more efficient (64 is still fine)
	  {
	  	return mult(a,b);
	  }
	  
	  // divide a and b each into 4 matrices of size (n-1)
	  MatrixInt[] subMatA = new MatrixInt[4];
	  MatrixInt[] subMatB = new MatrixInt[4];

	  for(int i=0; i<2; i++ ) // rows
	  {
		  for( int j=0; j<2; j++ ) // cols
		  {
			  subMatA[i*2+j] = new MatrixInt(n/2,n/2);
			  subMatB[i*2+j] = new MatrixInt(n/2,n/2);

			  // copy the data into the submatrix :
			  for( int l=0;l<n/2; l++ )
			  {
				  for(int m=0; m<n/2; m++)
				  {
					  subMatA[i*2+j].data[l][m] = a.data[i*n/2 + l][j*n/2 + m]; 
					  subMatB[i*2+j].data[l][m] = b.data[i*n/2 + l][j*n/2 + m]; 
				  }
			  }
		  }
	  }
	  
	  MatrixInt[] M = new MatrixInt[7];
	  M[0] = StrassenMultRun( sub(subMatA[1],subMatA[3] ),add( subMatB[2],subMatB[3]) );
	  M[1] = StrassenMultRun( add(subMatA[0],subMatA[3] ),add( subMatB[0], subMatB[3] ));
	  M[2] = StrassenMultRun( sub(subMatA[0],subMatA[2] ),add( subMatB[0], subMatB[1] ));
	  M[3] = StrassenMultRun( add(subMatA[0], subMatA[1]),subMatB[3] ) ;
	  M[4] = StrassenMultRun( subMatA[0],sub(subMatB[1], subMatB[3] ) );
	  M[5] = StrassenMultRun( subMatA[3],sub(subMatB[2], subMatB[0] ) );
	  M[6] = StrassenMultRun( add(subMatA[2],subMatA[3] ),subMatB[0] );

	  MatrixInt[] subMatC = new MatrixInt[4];
	  subMatC[0] = add( M[0], add(M[5], sub(M[1],M[3])));
	  subMatC[1] = add( M[3], M[4] );
	  subMatC[2] = add( M[5], M[6] );
	  subMatC[3] = add( sub(M[1],M[2]), sub(M[4],M[6] ));
	  
	  int[][] cdata = new int[n][n];
	  // copy the data into the submatrix :
	  for( int l =0; l<2; l++ )
	  {
		  for(int m=0; m<2; m++ )
		  {
			  for( int i=0; i<n/2; i++ )
			  {
				  for(int j=0; j<n/2; j++)
				  {
					  cdata[l*n/2+i][m*n/2+j] = subMatC[l*2+m].data[i][j];
				  }
			  }
		  }
	  }
	  return new MatrixInt(cdata);
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
