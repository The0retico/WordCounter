package sk.the0retico.textsearch;

import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

/**
 * @author The0retico
 * 
 *         Frequency table using the trie data structure.
 * 
 */
public class TrieFrequencyTable implements IFrequencyTable {

	private final class TrieNode {

		private final TrieNode[] children = new TrieNode[sigma];
		private Integer occourances = 0;

		public void add(final UnmodifiableIterator<Integer> symbols) {
			if (symbols.hasNext()) {
				final Integer symbol = symbols.next();
				if (children[symbol] == null) {
					children[symbol] = new TrieNode();
				}
				children[symbol].add(symbols);
			} else {
				occourances++;
			}
		}

		public ImmutableMap<UnmodifiableIterator<Integer>, Integer> frequent(
				final int times) {
			Preconditions.checkArgument(times > 0);
			final ImmutableMap.Builder<UnmodifiableIterator<Integer>, Integer> result = ImmutableMap
					.builder();
			for (int symbol = 0; symbol < children.length; symbol++) {
				if (children[symbol] != null) {
					final ImmutableMap<UnmodifiableIterator<Integer>, Integer> tailFrequencies = children[symbol]
							.frequent(times);
					for (final Entry<UnmodifiableIterator<Integer>, Integer> entry : tailFrequencies
							.entrySet()) {
						final Iterator<Integer> symbols = Iterators.concat(
								Iterators.singletonIterator(symbol),
								entry.getKey());
						result.put(Iterators.unmodifiableIterator(symbols),
								entry.getValue());
					}
				}
			}
			if (occourances >= times) {
				final UnmodifiableIterator<Integer> empty = Iterators
						.emptyIterator();
				result.put(empty, occourances);
			}
			return result.build();
		}
	}

	private final Integer sigma;

	private final TrieNode root;

	/**
	 * @param alphabetSize
	 *            exclusive upper bound for word symbols
	 */
	public TrieFrequencyTable(final Integer alphabetSize) {
		sigma = alphabetSize;
		root = new TrieNode();
	}

	@Override
	public final void add(final Word word) {
		final UnmodifiableIterator<Integer> symbols = Iterators
				.unmodifiableIterator(word.iterator());
		root.add(symbols);
	}

	@Override
	public final ImmutableMap<Word, Integer> frequent(final int times) {
		Preconditions.checkArgument(times > 0);
		final ImmutableMap.Builder<Word, Integer> result = ImmutableMap
				.builder();
		for (final Entry<UnmodifiableIterator<Integer>, Integer> entry : root
				.frequent(times).entrySet()) {
			final UnmodifiableIterator<Integer> symbols = entry.getKey();
			final Integer occourances = entry.getValue();
			result.put(new Word(symbols), occourances);
		}
		return result.build();
	}

}
