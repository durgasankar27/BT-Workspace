package com.BlackthronWeb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ERS_Page {
	
	public ERS_Page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//div[@class= 'slds-icon-waffle']")
	 public WebElement applauncher;
	
	@FindBy(xpath="//div [@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/child::input")
	 public WebElement applauncher_searchbox;

	@FindBy(xpath="//b[contains(text(),'Event Registration Submissions')]")
	public WebElement ERS;
	
	 @FindBy(xpath="//a[@title='Event Registration Submissions']")
	 public WebElement ERS_tab;
	 
	 @FindBy(xpath="//span[contains(text(),'Recently Viewed')]")
	 public WebElement ers_recent_view_dropdown;
	 
	 @FindBy(xpath="//span[contains(text(),'All')]")
	 public WebElement ers_All_dropdown;
	  
	  @FindBy(xpath="(//a[contains(text(),'ER-')])[1]")
	  	public WebElement ers_record;
	  
	  @FindBy(xpath="(//div[@class='test-id__field-label-container slds-form-element__label no-utility-icon'])[4]/../div[2]/span")
	  	public WebElement ers_status;
	  
//	  @FindBy(xpath="//lightning-formatted-text[contains(text(),'Completed')]")
//	  	public WebElement completed_status;
//	  
//	  @FindBy(xpath="//lightning-formatted-text[contains(text(),'Draft')]")
//	  	public WebElement draft_status;
//	  
//	  @FindBy(xpath="//lightning-formatted-text[contains(text(),'To Process')]")
//	  	public WebElement to_process_status;

}
