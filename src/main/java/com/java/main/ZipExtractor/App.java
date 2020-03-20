package com.java.main.ZipExtractor;

import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner inputScanner = new Scanner(System.in);
    	String inputZipRangeList = inputScanner.nextLine();
    	ZipCodeChecker checker = new ZipCodeChecker(inputZipRangeList);
    	List<ZipCode> zipCodeList  = checker.stripZipCode();
    	ZipCodeMerger zipcode_merger = new ZipCodeMerger();
        List<ZipCode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipCodeList);
        List<ZipCode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
        for (ZipCode zipcode : mergedZipcodeList) {
          System.out.println("[" + zipcode.getLowerBound() + "," + zipcode.getUpperBound() + "]");
        }
    }
    
}
