//Johnny Wong
//APCS1 pd 8
//HW 36 -- Be Rational
//2017-11-18

public class Rational{
    // inst vars
    private int p; // numerator
    private int q; // denominator
    // default constructor
    public Rational(){
	p = 0;
	q = 1;
    }
    // constructor
    public Rational(int n, int d){
	this();
	if (d == 0){
	    System.out.println("Invalid denominator");
	}
	else{
	    p = n;
	    q = d;
	}
    }
    // methods


    // returns this Rational to be interpretted as a String
    public String toString(){
	return p + " / " + q;
    }

    // returns the precise floating point approximated value of this Rational
    public double floatValue(){
	return (double) p / q;
    }

    // multiplies the numerator and denominator of this Rational by the inputted Rational's numerator and denonimator
    public void multiply(Rational num){
	p *= num.p;
	q *= num.q;
    }

    // divides the numerator and denominator of this Rational by the inputted Rational's numerator and denonimator
    public void divide(Rational num){
	p /= num.p;
	q /= num.q;
    }

    // recursively finds the gcd between two inputted ints
    public static int gcd(int a, int b){
	if (a % b == 0){
	    return b;
	}
	return gcd(b, a % b);
    }

    // adds inputted Rational to this Rational, creating a common denominator if necessary
    public void add(Rational num){
	if (q == num.q){
	    p += num.p;
	}
	else{
	    int temp = q;
	    p *= num.q;
	    q *= num.q;
	    num.p *= temp;
	    num.q *= temp;
	    p += num.p;
	}
    }

    // subtracts inputted Rational to this Rational, creating a common denominator if necessary
    public void subtract(Rational num){
	if (q == num.q){
	    p -= num.p;
	}
	else{
	    int temp = q;
	    p *= num.q;
	    q *= num.q;
	    num.p *= temp;
	    num.q *= temp;
	    p -= num.p;
	}
    }

    // uses helper function gcd(int a, int b) to return the gcd of this Rational
    public int gcd(){
	return gcd(p,q);
    }

    // changes this Rational to one in reduced form using gcd()
    public void reduce(){
	int gcd = gcd();
	p /= gcd;
	q /= gcd;
    }
    
    // Takes a Rational parameter and compares it to the calling object
    // Returns 0 if the two numbers are equal
    // Returns a positive integer if the calling number is larger than the parameter
    // Returns a negative integer if the calling number is smaller than the parameter
    public int compareTo(Rational num){
        Rational temp = new Rational(this.p, this.q);
        temp.subtract(num);
        return temp.p;
    }
    
    public static void main(String [] args){
	// Rational Day 1
	Rational zero = new Rational(0,0);
	Rational r = new Rational(2,3); // stores rational number 2/3
	Rational s = new Rational(1,2); // stores rational number 1/2
	System.out.println(zero.toString()); // prints out 0/1
	System.out.println();
	System.out.println(r.toString()); // prints out 2/3
	System.out.println(s.toString()); // prints out 1/2
	System.out.println();	
	System.out.println("Testing floatValue...");
	System.out.println(r.floatValue()); // prints out 0.666666666...
	System.out.println();
	System.out.println("Testing multiply and divide...");
	System.out.println();
	r.multiply(s);
	System.out.println(r.toString()); // prints out 2/6
	System.out.println();
	r.divide(s);
	System.out.println(r.toString()); // prints out 2/3
	System.out.println("========================================");
	// Rational Day 2
	Rational t = new Rational(3,5);
	Rational u = new Rational(6,10);
	Rational v = new Rational(4,10);
	Rational w = new Rational(3,5);
	Rational x = new Rational(8,10);
	System.out.println("Testing add...");
	t.add(u);
	System.out.println(t.toString()); // prints out 60/50 -> same as 6/5;
	System.out.println("Testing subtract...");
	t.subtract(v);
	System.out.println(t.toString()); // prints out 400/500 -> same as 4/5;
	System.out.println("Testing gcd()...");
	System.out.println(x.gcd()); // prints out 2
	System.out.println("Testing reduce()...");
	u.reduce();
	System.out.println(u.toString()); // prints out 3/5
	System.out.println("Testing compareTo...");
	System.out.println(u.compareTo(w)); // prints out 0 so u and w are equal
	System.out.println(u.compareTo(v)); // prints out 500 so u > v
	System.out.println(u.compareTo(x)); // prints out -10 so u < x
    }
}
  
