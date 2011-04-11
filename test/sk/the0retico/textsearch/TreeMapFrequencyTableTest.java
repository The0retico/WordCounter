package sk.the0retico.textsearch;


/**
 * @author The0retico
 * 
 *         Contract test implementation for frequency table providing the
 *         TreeMap implementation.
 * 
 */
public class TreeMapFrequencyTableTest extends AbstractFrequencyTableTest {

	@Override
	protected final IFrequencyTable getImplementation(final Integer alphabetSize) {
		return new TreeMapFrequencyTable();
	}

}
