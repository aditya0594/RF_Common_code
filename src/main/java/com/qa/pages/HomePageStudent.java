package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class HomePageStudent extends BaseClass{

	public HomePageStudent(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	Actions action;
	
	@FindBy(linkText = "E- Learning") private WebElement ELEARNING;
	@FindBy(linkText = "Transactions") private WebElement Elearn_Transactions;
	@FindBy(linkText = "View") private WebElement Elearn_view;

	public HomePageStudent ELEARNING() {
		action = new Actions(driver);
		System.out.println("Click on E- LEARNING");
		action.moveToElement(ELEARNING).perform();
		return this;
	}

	public HomePageStudent Elearning_Trans() {
		action = new Actions(driver);
		System.out.println("Click on Transactions");
		action.moveToElement(Elearn_Transactions);
		action.click().build().perform();
		return this;
	}
	public HomePageStudent Elearning_View() {
		action = new Actions(driver);
		System.out.println("Click on View");
		action.moveToElement(Elearn_view);
		action.click().build().perform();
		return this;
	}
	
}
