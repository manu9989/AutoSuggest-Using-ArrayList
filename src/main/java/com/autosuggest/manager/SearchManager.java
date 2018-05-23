package com.autosuggest.manager;

import java.util.List;

import com.autosuggest.vo.SearchParams;

/**
 * @author Manu
 *
 */
public interface SearchManager {

	/**
	 * Perform search on the requested string
	 * 
	 * @param searchParams
	 * @return List of search results
	 */
	public List<String> searchWords(SearchParams searchParams);
}
