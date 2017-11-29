// Team Autoindent
// Aaron Li , Johnny Wong
// APCS1 pd8
// HW42 -- Array of Grade 316
// 2017-11-29

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of meaningful elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
	foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
      if (_size < _data.length){ // if _data is not at maximum capacity
	  if (_size == 1){ // if there is one meaningful element already in _data
	      set(1, newVal);
	  }
	  else if (_size == 0){ // if no meaningfun elements are in _data
	      set(0, newVal);
	  }
	  else{ 
	      set(_size, newVal);
	  }
      }
      else{ // if _data is at maximum capacity
	  this.expand();
	  set(_size, newVal);
      }
      _size += 1; // meaningful item count increments up by 1

  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
      while (index > _data.length - 1){ // if index is greater than the last index available in current array _data
	  this.expand();
      }
      if (_size == 0){
	  set(index, newVal);
      }
      else{
	  int old = 0;
	  int temp = _data[index];
	  _data[index] = newVal;
	  for (int i = index + 1; i < _data.length - 1; i++){ // shifts items who are after inputted index to the right by one position
	      old = _data[i];
	      _data[i] = temp;
	      temp = old;
	  }
      }
      _size += 1; // meaningful item count increments up by 1
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
      _size -= 1; // meaningful item count increments down by 1;
      for (int i = index; i < _data.length - 1; i++){
	  set(i, get(i +1)); // shift items to left by one position left;
      }
      _data[_data.length - 1] = 0; // last item becomes 0;
  }
    


  //return number of meaningful items in _data
  public int size()
  {
      return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
    
    SuperArray curtis = new SuperArray();
    System.out.println( "Printing empty SuperArray curtis..." );
    System.out.println( curtis );

    for( int i = 0; i < curtis._data.length; i++ ) {
	//curtis.set( i, i * 2); // does not work because initialized 0's are meaningless and size does not increase...
	curtis.add( i, i * 2 );
    }

    System.out.println("Printing populated SuperArray curtis...");
    System.out.println(curtis);

    for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println("new length of underlying array: "
                         + curtis._data.length );
    }

    SuperArray mayfield = new SuperArray();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.add(5);
    mayfield.add(4);
    mayfield.add(3);
    mayfield.add(2);
    mayfield.add(1);

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    mayfield.add(3,99);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,88);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
     
  }//end main()


}//end class
