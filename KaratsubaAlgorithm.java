// programmer : Sakshyam Dahal
// Karatsuba Method for multiplication
//


package practice.edu;

public class KaratsubaAlgorithm {

	public static void main(String[] args) {
		
		// test case
		System.out.println(multiply(12345,67891));

	}
	
	// method to calculate the product
	public static long multiply(long x, long y)
	{
		// get the length of each number
		int lenOfX = getLength(x);
		int lenOfY = getLength(y);
		
		// calculate maximum length
		int maxLength = Math.max(lenOfX, lenOfY);
		
		// base case
		if (lenOfX < 2 || lenOfY < 2)
			return x * y;
		
		int n = (int) Math.ceil(maxLength / 2.0);
		long m = (long) Math.pow(10, n);
		
		// calculate sub expression
		long a = x / m;
		long b = (x - a*m);
		long c = y / m;
		long d = (y - c*m);
		
		// recursive multiplications
		long ac = multiply(a,c);
		long bd = multiply(b,d);
		long mid = multiply(a+b, c+d);
		
		return (long) Math.pow(10, 2*n) * ac + m*(mid - ac -bd) + bd;
		
	}
	
	// method to get the length of a long number
	public static int getLength(long number)
	{
		return number > 0 ? (int) Math.log10(number) + 1 : 1;
	}
		

}
// Karatsuba method reduces a bigger multiplication to 3 smaller multiplications in each run.
// the complexity of algorithm is n^(log 3) (Knuth 1998)