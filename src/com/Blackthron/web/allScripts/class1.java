package com.Blackthron.web.allScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Blackthron.web.sanityscripts.BaseTestWeb;
import com.Blackthron.web.utils.Application_Utilities;
import com.Blackthron.web.utils.ConstantsWeb;
import com.BlackthronWeb.pages.BasePageWeb;
import com.BlackthronWeb.pages.EventsPage;
import com.BlackthronWeb.pages.LoginPage;
import com.aventstack.extentreports.Status;


public class class1 extends BaseTestWeb{
	
	/*
	  @throws Exception
	*/
	@Test (priority=1)
	public void Lauchbrowser() throws Exception
	{
		try {
		launchWeb(ConstantsWeb.OS, ConstantsWeb.browser);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		reader=loadPropertyFile("credentials.properties");
		prop.load(reader);
		LoginPage login= new LoginPage(driver);
		EventsPage eventpage= new EventsPage(driver);
		ConstantsWeb.UserName=prop.getProperty("username");
		System.out.println(ConstantsWeb.UserName);
		ConstantsWeb.password=prop.getProperty("password");
		login.Login(ConstantsWeb.UserName, ConstantsWeb.password);
//		Thread.sleep(3000);	
		Application_Utilities.eventCreation("Simple");
        Thread.sleep(10000);
		Application_Utilities.eventItemCreation("free", "Main");
		Application_Utilities.publishAnEvent();
		Application_Utilities.Eventurl("staging");	
		Application_Utilities.Registration("Simple","free");
		//Application_Utilities.Code_creation("amount", 0);
		
		//Application_Utilities.Verify_ERS();
		}
		catch(Exception e)		
		{
		test.log(Status.FAIL, e.getMessage());
		BasePageWeb.reportFail("Test Failed" + e);
		
		}		
	}
}


	
	