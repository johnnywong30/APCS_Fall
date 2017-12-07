/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

// Johnny Wong
// APCS1 pd8
// HW48 - Keep Guessing
// 2017-12-06


import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre: instance vars are not initialized   
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	//_target = 38; // follow the model
	_target = (int) (Math.random() * _hi + _lo); // target is in range [_lo, _hi]
	
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  instance of Keyboard is created
            user inputs an int, and continues until it matches the target
      post: prints out String containing number of guesses user took
      ==================================================*/
    public void playRec() 
    {
    	Keyboard input = new Keyboard();
    	System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	int guess = input.readInt();
	if (guess == _target){
	    System.out.println("Correct! It took " + _guessCtr + " guesses");
	    return;
	}
	else if (guess > _hi || guess < _lo){ // provides safety for if user is incompentent and unable to follow directive
	    System.out.println("You have inputted a value outside of provided range. Please try again!");
	}
	else if (guess > _target){
	    _hi = guess - 1; // upper bound set to include the guessed value minus 1
	    System.out.println("Too high...");
	    _guessCtr++; //guess count increments by 1
	}
	else if (guess < _target){
	    _lo = guess + 1; // lower bound set to include the guessed value plus 1
	    System.out.println("Too low...");
	    _guessCtr++; //guess count increments by 1
	}
        this.playRec();
	
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  instance of Keyboard is created
            user inputs an int, and continues until it matches the target
      post: prints out String containing number of guesses user took
      ==================================================*/
    public void playIter() 
    {
	Keyboard input = new Keyboard();
	int guess = 0;
	while (guess != _target){
	    System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	    guess = input.readInt();
	    if (guess > _hi || guess < _lo){ // provides safety for if user is incompentent and unable to follow directive
		System.out.println("You have inputted a value outside of provided range. Please try again!");
	    }
	    else if (guess > _target){
		_hi = guess - 1; // upper bound set to include the guessed value minus 1
		System.out.println("Too high...");
		_guessCtr++; // guess count increments by 1
	    }
	    else if (guess < _target){
		_lo = guess + 1; // lower bound set to include the guessed value plus 1
		System.out.println("Too low...");
		_guessCtr++; //guess count increments by 1
	    }
	}
	System.out.println("Correct! It took " + _guessCtr + " guesses");
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playIter(); // I figured out the iteration first since it's easier to think about for me
	playRec();    // but I prefer thinking recursively - but this case is different since you're not literally passing a "smaller case" to the method.
	              // Instead the instance of GuessNumber's instance variables are being changed and are used over and over, as the range gets to be a "smaller case"
	              // with each guess the user makes
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();
    }//end main

}//end class
