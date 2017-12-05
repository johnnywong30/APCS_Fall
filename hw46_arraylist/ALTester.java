// Johnny Wong
// APCS1 pd 8
// HW 46 -- Al<B> Sorted!
// 2017-12-4

import java.util.ArrayList;

public class ALTester{

    // populates an inputted ArrayList<Comparable> with random integers in range [0,20)
    public static void populateRand(ArrayList<Comparable> arr){
	while (arr.size() < 23){
	    arr.add( (int) (Math.random() * 20));
	}
    }

    // populates an inputted ArrayList<Comparable> with ascending integers starting at 0
    public static void populateAscend(ArrayList<Comparable> arr){
	int ascending = 0;
	while (arr.size() < 23){
	    arr.add(ascending);
	    ascending++;
	}
    }

    // populates an inputted ArrayList<Comparable> with descending integers starting at 0
    public static void populateDescend(ArrayList<Comparable> arr){
	int ascending = 0;
	while (arr.size() < 23){
	    arr.add(ascending);
	    ascending--;
	}
    }
    // populates an inputted ArrayList<Comparable> with the same integer 6
    public static void populateSame(ArrayList<Comparable> arr){
	int ascending = 6;
	while (arr.size() < 23){
	    arr.add(ascending);
	}
    }

    // returns true if inputted ArrayList<Comparable> is in ascending order - otherwise return false
    public static boolean isAscended(ArrayList<Comparable> arr){
	for (int i = 1; i < arr.size(); i++){
	    if ( arr.get(i - 1).compareTo(arr.get(i)) > 0 ){
		return false;
	    }
	}
	return true;
    }

     // returns true if inputted ArrayList<Comparable> is in descending order - otherwise return false
    public static boolean isDescended(ArrayList<Comparable> arr){
	for (int i = 1; i < arr.size(); i++){
	    if ( arr.get(i - 1).compareTo(arr.get(i)) < 0){
		return false;
	    }
	}
	return true;
    }

     // returns true if inputted ArrayList<Comparable> is in ascending order, descending order, or all items are equivalent - otherwise return false;
    public static boolean isSorted(ArrayList<Comparable> arr){
	return isAscended(arr) || isDescended(arr);
    }
    public static void main(String [] args){
	ArrayList<Comparable> boo = new ArrayList<Comparable>(23);
	ArrayList<Comparable> foo = new ArrayList<Comparable>(23);
	ArrayList<Comparable> hoo = new ArrayList<Comparable>(23);
	ArrayList<Comparable> qoo = new ArrayList<Comparable>(23);

	// prior to populating 
	System.out.println("boo: ");
	System.out.println(boo);
	System.out.println("foo: ");
	System.out.println(foo);
	System.out.println("hoo: ");
	System.out.println(hoo);
	System.out.println("qoo: ");
	System.out.println(qoo);
	System.out.println("\n");

	// populating occurs
	populateRand(boo);
	populateAscend(foo);
	populateDescend(hoo);
	populateSame(qoo);

	// after populating
	System.out.println("Post populate...");
	System.out.println("boo: ");
	System.out.println(boo);
	System.out.println("foo: ");
	System.out.println(foo);
	System.out.println("hoo: ");
	System.out.println(hoo);
	System.out.println("qoo: ");
	System.out.println(qoo);
	System.out.println("\n");

	// test on isSorted
	System.out.println("Is boo sorted? " + isSorted(boo));
	System.out.println("Is foo sorted? " + isSorted(foo));
	System.out.println("Is hoo sorted? " + isSorted(hoo));
	System.out.println("Is qoo sorted? " + isSorted(qoo));
    }
}
