package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ContextTestBuilder {
	
	static public String testString = "test";
	static public int testInteger= 2;
	static public boolean testBoolean = false;
	static public Double testDouble = 2.2;
	static public SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	static public Calendar testCalendar = new GregorianCalendar(2013,1,28,13,24,56);
	
	public static int getContextYear(){
		return testCalendar.YEAR;
	}
	public static int getContextMonth(){
		return testCalendar.MONTH;
	}
	

}
