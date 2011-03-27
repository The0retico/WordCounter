package sk.the0retico.textsearch;

import org.junit.Before;

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

}
