//Chance Grillot

public class Student extends Person {

	private double gpa;
	private int studentID;
	private Teacher advisor;
	
	//Get Student ID
	public int getStudentID(){
		return studentID;
	}
	
	//Set GPA
	public void setGPA(double g){
		gpa = g;
	}
	
	//Get GPA
	public double getGPA(){
		return gpa;
	}
	
	//set Advisor
	public void setAdvisor(Teacher a){
		advisor = a;
	}
	
	//get Advisor
	public Teacher getAdvisor(){
		return advisor;
	}
	
	Student(String firstName, String lastName, Date dob, double gpa, int studentID, Teacher advisor){
		
		super (firstName, lastName, dob);
		this.gpa = gpa;
		this.studentID = studentID;	
		this.advisor = advisor;
	}
	
	Student(String firstName, String lastName, Date dob, int studentId){
		super (firstName, lastName, dob);
		gpa = 0;
		this.studentID = studentID;
		advisor = null;
	}
	
	//Null Constructor
	Student(){
		super();
		gpa = 0;
		studentID = 0;
		advisor = null;
	}
	
//Override Methods	
	// To String Method
	@Override
    public String toString() {
		String s = super.toString();
		return s+"\nGPA: "+gpa+"\nStudent ID: "+studentID+"\nAdvisor: "+advisor;
    }
    
    //Equals to
    @Override
    public boolean equals(Object o){
    	boolean b = super.equals(o);
    	if(b == true){
    		Student stu = (Student)o;
    		return (this.gpa == stu.gpa && this.studentID == stu.studentID && this.advisor == stu.advisor);
    	}
    	else{
    		return false;
    	}
    }
 
}
