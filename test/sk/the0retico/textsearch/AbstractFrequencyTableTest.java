package sk.the0retico.textsearch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * @author The0retico
 * 
 *         Contract test for IFrequencyTable implementations.
 */
public abstract class AbstractFrequencyTableTest {

	/**
	 * IFrequencyTable implementation instance to be tested.
	 */
	private IFrequencyTable table;

	/**
	 * @return IFrequencyTable implementation for testing
	 */
	protected abstract IFrequencyTable getImplementation();

	/**
	 * Set up implementation of the IFrequencyTable for testing.
	 */
	@Before
	public final void setUp() {
		table = getImplementation();
	}

	/**
	 * The frequency table righ after creation should be empty.
	 */
	@Test
	public final void shouldBeEmptyAfterCreation() {
		final ImmutableMap<Word, Integer> emptyMap = ImmutableMap.of();
		assertThat(table.frequent(0), is(equalTo(emptyMap)));
	}
}
