package com.Blackthron.web.utils;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BlackthronWeb.pages.*;

import com.BlackthronWeb.pages.*;
import com.aventstack.extentreports.Status;


public class Application_Utilities extends Base_Test_Web_Utils {
	
	//This method is for Creating Event with Required UI
	public static void eventCreation(String Ui) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		EventsPage eventpage= new EventsPage(driver);
		eventpage.applauncher.click();
	//	UtilitiesWeb.wait_until_the_page_is_loaded();
		eventpage.searchBar.sendKeys("Events (Admin)");
		eventpage.EventAdmin.click();
	//	UtilitiesWeb.wait_until_the_page_is_loaded();
		Actions action = new Actions(driver);
		action.moveToElement(eventpage.Eventstab).click().perform();
	//	UtilitiesWeb.wait_until_the_page_is_loaded();
		eventpage.eventspagenewbutton.click();
	//	UtilitiesWeb.wait_until_the_page_is_loaded();
		eventpage.Eventname.click();
		eventpage.Eventname.sendKeys(UtilitiesWeb.Randomname(5));
		eventpage.uiexperience.click();
		
		if(Ui.equalsIgnoreCase("Simple")) {
			eventpage.simpleui.click();
		}
		else if(Ui.equalsIgnoreCase("Full Width")) {
			eventpage.fullwidthui.click();
		}
		else
			eventpage.tabbedui.click();

		
		UtilitiesWeb.scroll_to_particular_element(eventpage.Dates);
		eventpage.startdate.click();
	 	eventpage.startdate.sendKeys("Dec 29, 2021");
	 	eventpage.enddate.click();
	 	eventpage.enddate.sendKeys("Dec 29, 2030");
	 	
	 	eventpage.start_time.click();
	 	eventpage.start_time.sendKeys("12:00 AM");
	 	
	 	eventpage.end_time.click();
	 	eventpage.end_time.sendKeys("12:00 AM");
	 	 eventpage.Save_button.click(); 
	// 	UtilitiesWeb.wait_until_the_page_is_loaded();
	 	System.out.println("Event Created");
		
	}
		//This method is to create an Event item
		public static void eventItemCreation(String price, String Type) {
			EventsPage eventpage= new EventsPage(driver);
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.scroll_to_particular_element(eventpage.email_template);
			
			eventpage.Event_Item.click();
			UtilitiesWeb.wait_until_element_is_visible(eventpage.Eventitem_New, 5);
			UtilitiesWeb.wait_until_the_page_is_loaded();
			eventpage.Eventitem_New.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			eventpage.Eventitem_name.click();
			eventpage.Eventitem_name.sendKeys(UtilitiesWeb.Randomname(5));
			
			//Determine the Ticket Price
			if(price.equalsIgnoreCase("paid")) {
			int amount = UtilitiesWeb.generateNumber(1000);
				eventpage.Eventitem_price.click();
				eventpage.Eventitem_price.sendKeys(String.valueOf(amount));
			}
			else {
				eventpage.Eventitem_price.click();
				eventpage.Eventitem_price.sendKeys("0");
			}
			
			//Determine Event Item Type
			eventpage.eventitem_type.click();
			if(Type.equalsIgnoreCase("Donation")) {
				eventpage.eventitem_donation_type.click();
			}
			else if(Type.equalsIgnoreCase("Guest")) {
				eventpage.eventitem_guest_type.click();
			}
			else if(Type.equalsIgnoreCase("Others")) {
				eventpage.eventitem_other_type.click();
			}
			else {
				eventpage.eventitem_main_ticket_type.click();
			}
			
			eventpage.Save_eventitem.click();	
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			eventpage.eventName.click();
			
		}
		
		//This method is to publish an Event
		public static void publishAnEvent() {
			EventsPage eventpage= new EventsPage(driver);
			UtilitiesWeb.wait_until_element_is_visible(eventpage.Publish, 5);
			UtilitiesWeb.wait_until_the_page_is_loaded();
			eventpage.Publish.click();
		}
		
		//This Method is to Open Event URL
		public static void Eventurl(String domain) throws AWTException {
			EventsPage eventpage= new EventsPage(driver);
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.scroll_to_particular_element(eventpage.Eventdate_tab);
			String prod_url= eventpage.EventReglink.getText();
			System.out.println(prod_url);
			if(domain.equalsIgnoreCase("staging")) {
				String staging_url=prod_url.replace("//events", "//preview.events");
				System.out.println(staging_url);
				
				String maintab=driver.getWindowHandle();
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_T);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_T);
				UtilitiesWeb.waitForAwhile();
				Set<String> Tabs = driver.getWindowHandles();
				for (String string : Tabs) {
					if(!string.equals(maintab)) {
						driver.switchTo().window(string);
						//System.out.println("Pointer is here");
						driver.navigate().to(staging_url);
					}
			}
			}
			else
			{
				Actions action = new Actions(driver);
				action.moveToElement(eventpage.EventReglink).click().perform();
				String mainWindow=driver.getWindowHandle();
			 	Set<String> set =driver.getWindowHandles();
			 	Iterator<String> itr= set.iterator();
			 	while(itr.hasNext()){
			 	String childWindow=itr.next();
			 	if(!mainWindow.equals(childWindow)){
			 		driver.switchTo().window(childWindow); //Switching to 2nd Tab
			 	}}
			}
			UtilitiesWeb.waitForAwhile();
			
			
		}
		
		
		public static void Code_creation(String discount_type , int code) {
			Codes_Page codepage= new Codes_Page(driver);
			codepage.applauncher.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			codepage.searchBar.sendKeys("Codes");
			UtilitiesWeb.wait_until_the_page_is_loaded();
			codepage.Codes.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			codepage.code_new.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			codepage.code_name.click();
			codepage.code_name.sendKeys("Unique Code");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", codepage.Discount_Amount);
			
			if(discount_type.equalsIgnoreCase("Amount")) 
			{
			codepage.Discount_Amount.click();
			codepage.Discount_Amount.sendKeys(String.valueOf(code));
			}
			else {
			codepage.Discount_Percentage.click();
			codepage.Discount_Percentage.sendKeys(String.valueOf(code));
			}
		}
		
		public static void Verify_ERS() throws Exception {
			ERS_Page erspage= new ERS_Page(driver);
			
			String mainWindow=driver.getWindowHandle();
		 	Set<String> set =driver.getWindowHandles();
		 	Iterator<String> itr= set.iterator();
		 	while(itr.hasNext()){
		 	String childWindow=itr.next();
		 	if(!mainWindow.equals(childWindow)){
		 	driver.switchTo().window(childWindow);
			
			erspage.applauncher.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			erspage.applauncher_searchbox.sendKeys("Event Registration Submissions");
			UtilitiesWeb.wait_until_the_page_is_loaded();
			erspage.ERS.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.wait_until_element_is_visible(erspage.ers_recent_view_dropdown, 5);
			erspage.ers_recent_view_dropdown.click();
			UtilitiesWeb.wait_until_element_is_visible(erspage.ers_All_dropdown, 5);
			erspage.ers_All_dropdown.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			erspage.ers_record.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", erspage.ers_status);
			if(erspage.ers_status.getText().equalsIgnoreCase("Draft") || erspage.ers_status.getText().equalsIgnoreCase("To Process")) {
				for(int i=0; i<=20;i++) {
					UtilitiesWeb.wait_until_the_page_is_loaded();
					js.executeScript("arguments[0].scrollIntoView();", erspage.ers_status);
					if(erspage.ers_status.getText().equalsIgnoreCase("Completed")) {
					break;
					}
					else {
						driver.navigate().refresh();
					}
			}
			}
			else
			{
				BasePageWeb.reportFail("ERS is Failed");
			}}}
		}
		
		public static void PaidRegistration(String PayType) throws Exception {
			    Events_Reg_Tabbed_Page reg=new Events_Reg_Tabbed_Page(driver);
				Events_Reg_PaidTickets_Page paidreg=new Events_Reg_PaidTickets_Page(driver);
				reg.listbox.click();
				reg.one_Ticket.click();
				Thread.sleep(1000);
				paidreg.CheckoutButton.click();
				reg.first_name.click();
				reg.first_name.sendKeys(UtilitiesWeb.Randomname(6));
				reg.last_name.click();
				reg.last_name.sendKeys(UtilitiesWeb.Randomname(4));
				reg.email.click();
				reg.email.sendKeys(UtilitiesWeb.generateEmailid());
				Thread.sleep(2000);
				paidreg.PaymentButton.click();
				Thread.sleep(2000);
				
				if(PayType.equalsIgnoreCase("card")) {
				UtilitiesWeb.scroll_to_particular_element(paidreg.cardNumber);
				paidreg.cardNumber.click();
				paidreg.cardNumber.sendKeys("4242424242424242");
				paidreg.cardName.click();
				paidreg.cardName.sendKeys(UtilitiesWeb.Randomname(3));
				paidreg.cardExpiry.click();
				paidreg.cardExpiry.sendKeys("0229");
				paidreg.CVV.click();
				paidreg.CVV.sendKeys("345");
				paidreg.country.click();
				paidreg.US.click();
				paidreg.postalCode.click();
				paidreg.postalCode.sendKeys("10010");
				//UtilitiesWeb.scroll_to_particular_element(paidreg.Payment_Button);
				UtilitiesWeb.scrollTop(driver);
				paidreg.Payment_Button.click();
				Events_Reg_Tabbed_Page reg2=new Events_Reg_Tabbed_Page(driver);
				UtilitiesWeb.wait_until_element_is_visible(reg2.success_message, 10);
				String success_msg=reg2.success_message.getText();
				System.out.println(success_msg);
				}
				
				else{
					UtilitiesWeb.scroll_to_particular_element(paidreg.payLater);
					paidreg.payLater.click();
					UtilitiesWeb.scrollTop(driver);
					paidreg.completeButton.click();
					Events_Reg_Tabbed_Page reg2_1=new Events_Reg_Tabbed_Page(driver);
					UtilitiesWeb.wait_until_element_is_visible(reg2_1.success_message, 10);
					String success_msg=reg2_1.success_message.getText();
					System.out.println(success_msg);
				}
		}
		
		public static void Registration(String  UI, String price, String Payment_Type) throws Exception {
			
			 if(UI.equalsIgnoreCase("Tabbed"))
			 {
			 if(price.equalsIgnoreCase("free")) {
			Events_Reg_Tabbed_Page reg=new Events_Reg_Tabbed_Page(driver);
			//UtilitiesWeb.waitForAwhile();
		    UtilitiesWeb.wait_until_element_is_visible(reg.reg_button,8);
			reg.reg_button.click();
			reg.listbox.click();
			
				reg.one_Ticket.click();
				reg.register_button.click();
				reg.first_name.click();
				reg.first_name.sendKeys(UtilitiesWeb.Randomname(6));
				reg.last_name.click();
				reg.last_name.sendKeys(UtilitiesWeb.Randomname(4));
				reg.email.click();
				reg.email.sendKeys(UtilitiesWeb.generateEmailid());
				Thread.sleep(2000);
				reg.regbutton.click();
				Thread.sleep(2000);
				reg.regbutton.click();
				String success_msg=reg.success_message.getText();
				System.out.println(success_msg);
				reg.Done_button.clear();
			}
			else if(price.equalsIgnoreCase("paid")) 
			{
				Events_Reg_PaidTickets_Page reg_paid=new Events_Reg_PaidTickets_Page(driver);
				UtilitiesWeb.wait_until_the_page_is_loaded();
				//Thread.sleep(30000);
				reg_paid.GetTicketsButton.click();
				 if (Payment_Type.equalsIgnoreCase("card")) {
				PaidRegistration("card");
				}
			     if (Payment_Type.equalsIgnoreCase("PayLater"))
			{
			    	 PaidRegistration("PayLater");
			}}}
			 
			 
			 
	          if(UI.equalsIgnoreCase("Full Width"))
			  {
	          	if(price.equalsIgnoreCase("free")) { 
				Event_Reg_FullWidth_Page reg_full=new Event_Reg_FullWidth_Page(driver); 
				//UtilitiesWeb.wait_until_element_is_visible(reg_full.RegisterButton, 15);
				Thread.sleep(5000);
				UtilitiesWeb.scroll_to_particular_element(reg_full.RegisterButton);
				reg_full.RegisterButton.click();
				UtilitiesWeb.wait_until_element_is_visible(reg_full.firstname, 5);
				reg_full.firstname.click();
				reg_full.firstname.sendKeys(UtilitiesWeb.Randomname(4));
				reg_full.Lastname.click();
				reg_full.Lastname.sendKeys(UtilitiesWeb.Randomname(4));
				reg_full.Email.click();
				reg_full.Email.sendKeys(UtilitiesWeb.generateEmailid());
				reg_full.confirm.click();
				Events_Reg_Tabbed_Page reg1=new Events_Reg_Tabbed_Page(driver);
				UtilitiesWeb.wait_until_element_is_visible(reg1.success_message, 10);
				String success_msg=reg1.success_message.getText();
				System.out.println(success_msg);
		    	}
				else if(price.equalsIgnoreCase("paid")) {
					
					Events_Reg_PaidTickets_Page reg_paid=new Events_Reg_PaidTickets_Page(driver);
					UtilitiesWeb.wait_until_the_page_is_loaded();
					Thread.sleep(3000);
					UtilitiesWeb.scroll_to_particular_element(reg_paid.GetTicketsButton);
					reg_paid.GetTicketsButton.click();
					if(Payment_Type.equalsIgnoreCase("card")) {
						PaidRegistration("card");
					}
				
					if(Payment_Type.equalsIgnoreCase("PayLater")) {
						PaidRegistration("PayLater");
					}
				}}
						    
			if(UI.equalsIgnoreCase("Simple"))
			{
			Event_Reg_Simple_Page Reg_Simple=new Event_Reg_Simple_Page(driver);
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.wait_until_element_is_visible(Reg_Simple.firstname, 10);
			System.out.println("pointer is here");
			Reg_Simple.firstname.click();
			Reg_Simple.firstname.sendKeys(UtilitiesWeb.Randomname(4));
			Reg_Simple.lastName.click();
			Reg_Simple.lastName.sendKeys(UtilitiesWeb.Randomname(3));
			Reg_Simple.email.click();
			Reg_Simple.email.sendKeys(UtilitiesWeb.generateEmailid());
			Reg_Simple.Register_button.click();	
			Events_Reg_Tabbed_Page reg3=new Events_Reg_Tabbed_Page(driver);
			UtilitiesWeb.wait_until_element_is_visible(reg3.success_message, 10);
			String success_msg=reg3.success_message.getText();
			System.out.println(success_msg);
			}}
			
			
	  
			
		public static void FormCreation(String Type) {
			
			Form_Page formpage= new Form_Page(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions action = new Actions(driver);
			formpage.applauncher.click();
			formpage.searchBar.click();
			formpage.searchBar.sendKeys("Forms");
			formpage.Forms.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			formpage.form_new.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.wait_until_elememt_is_enable(formpage.form_save_button, 5);
			formpage.form_name.click();
			formpage.form_name.sendKeys(UtilitiesWeb.Randomname(5));
			formpage.form_type.click();
			if(Type.equalsIgnoreCase("Post-Registration"))
			{
				formpage.Post_registration.click();
			}
			else if(Type.equalsIgnoreCase("Survey"))
			{
				formpage.Survey.click();
			}
			
			else {
				formpage.Pre_registration.click();
			}
			formpage.form_save_button.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Creation of Form Element
			
			//Big List Group Element
//			formpage.Form_Element_type.click();
//			formpage.Big_List_Group.click();
//			UtilitiesWeb.waitForAwhile();
//			action.moveToElement(formpage.question_name).click().perform();
//			action.moveToElement(formpage.question_name).sendKeys("Big List Question?").perform();
//			formpage.Form_Element_Save.click();
			
			//Checkbox Element
			formpage.Form_Element_type.click();
			formpage.Checkbox.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Checkbox Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Date Element
			formpage.Form_Element_type.click();
			formpage.Date.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Date Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Divider Element
			formpage.Form_Element_type.click();
			formpage.Divider.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Divider Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Email Element
			formpage.Form_Element_type.click();
			formpage.Email.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Email Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//File Upload Element
			formpage.Form_Element_type.click();
			formpage.File_Upload.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("File Upload Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Hidden Element
			formpage.Form_Element_type.click();
			formpage.Hidden.click();
			UtilitiesWeb.waitForAwhile();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Multi-Select Picklist Element
			formpage.Form_Element_type.click();
			formpage.Multi_Select_Picklist.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Multi-Select Picklist Question?").perform();
			UtilitiesWeb.scrollToElementb(driver, formpage.question_name);
			formpage.Picklist_values.click();
			formpage.Picklist_values.sendKeys("a1\nb2\nc3\nd4\ne5");
			UtilitiesWeb.scrollTop(driver);
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Number Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.Number.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Number Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Parameter Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.Parameter.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Parameter Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Picklist Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.Picklist.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Picklist Question?").perform();
			UtilitiesWeb.scrollToElementb(driver, formpage.question_name);
			formpage.Picklist_values.click();
			formpage.Picklist_values.sendKeys("a1\nb2\nc3\nd4\ne5");
			UtilitiesWeb.scrollTop(driver);
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Text Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.Text.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Text Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//Text(30,000) Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.long_text.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("Text(30,000) Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
			
			//URL Element
			formpage.Form_Element_type.click();
			js.executeScript("arguments[0].scrollIntoView();", formpage.Multi_Select_Picklist);
			formpage.URL.click();
			UtilitiesWeb.waitForAwhile();
			action.moveToElement(formpage.question_name).click().perform();
			action.moveToElement(formpage.question_name).sendKeys("URL Question?").perform();
			formpage.Form_Element_Save.click();
			UtilitiesWeb.wait_until_the_page_is_loaded();
			UtilitiesWeb.waitForAwhile();
		}
		
			
		   

		
		
		}
		


		



		
			
		
		
		
		
		
		

