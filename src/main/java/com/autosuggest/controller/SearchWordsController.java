package com.autosuggest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.autosuggest.service.SearchService;
import com.autosuggest.vo.SearchParams;

/**
 * Search Controller, all search request comes here.
 * 
 * */
@Controller
public class SearchWordsController{

	public static Logger logger = Logger.getLogger(SearchWordsController.class);
	
	//Search service is injected for performing the search
	@Autowired
	private SearchService searchService;

	/**
	 * Perform search on the requested string
	 * 
	 * @param start : The prefix or an entire string, for which auto suggestion is requested
	 * @param atmost : Maximum number of suggestions requested 
	 * 
	 * @return ModelAndView : the view where the result will be rendered with list of suggested strings
	 */
	@RequestMapping("/search")
	public ModelAndView execute(@RequestParam(required = false) String start, @RequestParam(required = false) Integer atmost){
		
		logger.debug("Search String entered : "+start);
		logger.debug("Maximum suggestions requested : "+atmost);
		
		//Populate the request values into a VO. It will be used in the search
		SearchParams searchParams = new SearchParams();
		searchParams.setStartText(start);
		searchParams.setMaxNumberOfResults(atmost);
		
		logger.debug("Calling serach service");
		//fetch the suggestions by calling the service
		List<String> suggestedList = getSearchService().searchWords(searchParams);
		
		logger.debug("Rendering the result");
		//Render the view with the search results 
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("suggestedList", suggestedList);
		return mv;
		
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
