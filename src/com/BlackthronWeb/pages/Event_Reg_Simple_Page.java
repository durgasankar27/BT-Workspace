package com.BlackthronWeb.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Event_Reg_Simple_Page {
	
	public Event_Reg_Simple_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }

	@FindBy(xpath="//input[@name='firstName']")
	 public WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	 public WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	 public WebElement email;
	
	@FindBy(xpath="//button[@role='submit']")
	 public WebElement Register_button;
	
	
}
