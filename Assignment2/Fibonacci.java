/**
 * 
 */

/**
 * @author Anon
 *
 */
public class Fibonacci {

	/**
	 * The code below is to illustrate
	 * the difference between recursion and iteration
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//Test Time For Fib25
		long recStartTime25 = System.currentTimeMillis();
		fibonacciRecursive(25);
		long recEndTime25 = System.currentTimeMillis();
	// Rec Time	
		long timeRec25 = recEndTime25 - recStartTime25; 
		System.out.println("Rec Time, Fib 25: \t"+timeRec25);
	//	
		long itStartTime25 = System.currentTimeMillis();
		fibonacciIterative(25);
		long itEndTime25 = System.currentTimeMillis();
	//Iter Time
		long timeIt25 = itEndTime25 - itStartTime25; 
		System.out.println("Iter Time, Fib 25: \t"+timeIt25);
///////////////////////////////////////////////
//////////////////////////////////////////////
		//Test Time For Fib35
				long recStartTime35 = System.currentTimeMillis();
				fibonacciRecursive(35);
				long recEndTime35 = System.currentTimeMillis();
			// Rec Time	
				long timeRec35 = recEndTime35 - recStartTime35; 
				System.out.println("Rec Time, Fib 35: \t"+timeRec35);
			//	
				long itStartTime35 = System.currentTimeMillis();
				fibonacciIterative(35);
				long itEndTime35 = System.currentTimeMillis();
			//Iter Time
				long timeIt35 = itEndTime35 - itStartTime35; 
				System.out.println("Iter Time, Fib 35: \t"+timeIt35);
///////////////////////////////////////////////
///////////////////////////////////////////////
				//Test Time For Fib45
				long recStartTime45 = System.currentTimeMillis();
				fibonacciRecursive(45);
				long recEndTime45 = System.currentTimeMillis();
			// Rec Time	
				long timeRec45 = recEndTime45 - recStartTime45; 
				System.out.println("Rec Time, Fib 45: \t"+timeRec45);
			//	
				long itStartTime45 = System.currentTimeMillis();
				fibonacciIterative(45);
				long itEndTime45 = System.currentTimeMillis();
			//Iter Time
				long timeIt45 = itEndTime45 - itStartTime45; 
				System.out.println("Iter Time, Fib 45: \t"+timeIt45);

	}
	
	public static int fibonacciRecursive(int n)  {
		if( n == 0 )
	    	return 0;
	    else if( n == 1 )
	    	return 1;
	    else
	    	return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}
	
	public static int fibonacciIterative(int n) {
        int first = 0, second = 1, third = 1;
        for (int num = 0; num < n; num++) {
        	first = second;
        	second = third;
        	third = first + second;
        }
        return first;
    }

}