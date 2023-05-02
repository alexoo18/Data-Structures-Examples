public class WordFrequency implements Comparable<WordFrequency> {
	private String word;
	private int count;
	
	public WordFrequency(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public int compareTo(WordFrequency other) {
		return count - other.count;
	}
}