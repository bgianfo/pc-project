
public class MatrixOp { 

  // Addition Operators

  public static MatrixDouble add( int value, MatrixDouble matrix ) {
    MatrixDouble output = new MatrixDouble( matrix.rows(), matrix.cols() );

    for ( int r = 0; r < matrix.rows(); r++ ) {
      for ( int c = 0; c < matrix.cols(); c++ ) {
        output.data[r][c] = matrix.data[r][c] + value;
      }
    }
    return output;
  }

  // Multiplication Operators

  public static MatrixDouble mult( MatrixDouble matrix, int value ) {
    return mult( value, matrix );
  }
  public static MatrixDouble mult( int value, MatrixDouble matrix  ) {
    MatrixDouble output = new MatrixDouble( matrix.rows(), matrix.cols() );

    for ( int r = 0; r < matrix.rows(); r++ ) {
      for ( int c = 0; c < matrix.cols(); c++ ) {
        output.data[r][c] = matrix.data[r][c] * value;
      }
    }
    return output;
  }

  public static MatrixDouble mult( MatrixDouble matrix, double value ) {
    return mult( value, matrix );
  }
  public static MatrixDouble mult( double value, MatrixDouble matrix  ) {
    MatrixDouble output = new MatrixDouble( matrix.rows(), matrix.cols() );

    for ( int r = 0; r < matrix.rows(); r++ ) {
      for ( int c = 0; c < matrix.cols(); c++ ) {
        output.data[r][c] = matrix.data[r][c] * value;
      }
    }
    return output;
  }

  public static MatrixDouble mult( double value, MatrixInt matrix ) {
    MatrixDouble output = new MatrixDouble( matrix.rows(), matrix.cols() );

    for ( int r = 0; r < matrix.rows(); r++ ) {
      for ( int c = 0; c < matrix.cols(); c++ ) {
        output.data[r][c] = matrix.data[r][c] * value;
      }
    }
    return output;
  }

  public static MatrixInt mult( int value, MatrixInt matrix ) {
    MatrixInt output = new MatrixInt( matrix.rows(), matrix.cols() );

    for ( int r = 0; r < matrix.rows(); r++ ) {
      for ( int c = 0; c < matrix.cols(); c++ ) {
        output.data[r][c] = matrix.data[r][c] * value;
      }
    }
    return output;
  }





}
