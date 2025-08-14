package Payroll;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Payroll_Trans_MW_SupplementaryBill extends BaseClass
{
	JavascriptExecutor js= (JavascriptExecutor)driver;

	public AL_Payroll_Trans_MW_SupplementaryBill(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill SupplementaryBill() throws InterruptedException {
		System.out.println("Click Supplementary Bill ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement supple = driver.findElement(By.id("ctl00_repLinks_ctl09_lbLink"));
		js.executeScript("arguments[0].scrollIntoView();",supple);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", supple);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Click_AddNew_btn() {
		System.out.println("Click on Add New Button");
		WebElement addnew=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd"));
		click(addnew);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Select_SupliBillDate() throws InterruptedException {
		
		WebElement billDate=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSupliBillDate"));

//		Random random = new Random();
//		int number = random.nextInt(1,29);
//		int number1 = random.nextInt(1,9);
//		int number2 = random.nextInt(2010,2050);
//		String RanName = number+"/0"+number1+"/"+number2;
//		billDate.sendKeys(String.valueOf(RanName));
//		System.out.println("Select Supli.Bill Date "+RanName);
//		return this;

		Random random = new Random();
		int number = random.nextInt(29 - 1) + 1;       // 1 to 28
		int number1 = random.nextInt(9 - 1) + 1;       // 1 to 8
		int number2 = random.nextInt(2050 - 2010) + 2010; // 2010 to 2049
		String RanName = number + "/0" + number1 + "/" + number2;
		billDate.sendKeys(String.valueOf(RanName));
		System.out.println("Select Supli.Bill Date " + RanName);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Select_PayHead() {
		System.out.println("Select PayHead => DA");
		WebElement payHead = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSupliBillHead"));
		Select select = new Select(payHead);
		select.selectByVisibleText("DA");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Enter_OrderNo() {
		
		WebElement odrNo=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtOrderNo"));
		Random random = new Random();

		int number = random.nextInt(9000 - 1000) + 1000; // 1000 to 8999
		int RanName = number;
		odrNo.sendKeys(String.valueOf(RanName));
		System.out.println("Enter Order No." + RanName);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Select_EmpName() {
		System.out.println("Select Emp Name => VENKATESAN  MURTHY [58]");
		WebElement payHead = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmpName"));
		Select select = new Select(payHead);
		select.selectByValue("58");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Enter_BasicPay() {
		System.out.println("Enter Basic Pay");
		WebElement basicPay=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtSupliPay"));
		clearText(basicPay);
		sendKeys(basicPay, "20000");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Enter_GradePay() {
		System.out.println("Enter Grade Pay");
		WebElement grdpay=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtGradePay"));
		clearText(grdpay);
		sendKeys(grdpay, "5000");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Enter_Remark() {
		System.out.println("Enter Remark");
		WebElement remark=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRemark"));
		clearText(remark);
		sendKeys(remark, "automation test");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Enter_Percentage() {
		System.out.println("Enter Percentage");
		WebElement percent=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPersentage"));
		clearText(percent);
		sendKeys(percent, "15");
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Click_Calculate_btn() {
		System.out.println("Caculate btn");
		WebElement calculate=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPersentage"));
		click(calculate);
		return this;
	}
	
	public AL_Payroll_Trans_MW_SupplementaryBill Click_Submit_btn() throws InterruptedException {
		System.out.println("Click Submit btn ");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit"));
		js.executeScript("arguments[0].scrollIntoView();",submit);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submit);
		return this;
	}
}
