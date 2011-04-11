package sk.the0retico.textsearch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;

/**
 * @author The0retico
 * 
 *         Contract test for IFrequencyTable implementations.
 */
public abstract class AbstractFrequencyTableTest extends AbstractBenchmark {

	/**
	 * Set up the alphabet for creating words.
	 */
	@BeforeClass
	public static final void setUpBeforeClass() {
		alphabetSize = 2;
	}

	/**
	 * IFrequencyTable implementation instance to be tested.
	 */
	private IFrequencyTable table;

	/**
	 * Alphabet used to create words in this test.
	 */
	private static Integer alphabetSize;

	/**
	 * @param alphabet
	 *            which creates valid words from symbol indexes
	 * @return implementation of the word frequency table for testing
	 */
	protected abstract IFrequencyTable getImplementation(Integer sigma);

	@Test
	public final void sanitiyTest() {
		final Word firstWord = new Word(
				Iterators.unmodifiableIterator(Iterators.forArray(0, 1, 0)));
		final Word secondWord = new Word(
				Iterators.unmodifiableIterator(Iterators.forArray(0, 0, 1)));
		assertFalse(firstWord.equals(secondWord));
	}

	/**
	 * Set up implementation of the IFrequencyTable for testing.
	 */
	@Before
	public final void setUp() {
		table = getImplementation(alphabetSize);
	}

	@Test
	public final void shouldAddEntryIfAddedDifferentWord() {
		final Word firstWord = new Word(
				Iterators.unmodifiableIterator(Iterators.forArray(0, 1, 0)));
		table.add(firstWord);
		final Word secondWord = new Word(
				Iterators.unmodifiableIterator(Iterators.forArray(0, 0, 1)));
		table.add(secondWord);
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(1);
		assertNotNull("Frequency table should not be null", wordFrequencies);
		assertFalse("Frequency table should not be empty",
				wordFrequencies.isEmpty());
		assertEquals(2, wordFrequencies.entrySet().size());
		assertTrue(wordFrequencies.containsKey(firstWord));
		assertTrue(wordFrequencies.containsKey(secondWord));
		assertEquals(1, wordFrequencies.get(firstWord).intValue());
		assertEquals(1, wordFrequencies.get(secondWord).intValue());
	}

	@Test
	public final void shouldAddOccouranceIfAddedSameWord() {
		final Word word = new Word(Iterators.unmodifiableIterator(Iterators
				.forArray(0, 1, 0)));
		table.add(word);
		table.add(word);
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(2);
		assertNotNull("Frequency table should not be null", wordFrequencies);
		assertFalse("Frequency table should not be empty",
				wordFrequencies.isEmpty());
		assertEquals(1, wordFrequencies.entrySet().size());
		assertTrue(wordFrequencies.containsKey(word));
		assertEquals(2, wordFrequencies.get(word).intValue());
	}

	/**
	 * The frequency table righ after creation should be empty.
	 */
	@Test
	public final void shouldBeEmptyAfterCreation() {
		final ImmutableMap<Word, Integer> emptyMap = ImmutableMap.of();
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(1);
		assertThat(wordFrequencies, is(notNullValue()));
		assertThat(wordFrequencies, is(equalTo(emptyMap)));
	}

	/**
	 * When you add one word, the frequency table should contain one entry.
	 */
	@Test
	public final void shouldHaveOneEntryAfterAddingOneWord() {
		final Word word = new Word(Iterators.unmodifiableIterator(Iterators
				.forArray(0, 1, 0, 0)));
		table.add(word);
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(1);
		assertNotNull("Frequency table should not be null", wordFrequencies);
		assertFalse("Frequency table should not be empty",
				wordFrequencies.isEmpty());
		assertEquals(1, wordFrequencies.entrySet().size());
		assertTrue(wordFrequencies.containsKey(word));
		assertTrue(wordFrequencies.containsValue(1));
		assertEquals(wordFrequencies, table.frequent(1));
	}
}
