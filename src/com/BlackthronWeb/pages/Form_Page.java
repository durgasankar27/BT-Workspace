package com.BlackthronWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form_Page {
	public Form_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//div[@class= 'slds-icon-waffle']")
	 public WebElement applauncher;
	
	@FindBy(xpath="//div [@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/child::input")
	 public WebElement searchBar;
	
	@FindBy(xpath="//b[contains(text(),'Forms')]")
	public WebElement Forms;
	
	@FindBy(xpath="//div [text()='New']")
	 public WebElement form_new;
	
	@FindBy(xpath="//input[@name='Name']")
	 public WebElement form_name;
	
	@FindBy(xpath="//label[text()='Type']")
   	public WebElement form_type;
	
	@FindBy(xpath="//span[text()='Pre-registration']")
	public WebElement Pre_registration;
	
	@FindBy(xpath="//span[text()='Post-registration']")
	public WebElement Post_registration;
	
	@FindBy(xpath="//span[text()='Survey']")
	public WebElement Survey;
	
	@FindBy(xpath="//button[text()='Save']")
	 public WebElement form_save_button;
	
	@FindBy(xpath="//label[text()='Type']")
	public WebElement Form_Element_type;
	
	@FindBy(xpath="//span[text()='Big List Group']")
	public WebElement Big_List_Group;
	
	@FindBy(xpath="//span[text()='Checkbox']")
	public WebElement Checkbox;
	
	@FindBy(xpath="//span[text()='Date']")
	public WebElement Date;
	
	@FindBy(xpath="//span[text()='Divider']")
	public WebElement Divider;
	
	@FindBy(xpath="//span[text()='Email']")
	public WebElement Email;
	
	@FindBy(xpath="//span[text()='File Upload']")
	public WebElement File_Upload;
	
	@FindBy(xpath="//span[text()='Hidden']")
	public WebElement Hidden;
	
	@FindBy(xpath="//span[text()='Multi-Select Picklist']")
	public WebElement Multi_Select_Picklist;
	
	@FindBy(xpath="//span[text()='Number']")
	public WebElement Number;
	
	@FindBy(xpath="//span[text()='Parameter']")
	public WebElement Parameter;
	
	@FindBy(xpath="//span[text()='Picklist']")
	public WebElement Picklist;
	
	@FindBy(xpath="//span[text()='Text']")
	public WebElement Text;
	
	@FindBy(xpath="//span[text()='Text (30,000)']")
	public WebElement long_text;
	
	@FindBy(xpath="//span[text()='URL']")
	public WebElement URL;
	
	@FindBy(xpath="//button[text()='Save']")
	public WebElement Form_Element_Save;
	
	@FindBy(xpath="//ancestor::c-form-element-edit//div [@class='slds-form-element__control']//input [contains(@id, 'input')]")
	public WebElement question_name;
	
	@FindBy(xpath="//textarea[@name='picklistValues']")
	public WebElement Picklist_values;
	

}
