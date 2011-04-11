package sk.the0retico.textsearch;


/**
 * @author The0retico
 * 
 *         Test class for frequency table implementation using the trie data
 *         structure.
 * 
 */
public class TrieFrequencyTableTest extends AbstractFrequencyTableTest {

	@Override
	protected final IFrequencyTable getImplementation(final Integer alphabetSize) {
		return new TrieFrequencyTable(alphabetSize);
	}

}
