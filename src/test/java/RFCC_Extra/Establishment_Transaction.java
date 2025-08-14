package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Establishment_Transaction  extends  BaseClass{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test :" + m.getName()+ "*****" + "\n");
	}
	
	@Test
	public void Employee_Service_Book() throws Exception 
	{
		test=reports.createTest("Employee_Service_Book");
		

		RF_AdminLoginPage.loginPage();
		
		System.out.println("Admin Logged in Successfully");
		
		Thread.sleep(2000);
		//Click Main Establishment Menu		
		WebElement Estab = driver.findElement(By.linkText(""));
		System.out.println("Establishment menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(Estab).perform();
		
		Thread.sleep(2000); 
		// Locating the element from Sub Menu
		WebElement Estab_TransSubMenu = driver.findElement(By.linkText(""));
		System.out.println("Establisment Transaction submenu selected");
	    action.moveToElement(Estab_TransSubMenu);
	    action.click().build().perform();
	    
		/*
		 * Thread.sleep(2000); //Click Employee Service Book Page WebElement
		 * Employee_srv =
		 * driver.findElement(By.id("ctl00_ctl00_repLinks_ctl00_lbLink"));
		 * System.out.println("Click on Employee service book"); Employee_srv.click();
		 * Thread.sleep(1000);
		 */
		
		System.out.println("Click on Order By");
		WebElement OrdBy_select = driver.findElement(By.id("ctl00_ctl00_ContentPlaceHolder1_ddlorderby"));
		Thread.sleep(2000);
		Select ordBy_sel = new Select(OrdBy_select);
		ordBy_sel.selectByValue("2");
		System.out.println("Ordered By Name Selected");
		Thread.sleep(2000);
		// Note:No data in EmployeeName Dropdown

		System.out.println("click on Assign Default shift");
		driver.findElement(By.linkText("Assign Default Shift")).click();
		Thread.sleep(2000);

		System.out.println("select College Name");
		WebElement college_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCollege"));
		Thread.sleep(2000);
		Select colg_sel = new Select(college_select);
		colg_sel.selectByVisibleText("Crescent School of Architecture");
		System.out.println("Crescent School of Architecture Selected");
		Thread.sleep(2000);

		System.out.println("select Staff type");
		WebElement staff_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStafftype"));
		Thread.sleep(2000);
		Select staff_sel = new Select(staff_select);
		staff_sel.selectByVisibleText("Technical NTS");
		System.out.println("Technical NTS Staff Selected");
		Thread.sleep(2000);

		System.out.println("Select Atleast One employee");
		WebElement sel_employee = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvEmpList_ctrl0_chkID"));
		sel_employee.click();

		System.out.println("select Shift");
		WebElement Shift_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlShift"));
		Thread.sleep(2000);
		Select Shift_sel = new Select(Shift_select);
		Thread.sleep(2000);
		Shift_sel.selectByValue("2");
		System.out.println("NIGHT SHIFT Selected");

//				 System.out.println("select Department");
//				  WebElement Depart_select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDept"));
//				  Thread.sleep(2000);
//				  Select Depart_sel = new Select(Depart_select); 
//				  Depart_sel.selectByVisibleText("COMP. ENGG");
//				  System.out.println("COMP. ENGG Department Selected");
//				  Thread.sleep(2000);
//				 
		System.out.println("Click on Assign button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
				  
		 
	}
}
