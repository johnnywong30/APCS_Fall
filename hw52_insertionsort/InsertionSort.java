// Johnny Wong
// APCS1 pd8
// HW52 -- Poker Face
// 2017-12-13

/***************************************
 *  class InsertionSort -- implements InsertionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class InsertionSort
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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data )
    {
	// first element is part of the sorted partition CURRENTLY
	for (int i = 1; i < data.size(); i++){
	    // check elements from right to left
	    // to see where they fit in the sorted partition
	    for (int edge = i; edge > 0; edge--){
		// elements are swapped if the item outside the sorted partition is greater
		// than the current largest item in the sorted partition
		if (data.get(edge).compareTo(data.get(edge - 1)) < 0){
		    data.set(edge, data.set(edge - 1, data.get(edge)));
		}
		// sorted partiton increases in size by 1
	    }
	}
    }//end insertionSortV


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	insertionSort( ArrayList<Comparable> input )
    {
	ArrayList<Comparable> sorted = new ArrayList<Comparable>();
	// copies each item in input into sorted
	for (Comparable item: input){
	    sorted.add(item);
	}
	insertionSortV(sorted);
	return sorted;
    }//end insertionSort


    public static void main( String [] args )
    {
	
	  System.out.println("\n*** Testing sort-in-place (void) version... *** ");
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "\nArrayList glen before sorting:\n" + glen );
	  insertionSortV(glen);
	  System.out.println( "\nArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "\nArrayList coco before sorting:\n" + coco );
	  insertionSortV(coco);
	  System.out.println( "\nArrayList coco after sorting:\n" + coco );
	  /*===============for VOID methods=============
	  ============================================*/


	  System.out.println( "*** Testing non-void version... *** " );
	  ArrayList men = new ArrayList<Integer>();
	  men.add(7);
	  men.add(1);
	  men.add(5);
	  men.add(12);
	  men.add(3);
	  System.out.println( "\nArrayList men before sorting:\n" + men );
	  ArrayList menSorted = insertionSort( men );
	  System.out.println( "\nsorted version of ArrayList men:\n" 
	  + menSorted );
	  System.out.println( "\nArrayList men after sorting:\n" + men );

	  ArrayList popo = populate( 10, 1, 1000 );
	  System.out.println( "\nArrayList popo before sorting:\n" + popo );
	  ArrayList popoSorted = insertionSort( popo );
	  System.out.println( "\nsorted version of ArrayList popo:\n" 
	  + popoSorted );
	  System.out.println( "\nArrayList popo after sorting:\n" + popo );
	  System.out.println( popo );
	  /*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class InsertionSort
