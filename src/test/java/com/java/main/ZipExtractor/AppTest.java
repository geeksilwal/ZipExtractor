package com.java.main.ZipExtractor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testConvertRawStringToList() {
    	String inputDataSet = "[94133,94133] [94200,94299] [94600,94699]";
        ZipCodeChecker zipcodeChecker = new ZipCodeChecker(inputDataSet);
        List<ZipCode> zipcodeList = zipcodeChecker.stripZipCode();
        assertTrue(zipcodeList.size() > 0);
      }
    
    @Test
    public void testExceptionWhenZipCodeFormatMisMatch() {
        try {
          String inputDataSet = "[92004,92002,92003] [92003,92004]";
          ZipCodeChecker zipcodeChecker = new ZipCodeChecker(inputDataSet);
          List<ZipCode> zipcodeList = zipcodeChecker.stripZipCode();
        } catch (IllegalArgumentException e) {
          Assert.assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
        }
      }
    
    @Test
    public void testExceptionWhenLowerBoundGreater() {
        try {
          String inputDataSet = "[92004,92002] [92003,92004]";
          ZipCodeChecker zipcodeChecker = new ZipCodeChecker(inputDataSet);
          List<ZipCode> zipcodeList = zipcodeChecker.stripZipCode();
        } catch (IllegalArgumentException e) {
          String expectedMessage = "92004 92002:  Zipcode lower bound should be less" + " than upper bound";
          Assert.assertEquals(expectedMessage, e.getMessage());
        }
      }
}

