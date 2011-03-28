package sk.the0retico.textsearch;

public class TreeMapFrequencyTableTest extends AbstractFrequencyTableTest {

	@Override
	protected IFrequencyTable getImplementation() {
		return new TreeMapFrequencyTable();
	}

}
