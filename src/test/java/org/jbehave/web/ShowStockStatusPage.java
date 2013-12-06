package org.jbehave.web;

import org.springframework.beans.factory.annotation.Autowired;


public class ShowStockStatusPage {

	private static final String STATUS_ID = "result";
	
	@Autowired
	private PageUtils pageUtils;
	
	public String getStockStatusMessage() {
		return pageUtils.getElementText(STATUS_ID);
	}

    public void close() {
        pageUtils.close();
    }
}
