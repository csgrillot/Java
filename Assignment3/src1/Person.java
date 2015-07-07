package lab3;

import java.util.Calendar;

public class Person implements Comparable, Cloneable {

	private String firstName;
	private String lastName;
	private Date dob = new Date();

	// Null Constructor
	Person() {
		firstName = "AAAA";
		lastName = "BBBB";
	}

	// Person Constructor
	Person(String first, String last, int DOBd, int DOBm, int DOBy) {
		// Get Input
		firstName = first;
		lastName = last;
		dob = new Date(DOBd, DOBm, DOBy);
		getAge();
	}

	// Accessors
	public Date getDOB() {
		dob.printdate2();
		return dob;
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	// Get Age Method
	public static int getAge() {
		int age;
		Date currentDate = Calendar.getInstance().getTime();
		System.out.println(currentDate);

		return age;
	}

	// Change Last name Method
	public static String changeLastName(String s) {

		return "";
	}

	// Override Methods

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
