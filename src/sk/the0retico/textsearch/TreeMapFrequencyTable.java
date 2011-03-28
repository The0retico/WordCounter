package sk.the0retico.textsearch;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class TreeMapFrequencyTable implements IFrequencyTable {

	private final Map<Word, Integer> table;

	public TreeMapFrequencyTable() {
		table = Maps.newTreeMap();
	}

	@Override
	public void add(final int... word) {
		// TODO Auto-generated method stub

	}

	@Override
	public ImmutableMap<Word, Integer> frequent(final int times) {
		return ImmutableMap.copyOf(table);
	}

}
