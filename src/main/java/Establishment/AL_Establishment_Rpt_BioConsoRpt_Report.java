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

public class AL_Establishment_Rpt_BioConsoRpt_Report extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_BioConsoRpt_Report(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Click_BiometricConsolidateReport() throws InterruptedException {
		System.out.println(" Click On > Biometric Consolidate Report");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement bio_con_repo = driver.findElement(By.id("ctl00_repLinks_ctl07_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",bio_con_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", bio_con_repo);
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Select_College_name() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStaffType']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Set_from_date() {
		System.out.println("Select From date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFdate")), "01/01/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Set_to_date() {
		System.out.println("Select To date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDate")), "11/11/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Click_report_btn() {
		System.out.println("Click Report Button");
		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(repo_btn);
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Select_employee() throws InterruptedException {
		System.out.println("Select Employee");
		WebElement emp_sel=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmp"));
		Select select = new Select(emp_sel);
		Thread.sleep(2000);
		select.selectByValue("548");
		return this;
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report Select_perticular_employee_check_btn() {
		System.out.println("Set Particular Employee info");
		WebElement perti_emp_ck = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblAllParticular_1"));
		click(perti_emp_ck);
		return this;	
	}
	
	public AL_Establishment_Rpt_BioConsoRpt_Report set_perticular_employee_info() throws InterruptedException {
		Select_perticular_employee_check_btn();
		Select_employee();
		return this;
	}

}
