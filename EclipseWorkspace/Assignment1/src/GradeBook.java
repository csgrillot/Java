import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GradeBook {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		try {
			// Location of File could be different depending on
			// which computer is being used.

			Scanner sc = new Scanner(
					new File("/Users/jacobtyo/Programming/Chance/Java/EclipseWorkspace/grades(1).csv"));

			int counter = 0;
			while (sc.hasNext()) {
				String a = sc.nextLine();
				String[] arr = a.split(", ");
				int[] grades = new int[10];
				int stdNum = Integer.parseInt(arr[0]);
				for (int i = 1; i < arr.length; i++) {
					int value = Integer.parseInt(arr[i]);
					// System.out.println(value);
					grades[i - 1] = value;
				}
				Student s = new Student(stdNum, grades);
				students[counter] = s;
				counter++;
				// System.out.println(Arrays.toString(grades));
			}
			// sc.close();
			// System.out.println(students[1]);
			// write student numbers and averages to file

			// convert string to int
			// String test = students[1].toString();
			// int[] test = Integer.parseInt(students[1]);
			// System.out.println(students[1]);
			// System.out.println(Arrays.toString(students[1].getGrades()));
			// System.out.println(students[1].getSNumber());

			// double student1avg = ArrayReview.average(Double parseDouble( ));

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}
		boolean whilecond = true;
		Scanner input = new Scanner(System.in);

		while (whilecond) {

			System.out.println("Welcome to the Gradebook System!");
			System.out.println("Please select from the following menu: ");
			System.out.println("\t1) Student Grade Search");
			System.out.println("\t2) Student Average Grade");
			System.out.println("\t3) Display All Students and Averages");
			System.out.println("\t4) Write Students and Averages to file");
			System.out.println("\t5) Exit");

			System.out.print("Selection: ");
			int userIn = input.nextInt();

			int studentID = 0;

			switch (userIn) {
			case 1:
				// stuff
				System.out.println("Enter a Student ID for their grades (1-10)");
				studentID = input.nextInt();
				studentSearch(students, studentID-1);
				// System.out.println("This is one");
				break;
			case 2:
				// stuff
				System.out.println("Enter a Student ID to compute average grade (1-10)");
				studentID = input.nextInt();
				studentAverage(students, studentID-1);
				break;
			case 3:
				displayAverages(students);
				break;
			case 4:
				System.out.println(
						"What would you like to name the output? (it will be written to the working directory) ");
				String filePath = input.next();
				writeFile(students, filePath);
				break;
			case 5:
				whilecond = false;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid response, please try again");
				break;
			}

		}
		input.close();
	}

	private static void writeFile(Student[] s, String filePath) {

		try {
			PrintWriter p = new PrintWriter(filePath + ".txt");
			for (int i = 0; i < s.length; i++){
				int snum = s[i].getSNumber();
				p.write("Student: " + snum + "\tAverage: " + ArrayReview.average(s[i].getGrades()) + "\n");
			}
			p.close();
			System.out.println("Write Successful!");
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		
	}

	private static void studentSearch(Student[] s, int sid) {
		int[] grades = s[sid].getGrades();
		sid = sid + 1;
		System.out.println("The grades for student " + sid + " are: " + Arrays.toString(grades));

		// s[Integer.parseInt(studentID)].getGrades();
		// System.out.println(Arrays.toString(students[Integer.parseInt(studentID)].getGrades()));

	}

	private static void studentAverage(Student[] s, int studentID) {
		int[] grades = s[studentID].getGrades();
		int stid = studentID + 1;
		System.out.println("The average for student " + stid + " is: " + ArrayReview.average(grades));
	}

	private static void displayAverages(Student[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println("Student: " + s[i].getSNumber() + "\tAverage: " + ArrayReview.average(s[i].getGrades()));
		}
	}
}