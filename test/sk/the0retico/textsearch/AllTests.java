package sk.the0retico.textsearch;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author The0retico
 * 
 *         Test suite for all unit tests.
 * 
 */
@RunWith(Suite.class)
@SuiteClasses(value = { TreeMapFrequencyTableTest.class,
		TrieFrequencyTableTest.class })
public class AllTests {

}
