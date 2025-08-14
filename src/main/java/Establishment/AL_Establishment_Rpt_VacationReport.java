package Establishment;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Rpt_VacationReport extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
//	@FindBy(linkText = "Leave Status") private WebElement Leave_Status;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_VacationReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_VacationReport Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Click_vacation_report() throws InterruptedException {
		System.out.println(" Click On > Vacation_Report");

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement vac_repo = driver.findElement(By.id("ctl00_repLinks_ctl04_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",vac_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", vac_repo);
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Select_College() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStafftype']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Set_from_date() {
		System.out.println("Select From date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromDt")), "10/01/2022");
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Set_to_date() {
		System.out.println("Select To date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtToDt")), "15/11/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_VacationReport Click_show_report_btn() {
		System.out.println("Click Show Report Button");
		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowReport"));
		click(repo_btn);
		return this;
	}

}
