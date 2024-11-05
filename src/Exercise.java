public class Exercise {
    public static void main (String[] args) 
    {
        
    //Creating the array
    int[] numbers = {1, 2, 3, 4, 5};
    
    //Access and Print
    System.out.println("First element: " + numbers[0]);
    System.out.println("Second element: " + numbers[4]);
    
    //Reverse order
    System.out.println("Elements in reverse order: ");
    for (int i = numbers.length - 1; i >= 0; i--){
        System.out.println(numbers[i]);
    }
        
    System.out.println(numbers.length);  
    }
}