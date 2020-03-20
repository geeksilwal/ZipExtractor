package com.java.main.ZipExtractor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZipCodeMerger {
	public List<ZipCode> sortByLowerBounds(List<ZipCode> zipcodeRangeList) {
	    Collections.sort(zipcodeRangeList, new ZipcodeComparator());
	    return zipcodeRangeList;
	  }

	  public List<ZipCode> mergeZipcodes(List<ZipCode> sortedZipCodeList) {
		  
		List<ZipCode> mergedZipcodeList = new LinkedList<>();
	    ZipCode zipcode = null;
	    for (ZipCode zipcodeInterval : sortedZipCodeList) {
	      if (zipcode == null)
	        zipcode = zipcodeInterval;
	      else {
	        if (zipcode.getUpperBound() >= zipcodeInterval.getLowerBound()) {
	          zipcode.setUpperBound(Math.max(zipcode.getUpperBound(), zipcodeInterval.getUpperBound()));
	        } else {
	          mergedZipcodeList.add(zipcode);
	          zipcode = zipcodeInterval;
	        }
	      }
	    }
	    mergedZipcodeList.add(zipcode);
	    return mergedZipcodeList;
	  }
}
