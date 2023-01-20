package com.BlackthronWeb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	
   public class Events_Reg_PaidTickets_Page {

	
	public Events_Reg_PaidTickets_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	  @FindBy(xpath="(//span[text()='get tickets'])[2]")
		 public WebElement GetTicketsButton;
	  
	  
	  @FindBy(xpath="(//button[@role='button'])[2]")
		 public WebElement CheckoutButton;
	  
	  @FindBy(xpath="(//button[@role='button'])[1]")
		 public WebElement PaymentButton;
	  
	  @FindBy(xpath="//input[@autocomplete='cc-number']")
		 public WebElement cardNumber;
	  
	  @FindBy(xpath="//input[@autocomplete='cc-name']")
		 public WebElement cardName;
	  
	  @FindBy(xpath="//input[@autocomplete='cc-exp']")
     	 public WebElement cardExpiry;
	  
	  @FindBy(xpath="//input[@autocomplete='cc-csc']")
		 public WebElement CVV;
	  
	  @FindBy(xpath="//mat-select[@autocomplete='country']")
		 public WebElement country;
	  
	  @FindBy(xpath="//input[@autocomplete='postal-code']")
		 public WebElement postalCode;
	  
	  @FindBy(xpath="//span[text()='pay later']")
		 public WebElement payLater;
	  
	  @FindBy(xpath="(//span[text()=' complete '])[1]")
		 public WebElement completeButton;
	  
	  @FindBy(xpath="//span[text()=' United States ']")
		 public WebElement US;
	  
	  @FindBy(xpath="(//button[@role='button'])[1]")
		 public WebElement Payment_Button;
	  














}
