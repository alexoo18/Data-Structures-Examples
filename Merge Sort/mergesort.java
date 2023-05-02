import java.util.Random;

public class mergesort{
	
	public static final int ARRAY_SIZE = 20000;							// array size 

	void merge(int arr[], int l, int m, int r) {						// merge sort method taken from
        int n1 = m - l + 1;												// https://www.geeksforgeeks.org/merge-sort/
        int n2 = r - m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
        	L[i] = arr[l + i];
        }
        
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
            	arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {	
    	if (l < r) {
            int m = (l + r) / 2;
            
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void print_array(int arr[]) {									// prints array in format 
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
        	System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int random_numbers(int min, int max) {					// random number generator 
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
    
    static boolean sorted(int[] array) {									// method taken from 
	    for (int i = 0; i < array.length - 1; i++) {						// https://www.baeldung.com/java-check-sorted-array
	        if (array[i] > array[i + 1]) {
	            return false;
	        }
	    }
	    return true;
	}


    public static void main(String args[]) {								// main method
    	System.out.println("Merge sort algorithm.");
    	System.out.println();
    	
    	int random_array[];
		random_array = new int[ARRAY_SIZE];
		
		int sorted_array[];
		sorted_array = new int[ARRAY_SIZE];
		
		int reversed_array[];
		reversed_array = new int[ARRAY_SIZE];
		        

		for(int i = 0; i < random_array.length; i++) {						// random number array 
			random_array[i] = random_numbers(1, random_array.length);
		}
		
		System.out.println("The array of random numbers: ");
		print_array(random_array);
		System.out.println();												// prints out random number array
		

		for(int i = 0; i < sorted_array.length; i++) {						// sorted number array 
			if(i <= (ARRAY_SIZE - 6)) {
				sorted_array[i] = random_numbers(i, i + 5);
			} else {
				sorted_array[i] = random_numbers(i - 3, i);
			}
		}
		
		System.out.println("Sorted array: "); 							
		print_array(sorted_array);
		System.out.println();												// prints out sorted number array
	
		
		int j = 0;															// reverse number array 
		for(int i = reversed_array.length; i > 0; i--) {
			reversed_array[j] = i;
			j++;
		}
		
		System.out.println("Reverse array: ");
		print_array(reversed_array);
		System.out.println();												// prints out reverse number array 
		
		mergesort ob = new mergesort();
        
		long start_time = System.nanoTime();
		ob.sort(random_array, 0, random_array.length - 1);
		long end_time = System.nanoTime();
        System.out.println("Random array took " + 
		((end_time - start_time)) + " nanoseconds");						// time check 

		
		long start_time2 = System.nanoTime();        
        ob.sort(sorted_array, 0, sorted_array.length - 1);
        long end_time2 = System.nanoTime();
        System.out.println("Sorted array took " + 
        ((end_time2 - start_time2)) + " nanoseconds");						// time check 

        
        long start_time3 = System.nanoTime();
        ob.sort(reversed_array, 0, reversed_array.length - 1);
        long end_time3 = System.nanoTime();       
        System.out.println("Reverse array took " + 
        ((end_time3 - start_time3)) + " nanoseconds");						// time check 

        
        assert sorted(random_array);
        assert sorted(sorted_array);
        assert sorted(reversed_array);
    }
}