package sk.the0retico.textsearch;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * @author The0retico
 * 
 *         Frequency table using the trie data structure.
 * 
 */
public class TrieFrequencyTable extends AbstractFrequencyTable implements
		IFrequencyTable {

	private Word word;

	/**
	 * @param wordFactory
	 *            alphabet abstraction for creating words of symbol indexes.
	 */
	public TrieFrequencyTable(final Integer alphabetSize) {
		super(alphabetSize);
	}

	@Override
	protected final void addOccouranceOf(final Word word) {
		this.word = word;
	}

	@Override
	public final ImmutableMap<Word, Integer> frequent(final int times) {
		Preconditions.checkArgument(times >= 0);
		if (word != null) {
			return ImmutableMap.of(word, 1);
		} else {
			return ImmutableMap.of();
		}
	}

}
