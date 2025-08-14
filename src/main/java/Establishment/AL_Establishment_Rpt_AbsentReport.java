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

public class AL_Establishment_Rpt_AbsentReport extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_AbsentReport(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_AbsentReport click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport click_AbsentReport() throws InterruptedException {
		System.out.println(" Click On > Absent Report");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement ab_repo = driver.findElement(By.id("ctl00_repLinks_ctl12_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",ab_repo);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ab_repo);
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport select_College_name() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStaff']"));
		Select select = new Select(staff);
		select.selectByVisibleText("Teaching Staff");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport set_from_date() {
		System.out.println("Select From date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFdate")), "01/01/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport set_to_date() {
		System.out.println("Select To date ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]",driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDate")), "11/11/2024");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport select_report_type() {
		System.out.println("Select Report Type");
		WebElement tpe_repo=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlformat']"));
		Select select = new Select(tpe_repo);
		select.selectByVisibleText("Format 1");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport Select_search_type_check_btn() {
		System.out.println("Select Particular Employee ");
		WebElement perti_emp_ck = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblSelect_1"));
		click(perti_emp_ck);
		return this;
		
	}
	
	public AL_Establishment_Rpt_AbsentReport Select_employee() throws InterruptedException {
		System.out.println("Select Employee");
		WebElement emp_sel=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmployee"));
		Select select = new Select(emp_sel);
		Thread.sleep(2000);
		select.selectByValue("563");
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport Set_perticular_employee() throws InterruptedException {
		System.out.println("Set Perticular Employee info");
		Select_search_type_check_btn();
		Select_employee();
		return this;
	}
	
	public AL_Establishment_Rpt_AbsentReport Click_report_btn() {
		System.out.println("Click Report Button");
		WebElement repo_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnReport"));
		click(repo_btn);
		return this;
	}
}
