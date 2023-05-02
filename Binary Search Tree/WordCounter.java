/**
 * Implements a word frequency counter using a binary search tree and a heap.
 */
import java.util.Comparator;

public class WordCounter {
	
	// declarations 
	private static BST<String, Integer> bst = new BST<String, Integer>();
	private static WordFrequencyComparator comparator = new WordFrequencyComparator();
	private static MaxPQ<String> pq = new MaxPQ<String>(comparator);
	
	// comparing key values 
	static class WordFrequencyComparator implements Comparator<String> {
		@Override
		public int compare(String key1, String key2) {
	
			WordFrequency wf1 = new WordFrequency(key1, bst.get(key1));
			WordFrequency wf2 = new WordFrequency(key2, bst.get(key2));
			return wf1.compareTo(wf2);
		}
	}
	
	public static final int count = 1;

    public static void countWords(String [] words) {

        //Implement your solution here
    	// This code counts the frequency of the words and fill the BST
    	for(int i = 0; i < words.length; i++) {
    		if(bst.contains(words[i])) {
    			int value = bst.get(words[i]);
    			bst.put(words[i], 1 + value);
    		} else {
    			if(words[i].equals("")) {
    				bst.put(words[i], count);
    			}
    		}
    	}
    	
    	// prints outs the result 
    	System.out.println("-------------------------------------------------");
    	System.out.println("| Ascending Order of Word Count -- Alphabetical |");
    	System.out.println("-------------------------------------------------");
    	
    	// words from the input.txt and its frequency in alphabetical order 
    	for (String s : bst.keys()) {
    		System.out.println(s + " --> " + bst.get(s));
    	}
    	
    	//prints out the result 
    	System.out.println();
    	System.out.println("----------------------------------------------");
    	System.out.println("| Decending Order of Word Count -- Frequency |");
    	System.out.println("----------------------------------------------");
    	
    	// list of key in BST
    	Iterable<String> k = bst.keys();
    	
    	// words from the input.txt and its frequency in decending order 
    	for (String key : k) {
    		pq.insert(key);
    	}
    	
    	for (String key : pq) {
    		System.out.println(key + " --> " + bst.get(key));
    	}
    	
    }
    
    // main function
    public static void main(String [] args) {
        String input = "input.txt";
        WordCounter.countWords(InputReader.parseInputFile(input));
    }
}
