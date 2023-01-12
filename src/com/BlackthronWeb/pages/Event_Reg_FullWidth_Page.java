package com.BlackthronWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Event_Reg_FullWidth_Page {
	
	
	
	public Event_Reg_FullWidth_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	  @FindBy(xpath="//span[text()='Register']")
		 public WebElement RegisterButton;
	
}	