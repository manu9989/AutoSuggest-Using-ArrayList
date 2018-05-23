package com.autosuggest.vo;

/**
 * A POJO that is used to carry the request parameters
 * 
 * @author Manu
 *
 */
public class SearchParams {

	
	/**
	 * Holds the prefix user has searched
	 */
	private String startText;
	
	
	/**
	 * Hold the maximum number of results user is expecting 
	 */
	private Integer maxNumberOfResults;

	public String getStartText() {
		return startText;
	}

	public void setStartText(String startText) {
		this.startText = startText;
	}

	public Integer getMaxNumberOfResults() {
		return maxNumberOfResults;
	}

	public void setMaxNumberOfResults(Integer maxNumberOfResults) {
		this.maxNumberOfResults = maxNumberOfResults;
	}
}
