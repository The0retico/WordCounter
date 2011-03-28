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

	/**
	 * @param wordFactory
	 *            alphabet abstraction for creating words of symbol indexes.
	 */
	public TrieFrequencyTable(final Alphabet wordFactory) {
		super(wordFactory);
	}

	@Override
	protected final void addOccouranceOf(final Word word) {
		throw new UnsupportedOperationException();
	}

	@Override
	public final ImmutableMap<Word, Integer> frequent(final int times) {
		Preconditions.checkArgument(times >= 0);
		return ImmutableMap.of();
	}

}
