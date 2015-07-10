//Chance Grillot

public class Teacher extends Person {

	private String department;
	
	public String getDepartment(){
		return department;
	}
	
	public String setDepartment(String d){
		department = d;
		return department;
	}
	
	Teacher(String firstName, String lastName, Date dob, String department){
		super(firstName, lastName, dob);
		this.department = department;
	}
	
	Teacher(String firstName, String lastName, Date dob){
		super(firstName, lastName, dob);
		this.department = null;
	}
	
	//Null Constructor
	Teacher(){
		super();
		this.department = null;
	}

//Override Methods
	//To String Method
	@Override
	public String toString(){
		String s = super.toString();
		return s+"\nDepartment: "+department;
	}
	
	@Override
	public boolean equals(Object o){
		boolean b = super.equals(o);
		if (b == true){
			Teacher t = (Teacher) o;
			return (this.department == t.department);
		}else{
			return false;
		}
	}
	
}
