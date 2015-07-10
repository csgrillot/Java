//Chance Grillot
//CS 111
//Assignment 3

import java.util.Calendar;

public class Person implements Comparable, Cloneable {

    private String firstName;
    private String lastName;
    private Date dob;
    
    //Test
/*    public static void main(String[] args) {
        Person p = new Person();
        Person p2 = (Person)p.clone();
        System.out.println(p.getAge());
        p.printPerson();
        p.changeLastName("Test");
        System.out.println(p.compareTo(17));
        System.out.println(p.equals(p2));
        System.out.println(p.toString());
        p.printPerson();
        Student A = new Student();
        Student B = new Student("First","Last", new Date(2,3,4), 3.2, 7008, new Teacher());
        Student C = new Student();
        A.setGPA(3.5);
        System.out.println(A.toString());
        System.out.println(A.equals(B));
        System.out.println(A.equals(B));
  }
*/
    
    // Null Constructor
    Person() {
        firstName = "AAAA";
        lastName = "BBBB";
        dob = new Date();
    }

    //Person Constructor
    Person(String firstName, String lastName, Date dob) {
        // Get Input
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
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
    public int getAge() {
        int age;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Date currentDate = new Date(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH), 
                Calendar.getInstance().get(Calendar.YEAR));
        // Checks if birth month is before current year
        if (currentDate.before(dob) == true) {
            age = currentYear - dob.getYear() - 1;
        } else {
            age = currentYear - dob.getYear();
        }
        return age;
    }

    // Change Last name Method
    public void changeLastName(String s) {
        lastName = s;
    }

    // Override Methods
    // CompareTo Method
    @Override
    public int compareTo(Object a1) {
        int x;

        int other = (int) a1;
        if (other == getAge())
            x = 0;
        else if (other < getAge())
            x = -1;
        else
            x = 1;
        return x;
    }

    // Equals Method
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person newp = (Person) o;
            return (this.firstName == newp.firstName
                    && this.lastName == newp.lastName && this.dob == newp.dob);
        } else {
            return false;
        }
    }

    // Clone Method
    @Override
    public Object clone() {
        Object cloned = new Person(this.firstName, this.lastName, this.dob);
        return cloned;
    }

    // To String Method
    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLastName: " + lastName
                + "\nDateOfBirth: " + dob;
    }

    // Print Person Method
    public void printPerson() {
        System.out.print(firstName + " " + lastName + " was born on ");
        dob.printdate2();
        System.out.println();
    }

}
