package sk.the0retico.textsearch;

import com.google.common.collect.ImmutableMap;

/**
 * @author The0retico
 * 
 *         Word frequency table interface.
 * 
 */
interface IFrequencyTable {

	/**
	 * @param word
	 *            represented as an array of alphabet letter indexes
	 * 
	 *            Adds occourance of a word into the table.
	 * 
	 */
	void add(Integer... word);

	/**
	 * @param times
	 *            minimal count of word occourances to appear in result
	 * @return map of words and their occurances with no less then times
	 *         occourances
	 */
	ImmutableMap<Word, Integer> frequent(int times);
}
