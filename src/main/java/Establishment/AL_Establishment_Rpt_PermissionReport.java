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


public class AL_Establishment_Rpt_PermissionReport extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_PermissionReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_PermissionReport Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Click_Permission_Report() throws InterruptedException {
		System.out.println(" Click On > Permission Report");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement per_repo = driver.findElement(By.id("ctl00_repLinks_ctl11_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",per_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", per_repo);
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Select_College() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlstafftype']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Set_from_date() {
		System.out.println("Select From date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFromdt")), "10/01/2022");
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Set_to_date() {
		System.out.println("Select To date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTodt")), "15/11/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_PermissionReport Click_report_btn() {
		System.out.println("Click Report Button");
		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(repo_btn);
		return this;
	}

}
