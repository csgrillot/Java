import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 

public class GradeBook {
  public static void main( String[] args ){
    
    try{
//Location of File could be different depending on
//which computer is being used. 
      
      Scanner sc = new Scanner( new File( "/Users/jacobtyo/Programming/Chance/Java/EclipseWorkspace/grades(1).csv")) ;
      
      Student[] students = new Student[10];
      int counter = 0;
      while ( sc.hasNext() ){
        String a = sc.nextLine();
        String [] arr = a.split(", ");
        int [] grades = new int[10];
        int stdNum = Integer.parseInt(arr[0]);
        for( int i = 1 ; i < arr.length; i ++){
          int value = Integer.parseInt( arr[i]);
          //System.out.println(value);
          grades[i-1] = value;
        }
        Student s = new Student( stdNum , grades);
        students[counter] = s;
        counter++;
        //System.out.println(Arrays.toString(grades));
      }    
      //System.out.println(students[1]);
      //write student numbers and averages to file
      
      
      //convert string to int
      //String test = students[1].toString();
//int[] test = Integer.parseInt(students[1]);
      //System.out.println(students[1]);
      //System.out.println(Arrays.toString(students[1].getGrades()));
      //System.out.println(students[1].getSNumber());
      
      //double student1avg = ArrayReview.average(Double parseDouble( ));
      
    } catch(FileNotFoundException e){
      System.out.println("The file was not found");
    }
    Scanner input = new Scanner(System.in);
    boolean whilecond = true;
    while (whilecond) {
      System.out.println("Welcome to the Gradebook System!");
      System.out.println("Please select from the following menu: ");
      System.out.println("\t1) Student Grade Search");
      System.out.println("\t2) Student Average Grade");
      System.out.println("\t3) Display All Students and Averages");
      System.out.println("\t4) Write Students and Averages to file");
      System.out.println("\t5) Exit");
      
      String userIn = input.nextLine();
      
      
      
      switch (userIn) {
        case "1":
          //stuff
          System.out.println("This is one");
          break;
        case "2":
          //stuff
          break;
        case "3":
          break;
        case "4":
          break;
        case "5":
          whilecond = false;
          break;
        default:
        System.out.println("Invalid response, please try again");
      }
      
    }
    
  }
  
  private static void writeFile(String filePath){
    
    //PrintWriter p = new PrintWriter( "abc.txt");
     // p.write("Hello");
      
  }
}