package com.autosuggest.manager.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.autosuggest.manager.SearchManager;
import com.autosuggest.vo.SearchParams;

/**
 * @author Manu
 * 
 */
public class SearchManagerImpl implements SearchManager {

	public static Logger logger = Logger.getLogger(SearchManagerImpl.class);

	/**
	 * Perform search of the requested string It reads all the words present in
	 * a file "words.txt"
	 * 
	 * The method iterates through the words and finds if we have any word that
	 * starts with the prefix requested, until it finds the maximum requested
	 * keywords.
	 * 
	 * @param searchParams
	 * @return List of search results
	 */

	@Override
	public List<String> searchWords(SearchParams searchParams) {

		//File that holds all the words to be searched from
		String fileName = "/words.txt";

		InputStream pdInputStream = null;
		BufferedReader reader = null;

		// List that holds the search results
		List<String> words = new ArrayList();

		try {

			// load the file
			pdInputStream = this.getClass().getResourceAsStream(fileName);

			// pass the reference to the inputstream reader for further
			// processing
			reader = new BufferedReader(new InputStreamReader(pdInputStream));

			String sCurrentLine;

			int count = 0;
			int maxCount = (searchParams != null && searchParams.getMaxNumberOfResults() != null) ? searchParams.getMaxNumberOfResults() : Integer.MAX_VALUE;
			String prefixString = (searchParams != null && searchParams.getStartText() != null) ? searchParams.getStartText() : "";

			logger.debug("Start reading words from the file");

			// start time of the search, used to check the time required for
			// search
			long start = System.currentTimeMillis();

			//TODO : We can fetch all the values from the file and cache it and use this value in cache for searching
			// this would help us avoiding IO operation overhead on every request

			logger.debug("Start reading words from the file");
			// Read line by line(word by word) from the file
			while ((sCurrentLine = reader.readLine()) != null) {

				// If requested search string is empty, add all the words to
				// resultset
				if (prefixString.length() == 0) {
					words.add(sCurrentLine);
				}
				// check if word starts with the requested search string, if yes
				// add it to the result
				else if (sCurrentLine.toLowerCase().startsWith(prefixString.toLowerCase())) {
					words.add(sCurrentLine);

					// Check if the results found is equal to the total
					// requested results.
					// Do not iterate other words in file if the requested count
					// is matched
					if (maxCount == ++count) {
						break;
					}
				}
			}
			logger.info("Total time required to search the string is : " + (System.currentTimeMillis() - start));
			logger.debug("Search completed...");

		} catch (IOException e) {
			logger.error("Exception occured while reading the file", e);
		} finally {
			try {
				// Close the InputStream and Reader
				if (pdInputStream != null)
					pdInputStream.close();
				if (reader != null)
					reader.close();

			} catch (IOException ex) {
				logger.error("Exception occured while closing the resources", ex);
			}
		}
		logger.debug("Total no. of words found for suggestions : " + words.size());
		return words;
	}

}
