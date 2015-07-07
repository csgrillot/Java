import java.util.Calendar;

public class Person implements Comparable, Cloneable {

	private String firstName;
	private String lastName;
	private Date dob;

	// Null Constructor
	Person() {
		firstName = "AAAA";
		lastName = "BBBB";
		dob = new Date();
	}

	// Person Constructor
	Person(String first, String last, Date dob) {
		first = getFirst();
		last = getLast();
		dob = getDOB();
	}

	// Accessors
	public Date getDOB() {
		return dob;
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	
	//Get Age Method
	public static int getAge(){
		int age;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		return 0;
	}

	//Change Last name Method
	public static String changeLastName(String s){
		
		return "";
	}
	
//Override Methods

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
