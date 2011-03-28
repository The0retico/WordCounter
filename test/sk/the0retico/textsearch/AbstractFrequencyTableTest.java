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

import com.google.common.collect.ImmutableMap;

/**
 * @author The0retico
 * 
 *         Contract test for IFrequencyTable implementations.
 */
public abstract class AbstractFrequencyTableTest {

	/**
	 * Set up the alphabet for creating words.
	 */
	@BeforeClass
	public static final void setUpBeforeClass() {
		final int numberOfSymbols = 2;
		alphabet = new Alphabet(numberOfSymbols);
	}

	/**
	 * IFrequencyTable implementation instance to be tested.
	 */
	private IFrequencyTable table;

	/**
	 * Alphabet used to create words in this test.
	 */
	private static Alphabet alphabet;

	/**
	 * @param alphabet
	 *            which creates valid words from symbol indexes
	 * @return implementation of the word frequency table for testing
	 */
	protected abstract IFrequencyTable getImplementation(Alphabet alphabet);

	/**
	 * Set up implementation of the IFrequencyTable for testing.
	 */
	@Before
	public final void setUp() {
		table = getImplementation(alphabet);
	}

	/**
	 * The frequency table righ after creation should be empty.
	 */
	@Test
	public final void shouldBeEmptyAfterCreation() {
		final ImmutableMap<Word, Integer> emptyMap = ImmutableMap.of();
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(0);
		assertThat(wordFrequencies, is(notNullValue()));
		assertThat(wordFrequencies, is(equalTo(emptyMap)));
	}

	/**
	 * When you add one word, the frequency table should contain one entry.
	 */
	@Test
	public final void shouldHaveOneEntryAfterAddingOneWord() {
		table.add(0, 1, 0, 0);
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(0);
		assertNotNull(wordFrequencies);
		assertFalse(wordFrequencies.isEmpty());
		assertEquals(1, wordFrequencies.entrySet().size());
		final Word word = alphabet.createWord(0, 1, 0, 0);
		assertTrue(wordFrequencies.containsKey(word));
		assertTrue(wordFrequencies.containsValue(1));
		assertEquals(wordFrequencies, table.frequent(1));
	}
}
