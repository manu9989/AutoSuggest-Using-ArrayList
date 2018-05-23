package com.autosuggest.service;

import java.util.List;

import com.autosuggest.vo.SearchParams;

/**
 * SearchService interface  
 * 
 * @author Manu
 *
 */
public interface SearchService {

	/**
	 * Perform search on the requested string
	 * 
	 * @param searchParams
	 * @return List of search results
	 */
	public List<String> searchWords(SearchParams searchParams);
}
