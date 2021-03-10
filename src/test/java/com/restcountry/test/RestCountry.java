package com.restcountry.test;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.restcountry.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

import java.util.Scanner;


public class RestCountry extends TestBase {
	

	@Test(priority=1,groups={"sanity"})
	public void getByname()
	{
		
		logger.info("get counties by name");
		System.out.println("enter country name:");
		Scanner s=new Scanner(System.in);
		String countryname=s.nextLine();
		Response res = RestAssured.given().header("content-Type","application/JSON").when()
						.get("https://restcountries.eu/rest/v2/name/{name}",countryname);
		System.out.println(res.asString());
		//System.out.println(res.statusCode());
		logger.info("checking status code");
		assertThat(res.statusCode(), is(equalTo(200)));
		logger.info("test completed succesfully");		
	}
	
	@Test(priority=2,groups={"sanity"})
	public void getByCode()
	{
		
		logger.info("get counties by code");
		System.out.println("enter country code:");
		Scanner s=new Scanner(System.in);
		String code=s.nextLine();
		
		Response res = RestAssured.given().header("content-Type","application/JSON").when()
						.get("https://restcountries.eu/rest/v2/alpha/{code}",code);
		System.out.println(res.asString());
		//System.out.println(res.statusCode());
		assertThat(res.statusCode(), is(equalTo(200)));	
		logger.info("test completed succesfully");
	}
	
	@Test(priority=3,groups={"regression"})
	public void getByCodeNegative()
	{
		
		logger.info("get counties by code with wrong http method");
		System.out.println("enter country code:");
		Scanner s=new Scanner(System.in);
		String codeneg=s.nextLine();
		s.close();		
		Response res = RestAssured.given().header("content-Type","application/JSON").when()
						.post("https://restcountries.eu/rest/v2/alpha/{code}",codeneg);
		System.out.println(res.asString());
		
		assertThat(res.statusCode(), is(equalTo(200)));	
		
		
	}
	
	

}
