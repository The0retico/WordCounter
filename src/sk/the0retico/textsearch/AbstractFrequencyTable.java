package sk.the0retico.textsearch;

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
	private final Alphabet alphabet;

	/**
	 * @param wordFactory
	 *            alphabet which is used to create valid words
	 */
	protected AbstractFrequencyTable(final Alphabet wordFactory) {
		alphabet = wordFactory;
	}

	@Override
	public final void add(final Integer... symbols) {
		final Word word = alphabet.createWord(symbols);
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