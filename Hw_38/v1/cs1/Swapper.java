// Johnny Wong
// APCS1 pd 8
// HW 38 -- Put It Together
// 2017-11-21

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
	for (String [] row: a){
	    String strRow = "[";
	    for (String cell: row){
		strRow += cell + ", ";
	    }
	    System.out.println(strRow.substring(0,strRow.length()-2) + "]");
	    System.out.println();
	}
    }

    public static int threeOrFour(){
	double choose = Math.random();
	if (choose < 0.5){
	    return 3;
	}
	return 4;
    }

    public static String genRandChar(){
	int randNum = (int) (Math.random() * 39);
	return STRINGS[randNum];
    }
    
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
    

    public static void main(String [] args){
	int rows = (int) (Math.random() * 10) + 1;
	int columns = (int) (Math.random() * 10) + 1;
	String [] [] a = new String[rows][columns];
	uniqueStrings(a);
	print(a);
    }
}
