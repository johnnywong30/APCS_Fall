// Johnny Wong
// APCS1 pd8
// HW47 - ascending
// 2017-12-05

/*=====================
  Implement class OrderedArrayList, a wrapper class for ArrayList 
  maintaining the invariant that its elements are sorted.
  ====================*/

import java.util.ArrayList;

public class OrderedArrayList{

    // inst vars
    private ArrayList<Comparable> _data;

    // default constructor
    public OrderedArrayList(){
	_data = new ArrayList<Comparable>();
    }

    // overloaded constructor
    public OrderedArrayList(int capacity){
	_data = new ArrayList<Comparable>(capacity);
    }

    // be able to return String interpretation of _data
    public String toString(){
	return _data.toString();
    }

    // return a Comparable at inputted index
    public Comparable get(int index){
	return _data.get(index);
    }

    // removes a Comparable at inputted index
    // returns removed Comparable
    public Comparable remove(int index){
	Comparable temp = get(index);
	_data.remove(index);
	return temp;
    }

    // returns size of _data
    public int size(){
	return _data.size();
    }

    // return boolean of whether _data is sorted in ascending order
    public boolean isAscending(){
	for (int i = 1; i < size(); i++){
	    if (get(i - 1).compareTo(get(i)) > 0){
		return false;
	    }
	}
	return true;
    }

    // add a Comparable to the end of _data
    // return true
    public boolean add(Comparable newVal){
	return _data.add(newVal);
    }

    // add a Comparable to the specified index
    public void add(int index, Comparable newVal){
	_data.add(index, newVal);
    }

    // return location of first instance of smallest value of the OrderedArrayList
    public int minDex(){
	Comparable min = get(0);
	int minDex = 0;
	for (int i = 0; i < size(); i++){
	    Comparable next = get(i);
	    if (min.compareTo(next) > 0){
		min = next;
		minDex = i;
	    }
	}
	return minDex;
    }
    // return smallest value of the OrderedArrayList
    public Comparable min(){
	return get(minDex());
    }

    // sorts _data to be in ascending order
    public void sort(){
	// instance of OrderedArrayList with same capacity of this OrderedArrayList
	OrderedArrayList sorted = new OrderedArrayList(size());
	OrderedArrayList temp = this; // copy of current OrderedArrayList
	
	int length = size(); // the number of items OrderedArrayList sorted must reach
	
	while (sorted.size() < length){
	    sorted.add(temp.min()); // add the smallest value of the current OrderedArrayList temp to OrderedArrayList sorted
	    temp.remove(temp.minDex()); // remove the smallest value of OrderedArrayList temp
	}
	// replace current ArrayList with sorted version
	this._data = sorted._data;
	
    }

    // adds a newVal to this OrderedArrayList while mainting ascending order
    public void addLinear(Comparable newVal){
	this.add(newVal);
	this.sort();
    }


    public static void main(String [] args){
	// create an instance of OrderedArrayList with capacity for 23 Comparables
	OrderedArrayList poo = new OrderedArrayList(23);
	// populate poo with random ints in range [0,30)
	for (int i = 0; i < 23; i++){
	    poo.add( (int) (30 * Math.random()));
	}
	
	System.out.println("This is OrderedArrayList poo...");
	System.out.println(poo.toString() + "\n");
	System.out.println("Is OrderedArrayList poo sorted? " + poo.isAscending());
	
	// will sort if poo is not sorted
	if (! poo.isAscending()){
	    System.out.println("Post sort...");
	    // testing sort method
	    poo.sort();
	    System.out.println(poo.toString());
	}
	
	System.out.println("\nThis is OrderedArrayList poo after adding 12...");
	poo.addLinear(12);
	System.out.println(poo.toString());
    } // end of main
    
} // end of OrderedArrayList
