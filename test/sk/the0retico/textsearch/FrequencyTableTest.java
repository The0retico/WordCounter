package sk.the0retico.textsearch;

import org.junit.Before;

public abstract class FrequencyTableTest {

	private static IFrequencyTable table;

	protected abstract IFrequencyTable getImplementation();

	@Before
	public final void setUp() throws Exception {
		table = getImplementation();
	}

}
