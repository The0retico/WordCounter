package sk.the0retico.textsearch;


public class Word implements Comparable<Word> {

	private final Integer[] symbols;

	public Word(final Integer... symbols) {
		this.symbols = symbols;
	}

	@Override
	public int compareTo(final Word other) {
		final int difference;
		if (symbols.length == other.symbols.length) {
			int index = 0;
			while (symbols[index] == other.symbols[index]
					&& index < symbols.length) {
				index++;
			}
			if (index == symbols.length) {
				difference = 0;
			} else {
				index--;
				difference = symbols[index] - other.symbols[index];
			}
		} else {
			difference = other.symbols.length - symbols.length;
		}
		return difference;
	}
}
