package sk.the0retico.textsearch;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

/**
 * @author The0retico
 * 
 *         Alphabet representation which allows creation of valid words from
 *         symbol indexes.
 * 
 */
public class Alphabet {

	/**
	 * @param size
	 *            of the alphabet (exclusive upper bound for symbol indexes)
	 * @return predicate checking validity of symbol indexes
	 */
	private static Predicate<Integer> createSymbolValidator(final int size) {
		return new Predicate<Integer>() {

			@Override
			public boolean apply(final Integer value) {
				return value >= 0 && value < size;
			}
		};
	}

	/**
	 * Predicate for validating symbol indexes.
	 */
	private final Predicate<Integer> isSymbolValid;

	/**
	 * @param size
	 *            in this alphabet (upper exclusive bound for symbols indexes).
	 */
	public Alphabet(final int size) {
		isSymbolValid = createSymbolValidator(size);
	}

	/**
	 * @param symbols
	 *            as integer indexes
	 * @return sanitized word created from symbols
	 */
	public final Word createWord(final Integer... symbols) {
		final UnmodifiableIterator<Integer> arguments = Iterators
				.forArray(symbols);
		Preconditions.checkArgument(Iterators.all(arguments, isSymbolValid));
		return new Word(symbols);
	}
}
