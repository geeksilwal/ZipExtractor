package com.java.main.ZipExtractor;

import java.util.Comparator;

public class ZipcodeComparator implements Comparator<ZipCode> {
	  public int compare(ZipCode interval1, ZipCode interval2) {
		    if (interval1.getLowerBound() > interval2.getLowerBound())
		      return 1;
		    else
		      return -1;
		  }
}