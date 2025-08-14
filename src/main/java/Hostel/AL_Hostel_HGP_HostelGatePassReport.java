package Hostel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BaseClass;

public class AL_Hostel_HGP_HostelGatePassReport extends BaseClass
{
	@FindBy(linkText = "Hostel Gate Pass Report") private WebElement hostelgatepassreport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")private WebElement submitreport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtFromDate")private WebElement fromdate;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtToDate")private WebElement todate;
	
	
	public AL_Hostel_HGP_HostelGatePassReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	

	public AL_Hostel_HGP_HostelGatePassReport Click_HostelGatePassReport() {
		System.out.println("Click On Hostel Gate Pass Report");
		Actions action = new Actions(driver);
		action.moveToElement(hostelgatepassreport).perform();
		hostelgatepassreport.click();
		// action.moveToElement(subMenu).click();
		return this;
	}
	
	public AL_Hostel_HGP_HostelGatePassReport FromDate() {
		System.out.println("From Date => 30/05/2024");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",fromdate,"30/05/2024");
		return this;
	}
	
	public AL_Hostel_HGP_HostelGatePassReport ToDate() {
		System.out.println("To Date => 01/31/2027");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",todate, "31/12/2027");
		return this;
	}
	
	
	public AL_Hostel_HGP_HostelGatePassReport submitReport() {
		System.out.println("Click on submitReport");
		click(submitreport);
		return this;
	}
}
