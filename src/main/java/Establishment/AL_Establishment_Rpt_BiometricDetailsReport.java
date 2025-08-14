package Establishment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Rpt_BiometricDetailsReport extends BaseClass
{
	public AL_Establishment_Rpt_BiometricDetailsReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(linkText = "Biometric details report") private WebElement biometricDetailsReport;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege") private WebElement collegeDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlStaff") private WebElement staffDropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnShow") private WebElement showButton;
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport") private WebElement reportButton;


	public AL_Establishment_Rpt_BiometricDetailsReport Click_BiometricDetailsReport() throws Exception {
		System.out.println("Click on Biometric details report");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", biometricDetailsReport);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", biometricDetailsReport);
		
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricDetailsReport Select_College() throws Exception {
		System.out.println("Select College ==> Crescent School of Architecture");
		Thread.sleep(2000);
		Select select = new Select(collegeDropdown);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricDetailsReport Select_StaffType() throws Exception {
		System.out.println("Select Staff Type ==> Teaching Staff");
		Thread.sleep(2000);
		Select select = new Select(staffDropdown);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricDetailsReport Select_FromDate() throws Exception {
		System.out.println("Select From Date ==> 29/07/2025");
		
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFdate")), "29/07/2025");

		return this;
	}
	
	
	public AL_Establishment_Rpt_BiometricDetailsReport Click_ShowButton() throws Exception {
		System.out.println("Click on Show Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", showButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", showButton);
		return this;
	}
	
	public AL_Establishment_Rpt_BiometricDetailsReport Click_ReportButton() throws Exception {
		System.out.println("Click on Report Button");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", reportButton);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", reportButton);
		
		return this;
	}
}
