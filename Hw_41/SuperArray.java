/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/*
  Johnny Wong
  APCS1 pd 8
  HW41 -- Array of Steel
  2017-11-28
 */

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
      _size = 10;
      _data = new int[_size];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
      String array = "[";
      for (int num: _data){
	  array += num + ",";
      }
      return array.substring(0,array.len-1) + "]";
  }


  //double capacity of SuperArray
  private void expand()
  {
      _size *= 2;
      _data = new int[_size];
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
      int old = _data[index];
      _data[index] = newVal;
      return old;
      
  }


  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }
  }//end main()


}//end class
