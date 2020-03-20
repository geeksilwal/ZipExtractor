package com.java.main.ZipExtractor;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ZipCodeMergerTest {
	 @Test
	  public void testMergeZipCodes() {
	    String inputDataSet = "[94133,94133] [94200,94299] [94226,94399]";
	    ZipCodeChecker zipcodeChecker = new ZipCodeChecker(inputDataSet);
        List<ZipCode> zipcodeList = zipcodeChecker.stripZipCode();
        ZipCodeMerger zipcodeMerger = new ZipCodeMerger();
	    List<ZipCode> sortedZipCodeList = zipcodeMerger.sortByLowerBounds(zipcodeList);
	    List<ZipCode> mergedZipcodeList = zipcodeMerger.mergeZipcodes(sortedZipCodeList);
	    assertTrue(mergedZipcodeList.size() > 0);
	  }
	 
	 @Test
	 public void testOverlappingRangeToReturnOneRange() {
		    ZipCode zipcode1 = new ZipCode(96000, 96005);
		    ZipCode zipcode2 = new ZipCode(96002, 96006);
		    List<ZipCode> zipcodeList = new LinkedList<>();
		    zipcodeList.add(zipcode1);
		    zipcodeList.add(zipcode2);
		    ZipCodeMerger zipcodeMerger = new ZipCodeMerger();
		    List<ZipCode> sortedZipCodeList = zipcodeMerger.sortByLowerBounds(zipcodeList);
		    List<ZipCode> mergedZipcodeList = zipcodeMerger.mergeZipcodes(sortedZipCodeList);
		    assertTrue(mergedZipcodeList.get(0).getUpperBound() == 96006 && mergedZipcodeList.get(0).getLowerBound() == 96000);
		  }
	 

}
