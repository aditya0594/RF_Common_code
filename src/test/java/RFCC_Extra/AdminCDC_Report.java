package RFCC_Extra;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

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

public class AdminCDC_Report  extends BaseClass{
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
	public void CDC_Report() throws Exception 
	{
		test=reports.createTest("CDC_Report");
		Thread.sleep(2000);
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		
		System.out.println("CDC -> Reports -> Student Placement Report");
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu\"]/ul/li[4]/a"));
		System.out.println("Main CDC menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		//Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"ctl00_mainMenu:submenu:77\"]/li[3]/a"));
		System.out.println("Report submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		Thread.sleep(2000);
		WebElement sel_criteria = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCriteria"));
		Select sel_Criteria_typ = new Select(sel_criteria);
		sel_Criteria_typ.selectByVisibleText("IQAC");
		System.out.println("IQAC selected");
		
		System.out.println("Click on Report");
		WebElement repot = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExcel"));
		repot.click();
//		Thread.sleep(2000);
//		((WebDriver) repot).close();
		Thread.sleep(2000);
		System.out.println("Student Placement Report Generated successfully");
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
		System.out.println("Click on student category Report");
//		System.out.println("Click on Student Category Report");
		driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		Thread.sleep(1000);
		System.out.println("Select Application Category Type");
		WebElement app_categoryTyp = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlApplicationType"));
		Select AppCat_typ = new Select(app_categoryTyp);
		AppCat_typ.selectByVisibleText("Placement");
		System.out.println("Placement selected");
		
		System.out.println("Click on Report");
		WebElement repot2 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnTPreport"));
		repot2.click();
		Thread.sleep(2000);
		System.out.println("T&P Category Report Generated successfully");
	}

}
