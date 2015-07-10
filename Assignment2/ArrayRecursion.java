//Chance Grillot

public class ArrayRecursion {

	public static void main(String[] args) {

		int[] test = { 4, 2, 3, 9, 4, 2, 6, 89, 12, 11 };
		int start = 0;
		int check = countElements(test, start);
		System.out.println("There are " + check
				+ " numbers divisible by three in your current array");
	}

	// Wrapping Method
	public static int countElements(int[] array, int position) {
		return countElements(array, position, 0);
	}

	// Method used to calculate numbers divisible by 3
	private static int countElements(int[] array, int position, int sum) {
		// Checks to see if array has at least one element
		if (array.length < 1) {
			return 0;
		}
		// Check to see if all elements have been checked
		if (array[position] == array.length - 1) {
			sum = countElements(array, position);
		}
		// Checks to see if element is divisible by 3
		else if ((array[position] % 3) == 0) {
			sum = 1 + countElements(array, ++position);
		} else {
			++position;
		}
		return sum;
	}

}