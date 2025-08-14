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

public class AL_Establishment_Rpt_ServiceBookExcel extends BaseClass
{
	@FindBy(linkText = "ESTABLISHMENT") private WebElement Establishment;
	@FindBy(linkText = "Reports") private WebElement Reports;
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public AL_Establishment_Rpt_ServiceBookExcel(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Click_ESTABLISHMENT() {
		System.out.println("Admin Establishment menu selected");
		Actions action = new Actions(driver); 
		action.moveToElement(Establishment).build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Click_REPORTS() {
		System.out.println("Admin Examination menu selected > Reports");
		Actions action = new Actions(driver);
		action.moveToElement(Reports).click().build().perform();
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Click_SeviceBookExcel() throws InterruptedException {
		System.out.println(" Click On > Sevice Book Excel");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement leave_r = driver.findElement(By.id("ctl00_repLinks_ctl10_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",leave_r);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", leave_r);
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Select_College_name() {
		System.out.println("Select College");
		WebElement clg=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlCollege']"));
		Select select = new Select(clg);
		select.selectByVisibleText("Crescent School of Architecture");
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Select_Stafff_Type() {
		System.out.println("Select Staff");
		WebElement staff=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlStaffType']"));
		Select select = new Select(staff);
		select.selectByValue("7");
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Select_seviceBookCategory() {
		System.out.println("Select sevice Book Category");
//		WebElement ser_book=driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlservicebook']"));
//		Select select = new Select(ser_book);
//		select.selectByVisibleText("  Select all");
		
		WebElement not = driver.findElement(By.xpath("//span[text()='None selected']"));
		not.click();
		WebElement sel = driver.findElement(By.xpath("//input[@class='form-control multiselect-search']"));
		sel.sendKeys("Select all");
		WebElement all = driver.findElement(By.xpath("//input[@value='multiselect-all']"));
		all.click();
		return this;
	}
	
	public AL_Establishment_Rpt_ServiceBookExcel Click_excel_Btn() {
		System.out.println("Click Excel button");
		WebElement ecxel_btn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExcelReport"));
		click(ecxel_btn);
		return this;
	}

}
