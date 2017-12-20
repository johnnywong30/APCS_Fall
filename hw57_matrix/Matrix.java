// Johnny Wong
// APCS1 pd8
// HW57 -- How Deep Does the Rabbit Hole Go?
// 2017-12-20


/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    // O(1)
    public Matrix( ) 
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }
    // O(1)
    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }

    // O(1) because only one action is executed
    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return matrix.length; 
    }

    // O(1) because only one action is executed
    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return matrix[r - 1][c - 1]; 
    }


    // O(n^2) because two linears multiplied together
    //return true if this matrix is empty, false otherwise
    private boolean isEmpty() 
    {
	
	boolean empty = true;
	for (int i = 0; i < size(); i++){
	    for (int j = 0; j < matrix[i].length; j++){
		if (! (get(i + 1,j + 1) == null)){
		    empty = false;
		}
	    }
	}
	return empty;
	

    }


    // O(1) because one action is performed
    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	
	Object old = get(r + 1, c + 1);
	matrix[r][c] = newVal;
	return old;
    }

    // O(n^2) because its a 2D representation
    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	
	// procedure to create heading and footer of matrix
	int borderLength = matrix[1].length * matrix[1].length;
	String border = "-";
	for (int i = 0; i < borderLength + 1; i++){
	    border += " ";
	}
	border += "-";
	String strMatrix = border + "\n"; // init as header

	// procedure to add contents of matrix to strMatrix
	for (int i = 0; i < size(); i++){
	    strMatrix += "| ";
	    for (Object item: matrix[i]){
		strMatrix += item + " ";
	    }
	    strMatrix += "|\n";
	}
	strMatrix += border; // close matrix with footer
	return strMatrix;
    }

    // O(n^2) because a linear check is performed within a linear check
    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	// O(n^2)
    	if (!(rightSide instanceof Matrix)){ // check if rightSide is even a matrix
    	    return false;
    	}
    	if (this.size() != ((Matrix) rightSide).size()){ // check if both matrices have same lengths
    	    return false;
    	}
    	for (int i = 0; i < size(); i++){
    	    for (int j = 0; j < this.matrix[i].length; j++){
    		if (!(this.get(i + 1, j + 1).equals( ((Matrix) rightSide).get(i + 1, j + 1)))){ // check equality of each item in matrices
    		    return false;
    		}
    	    }
    	}
    	return true;
    }


    // O(n) because it traverses linearly through each row swapping each time
    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	
	for (int r = 0; r < size(); r++){
	    set(r, c1 - 1, set(r, c2 - 1, matrix[r][c1 - 1]));
	}
    }

    // O(1) because a swap is performed only once
    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	Object [] temp = matrix[r2 - 1];
	matrix[r2 - 1] = matrix[r1 - 1];
	matrix[r1 - 1] = temp;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	System.out.println("TESTING default constructor, size method, get method, isEmpty method, set method, and toString method");
	Matrix test = new Matrix();
	System.out.println(test.toString());
	System.out.println("Currently empty... " + test.isEmpty());
	// populate test.matrix
	int number = 0;
	for (int i = 0; i < test.size(); i++){
	    for (int j = 0; j < test.matrix[i].length ; j++){
		test.set(i, j , number);
		number++;
	    }
	}
	System.out.println("Item at M[1,1] is: " + test.get(1,1));
	System.out.println("Matrix test...\n" + test.toString());
	System.out.println("Currently empty... " + test.isEmpty());
	System.out.println("\nTESTING equals method, swapColumns method, and swapRows method");
	
	Matrix comparer = new Matrix();
	number = 0;
	for (int i = 0; i < comparer.size(); i++){
	    for (int j = 0; j < comparer.matrix[i].length ; j++){
		comparer.set(i, j , number);
		number++;
	    }
	}
	System.out.println("Matrix comparer...\n" + comparer.toString());
	System.out.println("Are matrices test and comparer equal... " + test.equals(comparer));

	test.swapColumns(1,2);
	System.out.println("Test post swapColumns(1,2)...");
	System.out.println(test.toString());

	test.swapRows(1,2);
	System.out.println("Test post swapRows(1,2)...");
	System.out.println(test.toString());
    }

}//end class Matrix
