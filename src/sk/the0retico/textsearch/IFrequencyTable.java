package sk.the0retico.textsearch;

import java.util.Map;

public interface IFrequencyTable {

	void add(int... word);

	Map<Integer[], Integer> frequent(int times);
}
