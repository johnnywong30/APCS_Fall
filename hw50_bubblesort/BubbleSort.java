// Johnny Wong
// APCS1 pd08
// HW50 - Dat Bubbly Tho
// 2017-12-11



/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	int passes = data.size() - 1; // num of passes required to sort elements
	while (passes > 0){
	    for (int i = data.size() - 1; i > 0; i--){
		int comparison = data.get(i).compareTo(data.get(i - 1)); // compare right value to left value
		if (comparison < 0){ // if left value is less than right value
		    // switch left and right values' positions
		    Comparable leftValue = data.get(i);
		    data.set(i, data.get(i - 1)); 
		    data.set(i - 1, leftValue);
		}
	    }
	    passes--; 
	}
    }


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	ArrayList<Comparable> retAL = input;
	bubbleSortV( retAL );
	return retAL;
    }


    public static void main( String [] args )
    {


	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );

	  System.out.println("============================================");

	  
	  ArrayList blen = new ArrayList<Integer>();
	  blen.add(7);
	  blen.add(1);
	  blen.add(5);
	  blen.add(12);
	  blen.add(3);
	  System.out.println( "ArrayList blen before sorting:\n" + blen );
	  ArrayList blenSorted = bubbleSort( blen );
	  System.out.println( "sorted version of ArrayList blen:\n" 
	  + blenSorted );
	  System.out.println( "ArrayList blen after sorting:\n" + blen );

	  ArrayList zoco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList zoco before sorting:\n" + zoco );
	  ArrayList zocoSorted = bubbleSort( zoco );
	  System.out.println( "sorted version of ArrayList zoco:\n" 
	  + zocoSorted );
	  System.out.println( "ArrayList zoco after sorting:\n" + zoco );
	  
	  

    }//end main

}//end class BubbleSort
