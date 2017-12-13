// Johnny Wong
// APCS1 pd8
// HW51 -- Selection
// 2017-12-12



/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
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
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }

    // return index of first instance of smallest value of the inputted ArrayList<Comparable>
    public static int minDex(ArrayList<Comparable> input, int first){
	Comparable min = input.get(first);
	int minDex = first;
	for (int i = first; i < input.size(); i++){
	    Comparable next = input.get(i);
	    if (min.compareTo(next) > 0){
		min = next; // if previous min was greater than current item at index p, assign min to this
		minDex = i;
	    }
	}
	return minDex;
    }

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	for (int i = 0; i < data.size(); i++){
	    int min = minDex(data, i);
	    data.set(min, data.set(i, data.get(min)));
	}

    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> sorted = new ArrayList<Comparable>();
	for (Comparable item: input){
	    sorted.add(item); // copies each item of input to sorted
	}
	selectionSortV(sorted);
	return sorted;
    }//end selectionSort 


    public static void main( String [] args ) 
    {
	System.out.println("=========================for VOID methods=======================");
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	/*===============for VOID methods=============
	  ============================================*/

	System.out.println("===================for AL-returning methods====================");
	
	ArrayList plen = new ArrayList<Integer>();
	plen.add(7);
	plen.add(1);
	plen.add(5);
	plen.add(12);
	plen.add(3);
	System.out.println( "ArrayList plen before sorting:\n" + plen );
	ArrayList plenSorted = selectionSort( plen );
	System.out.println( "sorted version of ArrayList plen:\n" 
			    + plenSorted );
	System.out.println( "ArrayList plen after sorting:\n" + plen );

	ArrayList popo = populate( 10, 1, 1000 );
	System.out.println( "ArrayList popo before sorting:\n" + popo );
	ArrayList popoSorted = selectionSort( popo );
	System.out.println( "sorted version of ArrayList popo:\n" 
			    + popoSorted );
	System.out.println( "ArrayList popo after sorting:\n" + popo );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
