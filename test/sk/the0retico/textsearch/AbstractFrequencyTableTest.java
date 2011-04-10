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

import com.google.common.collect.ImmutableList;
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
	protected abstract IFrequencyTable getImplementation(Integer alphabetSize);

	/**
	 * Set up implementation of the IFrequencyTable for testing.
	 */
	@Before
	public final void setUp() {
		table = getImplementation(alphabetSize);
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
		table.add(new Word(ImmutableList.of(0, 1, 0, 0)));
		final ImmutableMap<Word, Integer> wordFrequencies = table.frequent(0);
		assertNotNull("Frequency table should not be null", wordFrequencies);
		assertFalse("Frequency table should not be empty",
				wordFrequencies.isEmpty());
		assertEquals(1, wordFrequencies.entrySet().size());
		final Word word = new Word(ImmutableList.of(0, 1, 0, 0));
		assertTrue(wordFrequencies.containsKey(word));
		assertTrue(wordFrequencies.containsValue(1));
		assertEquals(wordFrequencies, table.frequent(1));
	}
}
