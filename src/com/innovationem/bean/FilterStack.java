package com.innovationem.bean;

import org.slim3.datastore.Filter;
import org.slim3.datastore.FilterCriterion;

import java.util.LinkedHashSet;

/**
 * Created by IntelliJ IDEA. User: murali Date: Jun 12, 2010 Time: 4:03:04 AM To
 * change this template use File | Settings | File Templates.
 */
public class FilterStack implements FilterCriterion {

	public LinkedHashSet<Filter> queryFilters = new LinkedHashSet<Filter>();

	public Filter[] getFilters() {
		return (Filter[]) queryFilters.toArray(new Filter[0]);
	}

	public void addFilter(Filter filter) {
		queryFilters.add(filter);
	}

}
