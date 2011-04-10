package sk.the0retico.textsearch;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

public class Word implements Comparable<Word> {

	private final ImmutableList<Integer> symbols;

	private static final Ordering<Iterable<Integer>> SYMBOL_ORDERING = Ordering
			.natural().lexicographical();

	private static final Equivalence<Iterable<Integer>> SYMBOL_EQUIVALENCE = Equivalences
			.pairwise(Equivalences.equals());

	public Word(final ImmutableList<Integer> word) {
		symbols = word;
	}

	@Override
	public int compareTo(final Word other) {
		return SYMBOL_ORDERING.compare(symbols, other.symbols);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Word)) {
			return false;
		}
		final Word other = (Word) obj;
		if (symbols == null) {
			if (other.symbols != null) {
				return false;
			}
		} else if (!SYMBOL_EQUIVALENCE.equivalent(symbols, other.symbols)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return SYMBOL_EQUIVALENCE.hash(symbols);
	}

}
