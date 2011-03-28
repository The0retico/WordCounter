package sk.the0retico.textsearch;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author The0retico
 * 
 *         Frequency table implementation using java.lang.TreeMap.
 * 
 */
public class TreeMapFrequencyTable extends AbstractFrequencyTable {

	/**
	 * This frequency table state.
	 */
	private final Map<Word, Integer> table;

	/**
	 * Create new empty frequency table.
	 * 
	 * @param wordFactory
	 *            for creating words
	 */
	public TreeMapFrequencyTable(final Alphabet wordFactory) {
		super(wordFactory);
		table = Maps.newTreeMap();
	}

	@Override
	protected final void addOccouranceOf(final Word word) {
		final int numberOfOccourances;
		if (table.containsKey(word)) {
			numberOfOccourances = table.get(word);
		} else {
			numberOfOccourances = 0;
		}
		table.put(word, numberOfOccourances + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sk.the0retico.textsearch.IFrequencyTable#frequent(int)
	 */
	@Override
	public final ImmutableMap<Word, Integer> frequent(final int times) {
		Preconditions.checkArgument(times >= 0);
		return ImmutableMap.copyOf(table);
	}

}
