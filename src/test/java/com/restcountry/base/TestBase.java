package com.restcountry.base;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;




public class TestBase {


		public Logger logger;
		
		
		@BeforeTest
		public void setLogger()
		{
			logger=Logger.getLogger("RestCountryAPI");
			PropertyConfigurator.configure("C:\\Users\\ckeng\\Desktop\\Eclipse workspace\\RestCountries\\src\\main\\resources\\log4j.properties");
			
			logger.setLevel(Level.DEBUG);
		}
		
		 
		
		
	}
