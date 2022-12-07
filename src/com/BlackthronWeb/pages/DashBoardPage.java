package com.BlackthronWeb.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Blackthron.web.utils.UtilitiesWeb;
import com.aventstack.extentreports.Status;


public class DashBoardPage extends BasePageWeb
{
	public DashBoardPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
