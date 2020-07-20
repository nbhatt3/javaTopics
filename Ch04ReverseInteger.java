// reverse an integer

package javaQuestions;

public class Ch04ReverseInteger {

	public static void main(String[] args) {
		
		System.out.println(reverseInt(54673));

	}

	public static long reverseInt(int input) {
		long reversed =0;
		while (input!=0) {
			reversed = reversed *10+ input %10;
			input /= 10;
			if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
				return 0;
			}
		}
		return reversed;
	}

}
