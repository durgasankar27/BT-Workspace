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
			}
		}
		
		public static void Registration(String  UI, String price) throws Exception {
			
			if(price.equalsIgnoreCase("free")) {
			Events_Reg_Tabbed_Page reg=new Events_Reg_Tabbed_Page(driver);
			//UtilitiesWeb.waitForAwhile();
			reg.reg_button.click();
			reg.listbox.click();
			if(UI=="Tabbed")
			{
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
			else if(UI=="FullWidth")
			{
			//	System.out.println("0 Tickets are selected");
			}
			else if(UI=="Simple")
			{
//				reg.Second_ticket.click();
				
//				    reg.first_name1.click();
//					reg.first_name1.sendKeys(UtilitiesWeb.Randomname(6));
//					reg.last_name1.click();
//					reg.last_name1.sendKeys(UtilitiesWeb.Randomname(4));
//					reg.email1.click();
//					reg.email1.sendKeys(UtilitiesWeb.generateEmailid());
//					UtilitiesWeb.scroll_to_particular_element(reg.first_name2);
//					reg.first_name2.click();
//					reg.first_name2.sendKeys(UtilitiesWeb.Randomname(6));
//					reg.last_name2.click();
//					reg.last_name2.sendKeys(UtilitiesWeb.Randomname(4));
//					reg.email2.click();
//					reg.email2.sendKeys(UtilitiesWeb.generateEmailid());
//					UtilitiesWeb.scrollTop(driver);
//					Thread.sleep(2000);
//					reg.regbutton.click();
//					Thread.sleep(2000);
//					reg.regbutton.click();
//					String success_msg=reg.success_message.getText();
//					System.out.println(success_msg);
//					UtilitiesWeb.wait_until_element_is_visible(reg.Done_button,4);
//					reg.Done_button.clear();
			}
			else {
				System.out.println("No Tickets are selected");
			}
			
			reg.register_button.click();
			}
			else {
				
				
				
			}
			
		   

		
		
		}}
		


		



		
			
		
		
		
		
		
		

