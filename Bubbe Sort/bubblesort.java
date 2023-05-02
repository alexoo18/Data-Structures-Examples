import java.util.Random;

public class bubblesort {
	
	public static final int ARRAY_SIZE = 100;								// Array size 
	
	public void bubble_Sort(int arr[]) { 									// Bubble sort algorithm taken from geeksforgeeks.com 
		int n = arr.length - 1; 						    				// https://www.geeksforgeeks.org/bubble-sort/
		
		for (int i = 0; i < n; i++) { 			
            for (int j = 0; j < n-i; j++) { 
                if (arr[j] > arr[j+1]) { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
            }
		}  
    }
	
															 
	public static int random_numbers(int min, int max) {					// Random number generator 
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	static void print_array(int arr[]){										// Prints arrays in format
	        int n = arr.length;
	        
	        for (int i = 0; i < n; ++i) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	}
	

	static boolean sorted(int[] array) {									// method taken from: 
	    for (int i = 0; i < array.length - 1; i++) {						// https://www.baeldung.com/java-check-sorted-array
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {								// main method 
		System.out.println("Bubble sort algorithm.");
		System.out.println();
		
		int random_array[];
		random_array = new int[ARRAY_SIZE];
		
		int sorted_array[];
		sorted_array = new int[ARRAY_SIZE];
		
		int reversed_array[];
		reversed_array = new int[ARRAY_SIZE];
		

		for(int i = 0; i < random_array.length; i++) {						// random numbers array
			random_array[i] = random_numbers(1, random_array.length);
		}
		
		System.out.println("The array of random numbers: "); 				// prints out random number array 
		print_array(random_array);
		System.out.println();
	
		for(int i = 0; i < sorted_array.length; i++) {						// sorted array
			if(i <= (ARRAY_SIZE - 6)) {
				sorted_array[i] = random_numbers(i, i + 5);
			} else {
				sorted_array[i] = random_numbers(i - 3, i);
			}
		}
		
		System.out.println("Sorted array: "); 
		print_array(sorted_array);
		System.out.println(); 												// prints out the array 
		
		int j = 0;															// reverse array 
		
		for(int i = reversed_array.length; i > 0; i--) {
			reversed_array[j] = i;
			j++;
		}
		
		System.out.println("Reverse array: "); 								
		print_array(reversed_array);
		System.out.println(); 												// prints out the array 
		
		bubblesort ob = new bubblesort();
		
		long start_time = System.nanoTime();
        ob.bubble_Sort(random_array);
        long end_time = System.nanoTime();
        System.out.println("Random array took " + 
        ((end_time - start_time)) + " nanoseconds");						// time check 
        
        long start_time2 = System.nanoTime();
        ob.bubble_Sort(sorted_array);
        long end_time2 = System.nanoTime();
        System.out.println("Sorted array took " +
        ((end_time2 - start_time2)) + " nanoseconds");						// time check 
        
        long start_time3 = System.nanoTime();
        ob.bubble_Sort(reversed_array);
        long end_time3 = System.nanoTime();
        System.out.println("Reverse took " + 
        ((end_time3 - start_time3)) + " nanoseconds");						// time check 
       
        assert sorted(random_array);
        assert sorted(sorted_array);
        assert sorted(reversed_array);
	}
}