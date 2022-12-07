package com.BlackthronWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Codes_Page {
	public Codes_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//div[@class= 'slds-icon-waffle']")
	 public WebElement applauncher;
	
	@FindBy(xpath="//div [@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/child::input")
	 public WebElement searchBar;
	
	@FindBy(xpath="//b[contains(text(),'Codes')]")
	public WebElement Codes;
	
	@FindBy(xpath="//div [text()='New']")
	 public WebElement code_new;
	
	@FindBy(xpath="//input[@name='Name']")
	 public WebElement code_name;
	
	@FindBy(xpath="//input[@name='bt_stripe__Valid_From__c']")
	 public WebElement code_valid_from;
	
	@FindBy(xpath="//input[@name='bt_stripe__Valid_Through__c']")
	 public WebElement code_valid_through;
	
	@FindBy(xpath="//input[@name='bt_stripe__Discount_Amount__c']")
	 public WebElement Discount_Amount;
	
	@FindBy(xpath="//input[@name='bt_stripe__Discount_Percentage__c']")
	 public WebElement Discount_Percentage;
	
	@FindBy(xpath="//button[text()='Save']")
	 public WebElement code_save_button;
	

}
