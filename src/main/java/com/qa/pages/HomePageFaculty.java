package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class HomePageFaculty extends BaseClass{

	public HomePageFaculty(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;
	
	@FindBy(linkText = "E- Learning") private WebElement ELEARNING;                           
	@FindBy(linkText = "Transactions") private WebElement Elearn_Transactions;
	

	public HomePageFaculty ELEARNING() {
		action = new Actions(driver);
		System.out.println("Click on E- Learning");
		action.moveToElement(ELEARNING).perform();
		return this;
	}

	public HomePageFaculty Elearning_Trans() {
		action = new Actions(driver);
		System.out.println("Click on Transactions");
		action.moveToElement(Elearn_Transactions);
		action.click().build().perform();
		return this;
	}
	
	


}
