// Johnny Wong
// APCS1 pd 8
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-4

/***************************
 * class SuperArray version 4.0
 * ( SKELETON )
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * List interface. (List.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List
{

  private Object[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ", ";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-2 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object[] temp = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public Object get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public Object set( int index, Object newVal )
  {
    Object temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public boolean add( Object newVal )
  {
    add( _size, newVal );
    return true;
  }


  //inserts an item at index
  public void add( int index, Object newVal )
  {
    //first expand if necessary
    if ( _size >= _data.length )
      expand();
    for( int i = _size; i > index; i-- ) {
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    }
    _data[index] = newVal;
    _size++;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public Object remove( int index )
  {
      Object removed = _data[index];
    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _size--;
    return removed;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
      // create instances of Rational to test new Object SuperArray
      Rational v = new Rational(3,7);
      Rational w = new Rational(4,9);
      Rational x = new Rational(8,18);
      Rational y = new Rational(6,14);
      Rational z = new Rational();

      
    List mayfield = new SuperArray();
    System.out.println(mayfield);
    mayfield.add(v); 
    mayfield.add(w);
    mayfield.add(x);
    mayfield.add(y);
    mayfield.add(z);

    System.out.println(mayfield);

    System.out.println("======================================================================");
    System.out.println("Now testing remove method with signature 'Object remove(int index)'...");
    System.out.println("Removing element at index 3: "); 
    System.out.println(mayfield.remove(3));
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    System.out.println("Removing element at index 3: ");
    System.out.println(mayfield.remove(3));
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    Rational a = new Rational(1,2);

    
    mayfield.add(3,a);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);

    // test on String
    mayfield.add(2,"This works!");
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    // test if SuperArray still works with ints... and it does
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    
    
    
  }//end main()


}//end class


/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
     *####:    *#####*                      .###########*  ,####*
  .*####:    ,#######,                        ##########*    :####*
  *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
       *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
            *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
                 *###############*,,,,,,,,::**######,
                   *##############################:
                     *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
                          *####:      *####:
                           .*####,  *####*
                             :####*####*
                               *######
                                 *##

         -Miranda Chaiken '16

         ***/
