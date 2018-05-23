package com.autosuggest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.autosuggest.manager.SearchManager;
import com.autosuggest.service.SearchService;
import com.autosuggest.vo.SearchParams;

	
/**
 * @author Manu
 *
 */
public class SearchServiceImpl implements SearchService{
	
	//Inject Search Manager to perform Search
	@Autowired
	private SearchManager searchManager;
	
	/**
	 * Perform search on the requested string
	 * 
	 * @param searchParams
	 * @return List of search results
	 */
	public List<String> searchWords(SearchParams searchParams){
		return getSearchManager().searchWords(searchParams);
	}

	public SearchManager getSearchManager() {
		return searchManager;
	}

	public void setSearchManager(SearchManager searchManager) {
		this.searchManager = searchManager;
	}
}
