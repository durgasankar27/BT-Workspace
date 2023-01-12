package com.BlackthronWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Events_Reg_Tabbed_Page {
	public Events_Reg_Tabbed_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="(//span[text()='Register'])[1]")
	 public WebElement reg_button;
	
	@FindBy(xpath="//mat-select[@role='listbox']")
	 public WebElement listbox;
	
	@FindBy(xpath="//span[text()=1]")
	 public WebElement one_Ticket;
	 
	@FindBy(xpath="//span[text()=2]")
	 public WebElement Second_ticket;
	
	@FindBy(xpath="//span[text()=3]")
	 public WebElement Third_ticket;


	@FindBy(xpath="//span[text()=4]")
	 public WebElement Fourth_ticket;
	
	
	@FindBy(xpath="(//span[text()='register'])[1]")
	 public WebElement register_button;
	
	@FindBy(xpath="//input[@name='firstName']")
	 public WebElement first_name;
	
	@FindBy(xpath="//input[@name='lastName']")
	 public WebElement last_name;
	
	@FindBy(xpath="//input[@name='email']")
	 public WebElement email;
	
	@FindBy(xpath="(//span[text()='register'])[1]")
	 public WebElement regbutton;
	@FindBy(xpath=" //h1[contains(text(),'Your order is complete')] ")
	 public WebElement success_message;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator done-btn mat-flat-button mat-button-base mat-primary']")
	 public WebElement Done_button;
	
	@FindBy(xpath="(//input[@name='firstName'])[1]")
	 public WebElement first_name1;
	
	@FindBy(xpath="(//input[@name='lastName'])[1]")
	 public WebElement last_name1;
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	 public WebElement email1;
	
	@FindBy(xpath="(//input[@name='firstName'])[2]")
	 public WebElement first_name2;
	
	@FindBy(xpath="(//input[@name='lastName'])[2]")
	 public WebElement last_name2;
	
	@FindBy(xpath="(//input[@name='email'])[2]")
	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
//	
//	@FindBy(xpath="(//input[@name='email'])[2]")
//	 public WebElement email2;
	
	
	
	
	
}
