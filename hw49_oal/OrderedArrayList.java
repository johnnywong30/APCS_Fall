// Johnny Wong
// APCS1 pd08
// HW49 - Halving the Halves
// 2017-12-08



/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();    
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }

    // addBin
    // employs a binary search to locate the point of insertion for a new Comparable Object
    // inserts newVal at this appropriate point of insertion
    // maintains ascending order of elements
    public void addBin(Comparable newVal){
	int _lo = 0; // lower bound starts at 0
	int _mid = 0; // midpoint and appropriate point of insertion
	int _hi = size() - 1; // upper bound starts at last index of _data
	if (size() == 0){ // if _data is empty, just append as normal
	    _data.add(newVal);
	    return;
	}
	boolean _found = false;
	while (! _found){
	    _mid = (_hi + _lo) / 2;
	    //System.out.println("Current range is [" + _lo + "," + _hi + "] with midpoint of " + _mid); // tests the current working range
	    if (newVal.compareTo(get(_mid)) > 0) { // newVal greater than item at midpoint so increase lower bound
		_lo = _mid + 1;
		if (_lo > _hi){ // check if index is found
		    _mid++;
		    _found = true; // breaks loop
		}
	    }
	    else if (newVal.compareTo(get(_mid)) < 0) { // newVal less than item at midpoint so decrease upper bound
		_hi = _mid - 1;
		if (_lo > _hi){ // check if index is found
		    _found = true; // breaks loop
		}
	    }
	    else { // newVal is equal to item at midpoint
		_found = true; // breaks loop
	    }
	} // end of binary search

	_data.add(_mid, newVal); // add newVal to appropriate point of insertion

    }

    
    // main method solely for testing purposes
    public static void main( String[] args )
    {
	OrderedArrayList Franz = new OrderedArrayList();
	OrderedArrayList Branz = new OrderedArrayList();

	System.out.println("Testing linear search: ");
	
	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}

	System.out.println("=============================================================");

	System.out.println("Testing binary search: ");
	
	// testing binary search
	for( int i = 0; i < 15; i++ )
	    Branz.addBin( (int)( 50 * Math.random() ) );
	System.out.println( Branz );
	
	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Branz.size()-1; i++ ) {
	    System.out.println("at i: " + Branz.get(i) );
	    if ( Branz.get(i).compareTo(Branz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
