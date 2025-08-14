package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class ServiceRequestMang_Reports  extends  BaseClass {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n");
	}
	
	@Test
	public void ServicRequestManagement_report() throws Exception 
	{
		test=reports.createTest("Administration_ServiceManagement");
		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Admin Logged in Successfully");
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement adminTrans = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[10]/a"));
		System.out.println("Administration menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(adminTrans).perform();
		   Thread.sleep(2000);
		// Locating the element from Sub Menu
		WebElement Admin_ServiceRequestSubMenu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:122\"]/li[10]/a"));
		System.out.println("Administration Service Request Management submenu selected");
		action.moveToElement(Admin_ServiceRequestSubMenu).perform();
		   Thread.sleep(2000);
		   
		WebElement ServiceRequest_ReportSubMenu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:158\"]/li[3]/a"));
		System.out.println("Service Request Management Report submenu selected");
		action.moveToElement(ServiceRequest_ReportSubMenu);
		action.click().build().perform();
	    Thread.sleep(2000);  
	    
	    System.out.println("Click on show Report");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	    Thread.sleep(3000);
	    //Close the generated report
	    String parent= driver.getWindowHandle();
	    Set<String>s=driver.getWindowHandles();
	    Iterator<String> I1= s.iterator();
	    while(I1.hasNext())
	    {

	    String child_window=I1.next();
	    if(!parent.equals(child_window))
	    {
	    driver.switchTo().window(child_window);

	    System.out.println(driver.switchTo().window(child_window).getTitle());

	    driver.close();
	    }

	    }
	    //switch to the parent window
	    driver.switchTo().window(parent);
	    
	    System.out.println("Click on Service Status Report");
	    driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
	    
	    System.out.println("Click on show Report");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	    Thread.sleep(3000);
	    
	    String parent2= driver.getWindowHandle();
	    Set<String>s2=driver.getWindowHandles();
	    Iterator<String> I2= s.iterator();
//	    while(I2.hasNext())
//	    {
//
//	    String child_window=I2.next();
//	    if(!parent2.equals(child_window))
//	    {
//	    driver.switchTo().window(child_window);
//
//	    System.out.println(driver.switchTo().window(child_window).getTitle());
//
//	    driver.close();
//	    }
//
//	    }
	    //switch to the parent window
	    driver.switchTo().window(parent2);
	    
	}

}
