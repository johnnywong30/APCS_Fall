// Johnny Wong
// APCS1 pd 8
// HW 40 -- Make It Better
// 2017-11-27

/* SUMMARY OF PROGRAM:
   ========================================================================
   A constant array called STRINGS is intialized that contains the random
   characters I would like each of my randomly generated Strings to consist of.

   Past Johnny's version of print (int [] [] a) has been reused and readjusted 
   for usage in 2-dimensional String arrays.

   threeOrFour() -- returns the int 3 or 4 based on the value of Math.random() to decide
                    how long a String should be in uniqueStrings
   genRandChar() -- returns a String selected at random from the constant String array STRINGS

   In the main method, random values in the range [1,11) are assigned to 
                       rows and columns.

		       Afterward, a new 2-dimensional String array, a, is intialized
		       with its numRows and numColumns corresponding with the previously
		       generated values for rows and columns.

                       Once intialized, array a invokes the method uniqueString
		       and a is populated with random Strings using the helper
		       methods threeOrFour() and genRandChar().

		       Once populated, array a invokes the method print and is printed
		       out as a String.

		       Array a then proceeds to invoke method swap, where a user inputs
		       the first String's row and cell index and the second String's row and cell index.

		       The values of these two Strings at these locations are swapped in
		       array a.

		       Array a invokes the method print again and is printed out as a String
		       with the changes after swap(a) already made.

   ========================================================================
 */

/* v2 Improvements:
   ========================================================================

   *Added grid labeling system, incorporated into methods print and uniqueStrings.
   *Added report about the Strings being swapped via the swapChoice method.
   *Added report about invalid inputs via the userInt method.

   ========================================================================
 */
import cs1.Keyboard;

public class Swapper{
    private static final String [] STRINGS = {
	"a", "b", "c", "d", "e", "f", "g", "h",
	"i", "j", "k", "l", "m", "n", "o", "p",
	"q", "r", "s", "t", "u", "v", "w", "x",
	"y", "z", "0", "1", "2", "3", "4", "5",
	"6", "7", "8", "9", "!", "?", "."
    };
    // methods

    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print( String[][] a )
    {
	String cellNum = "";
	int count = -1;
	for (String str: a[0]){
	    count++;
	    if (count == 0){
		cellNum += "    ";
	    }
	    cellNum += count;
	    cellNum += "     ";
	}
	System.out.println(cellNum);
	count = 0;
	for (String [] row: a){
	    String strRow = "";
	    strRow += count + "   ";
	    for (String cell: row){
		strRow += cell + ", ";
	    }
	    System.out.println(strRow.substring(0,strRow.length()-2));
	    System.out.println();
	    count++;
	}
    }

    // postcond: returns the int 3 or 4 based on the value of Math.random() to decide
    //           how long a String should be in uniqueStrings
    public static int threeOrFour(){
	double choose = Math.random();
	if (choose < 0.5){
	    return 3;
	}
	return 4;
    }

    // postcond: returns a String selected at random from the constant String array STRINGS
    public static String genRandChar(){
	int randNum = (int) (Math.random() * 39);
	return STRINGS[randNum];
    }
    // precond: 2 dimensional array a has cells all intialized as null
    // postcond: 2 dimensional array a is populated with random Strings in each cell of each row
    public static void uniqueStrings(String [][] a){
        for (int r = 0; r < a.length; r++){
	    for (int cell = 0; cell < a[r].length; cell++){
	        int numChars = threeOrFour();
		int count = 0;
		String randStr = "";
		while (count < numChars){
		    randStr += genRandChar();
		    count++;
		}
		a[r][cell] = randStr;
	    }
	}
    }
    // postcond: returns an int that the user inputs - if the input is invalid print error message until user inputs a valid int
    public static int userInt(int length, String position){
	Keyboard keyboard = new Keyboard();
	int input = -1;
	while (input < 0 || input > length){
	    input = keyboard.readInt();
	    if (input > length || input < 0){
		System.out.println("That is not a valid " + position + ". Please try again...");
	    }
	}
	return input;
    }

    // postcond: prints the Strings that are to be swapped
    public static void swapChoices(String first, String second){
	System.out.println("These are the Strings you want to swap...\n");
	System.out.println(first + " and " + second);
    }

    
    
    // postcond: The method swap is performed on inputted 2 dimensional String array a
    //           The user inputs the row number and cell number of the first String desired
    //           to be swapped. Then, the user inputs the row number and cell number of the
    //           second String that it is being swapped for. These row and cell numbers are
    //           stored in variables. The value of the first String is stored in variable 'first'
    //           while the second String is stored in variable 'second'. The element at index of 'first'
    //           is assigned the value of 'second' and the element at index of 'second' is assigned the
    //           value of 'first'.
    public static void swap(String [] [] a){
	String s = "Please input the index of the String you would like to swap\n";
	s += "in the following format: \nrow\ncell\n";
	s += "Possible row values are: 0 to " + (a.length - 1) + "\n";
	s += "Possible cell values are: 0 to " + (a[0].length - 1) + "\n";
	s += "Index: ";
	System.out.println(s);
	int selectedRow = userInt(a.length - 1, "row");
	int selectedCell = userInt(a[0].length - 1, "cell");
	s = "\nPlease input the index of the String you would like to swap with now...\n";
	s += "in the following format: \nrow\ncell\n";
        s += "Possible row values are: 0 to " + (a.length - 1) + "\n";
	s += "Possible cell values are: 0 to " + (a[0].length - 1) + "\n";
	s += "Index: ";
	System.out.println(s);
	int newRow = userInt(a.length - 1, "row");
	int newCell = userInt(a[0].length - 1, "cell");
	String first = a[selectedRow][selectedCell];
	String second = a[newRow][newCell];
	swapChoices(first, second);
	a[selectedRow][selectedCell] = second;
	a[newRow][newCell] = first;
	System.out.println("\nNow presenting your new array...\n");
	
    }

    // refer to summary
    public static void main(String [] args){
	int rows = (int) (Math.random() * 8) + 3;
	int columns = (int) (Math.random() * 10) + 1;
	String [] [] a = new String[rows][columns];
	uniqueStrings(a);
	print(a);
	swap(a);
	print(a);
	
    } // end of main
} // end of class Swap
