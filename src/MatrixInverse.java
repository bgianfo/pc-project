/**
 * A program that applies Gaussian eliminati n t  compute
 * the inverse that solves the system Ax=b
 */
public class MatrixInverse{

    private static final double eps = 1e-10;

    // prevent construction
    private MatrixInverse() { }

    /**
     * Solves the linear system A.x=b
     * @param   A    the matrix of linear equations
     * @param   b    the RHS
     * @return  x    the solution
     */
    public static VectorDouble solve(MatrixDouble A, VectorDouble b) throws Exception {
        // Row echelon form of A
        MatrixDouble REA = eliminate(A);
        // solution vector
        VectorDouble x = new VectorDouble(b.length());
        // set all x_i to 0
        x.zero();

        int N = b.length();
        // perform backsubstitution
        for (int i = N - 1; i >= 0; i--) {
            // initialize sum to 0
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += REA.data[i][j] * x.data[j];
            }
            x.data[i] = (b.data[i] - sum) / REA.data[i][i];
        }
        return x;
    }

    /** 
     * apply gaussian elimination to the matrix a
     */
    public static MatrixDouble eliminate(MatrixDouble A) throws Exception {
        // Determine the number of rows of A
        int N = A.rows();

        // Iterate through all of the rows
        for(int pivot = 0; pivot < N; pivot++) {

            // Initialize the maximum to the first row out of the remaining 
            // N-pivot rows
            int max = pivot;
            // Iterate through the remaining rows
            for(int i = pivot + 1; i < N; i++) {
                // If the absolute value of this row is greater than the last max
                if(Math.abs(A.data[i][pivot]) > Math.abs(A.data[max][pivot])) {
                    // update the new maximum
                    max = i;
                }
            }
            // Holder for the pivot row
            double[] holder = A.data[pivot]; 
            // Swap the old max row with the pivot row
            A.data[pivot] = A.data[max]; 
            // Swap the pivot row into the old max row
            A.data[max] = holder;

            // If the leading coefficient is close to 0
            if (Math.abs(A.data[pivot][pivot]) <= eps) {
                // Exception because matrix may be singular
                throw new RuntimeException("Matrix incapable of inverse" +
                       " solution via Gaussian Elimination");
            }

            // Set leading coefficient to 1 and perform elementary row op
            for (int i = pivot + 1; i < N; i++) {
                // Determine the factor to reduce leading coeff to 1
                double alpha = A.data[i][pivot] / A.data[pivot][pivot];
                for (int j = pivot; j < N; j++) {
                    // Reduce the row to match the operation
                    A.data[i][j] = A.data[i][j] - alpha * A.data[pivot][j];
                }
            }
        }

        return A;
    }

    /** 
     * main method for testing the inversion
     */
    public static void main(String args[]) throws Exception {
        /*
        double[][] data = new double[3][3];
        data[0][0] = 2; data[0][1] = 1; data[0][2] = 1;
        data[1][0] = 5; data[1][1] = 1; data[1][2] = 0;
        data[2][0] = 3; data[2][1] = 2; data[2][2] = 1;
        MatrixDouble A = new MatrixDouble(data);
        A.display();
        double[] vdata = new double[3];
        vdata[0] = 1; vdata[1] = 1; vdata[2] = 1;
        VectorDouble b = new VectorDouble(vdata);
        //MatrixDouble A = MatrixDouble.random(10, 10);
        //VectorDouble b = VectorDouble.random(10);
        MatrixDouble REA;
        VectorDouble x;
        try{
            REA = eliminate(A);
            REA.display();
            x = solve(A,b);
            System.out.println();
            for(int i = 0; i < x.length(); i++) {
                System.out.println(x.data[i]);
            }
        }catch(RuntimeException re){
            System.err.println(re.getMessage());
        }
        */
        
        int loop = 10;
        long start = System.currentTimeMillis();
        for(int i = 0; i < loop; i++) {
            long lstart = System.currentTimeMillis();
            MatrixDouble A = MatrixDouble.random(1000, 1000);
            VectorDouble b = VectorDouble.random(1000);
            VectorDouble x = solve(A,b);
            System.out.println( "Running time = " + 
                    (System.currentTimeMillis()-lstart) + " msec" );
        }
        System.out.println( "Avg time = " + 
                (System.currentTimeMillis()-start)/loop + " msec" );
    }

}//MatrixInverse.java