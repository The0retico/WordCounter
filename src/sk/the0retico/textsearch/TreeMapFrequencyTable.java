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
public class TreeMapFrequencyTable implements IFrequencyTable {

	/**
	 * This frequency table state.
	 */
	private final Map<Word, Integer> table;

	/**
	 * Create new empty frequency table.
	 */
	public TreeMapFrequencyTable() {
		table = Maps.newTreeMap();
	}

	@Override
	public void add(final int... word) {
		throw new UnsupportedOperationException();
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
