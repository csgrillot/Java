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
		    	
		        Scanner sc = new Scanner( new File( "C:/Users/Chance/Downloads/grades(1).csv")) ;
		        Student[] students = new Student[10];
		        int counter = 0;
		        while ( sc.hasNext() ){
		        String a = sc.nextLine();
		        String [] arr = a.split(", ");
		        int [] grades = new int[10];
		        int stdNum = Integer.parseInt(arr[0]);
		        for( int i = 1 ; i < arr.length; i ++){
		            int value = Integer.parseInt( arr[i]);
		            System.out.println(value);
		            grades[i-1] = value;
		        }
		        Student s = new Student( stdNum , grades);
		        students[counter] = s;
		        counter++;
		        System.out.println(Arrays.toString(grades));
		        }    
		        PrintWriter p = new PrintWriter( "abc.txt");
		        p.write("Hello");
		        
		} catch( FileNotFoundException e){
		        }
		    
		    }
		}