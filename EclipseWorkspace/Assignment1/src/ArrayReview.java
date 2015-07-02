//Chance Grillot

public class ArrayReview {
  
  public static void findTwoLargest(int[] array){
    int firstMax = 0;
    int secondMax = 0;
    for (int counter:array){
      if (array.length < 2){
        System.out.println("Array must have a size of at least 2"); 
      }
      else if (array.length >= 2){
        if (firstMax < counter){
          secondMax = firstMax;
          firstMax = counter;
        }else if (secondMax < counter){
          secondMax = counter;
        }
      }
    }
    
    System.out.println("The Two Largest Numbers in the array are: "+firstMax+", and "+secondMax);
  }
  
  public static double getClosestToMean(double [] array2){
    double sum = 0;
    for (int count = 0; count < array2.length; count++){
      double dist = array2[count];
      sum += dist;
    }
    double mean = sum / array2.length; 
    double minDiff = Double.MAX_VALUE;
    double closest = 0;
    for (int count = 0; count < array2.length; count++){
      double dist = array2[count];
      double difference = Math.abs(dist - mean); 
      if ((difference < minDiff) || (difference == minDiff)){
        minDiff = difference;
        closest = dist; 
      }
    }
    System.out.println("The number closest to the mean is "+closest);
    return closest; 
    
  }
  
  
  public static void main(String[] args){
    
    int[] array = {5, 4, 7, 1, 0, 45, 21, 1, 56, 34, 41};
    double[] array2 = {5, 4, 7, 1, 0, 45, 21, 1, 56, 34, 41};
    
    findTwoLargest(array);
    getClosestToMean(array2);
  }
  
  public static int average(int[] inputs){
    int sum = 0;
    for (int count = 0; count < inputs.length; count++){
      int dist = inputs[count];
      sum += dist;
    }
    int mean = sum / inputs.length;
    return mean;
  }
  
}



