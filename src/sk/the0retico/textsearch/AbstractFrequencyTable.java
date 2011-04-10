package sk.the0retico.textsearch;

import com.google.common.base.Preconditions;

/**
 * @author The0retico
 * 
 *         Superclass for implementing different frequency tables.
 * 
 *         Handles the alphabet and symbol validation.
 * 
 */
public abstract class AbstractFrequencyTable implements IFrequencyTable {

	/**
	 * Alphabet which enables creating proper words from symbol indexes.
	 */
	private final Integer sigma;

	/**
	 * @param wordFactory
	 *            alphabet which is used to create valid words
	 */
	protected AbstractFrequencyTable(final Integer alphabetSize) {
		sigma = alphabetSize;
	}

	@Override
	public final void add(final Word word) {
		Preconditions.checkNotNull(word);
		addOccouranceOf(word);
	}

	/**
	 * @param word
	 *            representation created with alphabet
	 * 
	 *            Increases the number of occourances of given word.
	 */
	protected abstract void addOccouranceOf(final Word word);
}