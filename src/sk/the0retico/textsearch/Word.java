package sk.the0retico.textsearch;

import com.google.common.base.Preconditions;

/**
 * @author The0retico
 * 
 *         Word representation.
 * 
 */
public class Word implements Comparable<Word> {

	/**
	 * Array of symbol indexes representing this word.
	 */
	private final Integer[] symbols;

	/**
	 * @param word
	 *            represented as an array of symbol indexes
	 */
	public Word(final Integer... word) {
		symbols = word;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public final int compareTo(final Word other) {
		Preconditions.checkNotNull(other);
		final int result;
		final int difference = other.symbols.length - symbols.length;
		if (difference == 0) {
			result = compareToWithSameLength(other);
		} else {
			result = difference;
		}
		return result;
	}

	/**
	 * @param other
	 *            word containing at least index symbols
	 * @param index
	 *            of symbols for this and other word to be compared
	 * @return difference between symbols at index in this and other words
	 */
	private int compareToAt(final Word other, final int index) {
		Preconditions.checkNotNull(other);
		Preconditions.checkElementIndex(index, other.symbols.length);
		return symbols[index].compareTo(other.symbols[index]);
	}

	/**
	 * @param other
	 *            word with same length as this
	 * @return the difference between first non equal symbols of this and other
	 *         word
	 */
	private int compareToWithSameLength(final Word other) {
		Preconditions.checkNotNull(other);
		Preconditions.checkArgument(other.symbols.length == symbols.length);
		final int index = indexOfFirstDifference(other);
		return compareToAt(other, index);
	}

	/**
	 * @param other
	 *            word with at least same length as this
	 * @return index of first symbol in other word not equal to symbol in this
	 *         word at the same index or the last index
	 */
	private int indexOfFirstDifference(final Word other) {
		Preconditions.checkNotNull(other);
		Preconditions.checkArgument(other.symbols.length >= symbols.length);
		int index = 0;
		int difference = compareToAt(other, 0);
		while (difference == 0 && index + 1 < symbols.length) {
			difference = compareToAt(other, index + 1);
			index++;
		}
		return index;
	}
}
