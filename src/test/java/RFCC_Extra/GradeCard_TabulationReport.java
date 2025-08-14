package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

@Test
public class GradeCard_TabulationReport extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	// public static WebDriver driver;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "****** Starting Test : " + m.getName() + "*******" + "\n");
	}

	@Test
	public void GradeCard_TR() throws Exception {

		test = reports.createTest("url_RF_LoginAdmin");
		RF_AdminLoginPage.loginPage();

		WebElement ele = driver.findElement(By.linkText("EXAMINATION"));
		System.out.println("Main Examination menu selected");
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);

		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Examination Reports"));
		System.out.println("Examination Report submenu selected");
		action.moveToElement(subMenu);
		action.click().build().perform();
		Thread.sleep(2000);

		System.out.println("click on Grade Card/Tabulation Report");
		WebElement GR_TR_btn = driver.findElement(By.linkText("Grade Card /Tabulation Reports"));
		GR_TR_btn.click();
		Thread.sleep(2000);

		System.out.println("Select College and Scheme");
		Select school = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClgname")));
		school.selectByVisibleText("SMS - B.Tech.-Mechanical Engineering-2017-18-Department of Mechanical Engineering (Old Scheme)");
		Thread.sleep(2000);
//		WebElement school_opt = school.getFirstSelectedOption();
//		Thread.sleep(1000);
//		String school_opt_name = school_opt.getText();
//		System.out.println(school_opt_name);
//		Thread.sleep(2000);

		System.out.println("Select Session");
		Select session = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSession")));
		session.selectByVisibleText("May 2022");
		WebElement sessn_opt = session.getFirstSelectedOption();
		String sessn_opt_name = sessn_opt.getText();
		System.out.println(sessn_opt_name);
		Thread.sleep(2000);

		System.out.println("Select Semester");
		Select semester = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSemester")));
		semester.selectByVisibleText("IV");
		WebElement sem_opt = semester.getFirstSelectedOption();
		String sem_opt_name = sem_opt.getText();
		System.out.println(sem_opt_name);
		Thread.sleep(2000);

		System.out.println("Select Student Type");
		Select student_typ = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStuType")));
		student_typ.selectByVisibleText("Regular");
		WebElement student_typ_opt = student_typ.getFirstSelectedOption();
		String student_typ_opt_name = student_typ_opt.getText();
		System.out.println(student_typ_opt_name);
		Thread.sleep(2000);

		System.out.println("Enter Date of Publish");
		WebElement date_publish = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfIssue"));
		date_publish.sendKeys("06/03/2024");
		Thread.sleep(3000);

		System.out.println("Enter Date of Issue");
		WebElement date_issue = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfPublish"));
		date_issue.sendKeys("11/03/2024");
		Thread.sleep(3000);

		System.out.println("Enter Date of Convocation");
		WebElement txt_print  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtprint"));
		txt_print.sendKeys("10/03/2024");
		Thread.sleep(3000);

		System.out.println("Click on Show Student button");
		WebElement show_stud = driver.findElement(By.id("ctl00_ContentPlaceHolder1_showstudents"));
		show_stud.click();
		Thread.sleep(1000);

		System.out.println("Select students from student list");
		WebElement chk_studlist = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudent_chkheader"));
		chk_studlist.click();
		Thread.sleep(2000);

		System.out.println("Click on Grade Card Button");
		WebElement btn_grade = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGradeCard"));
		btn_grade.click();
		Thread.sleep(2000);

		System.out.println("Click on Consolidated report(B4 Size)");
		WebElement btn_consoli = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConsoli"));
		btn_consoli.click();
		Thread.sleep(2000);

		System.out.println("Click on Consolidated report(A4 Size)");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConsoliA4")).click();
		Thread.sleep(3000);
//		String s1 = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is:" +s1);
//		

		System.out.println("Click on Grade Card without Header");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGradeCardHeader")).click();
		Thread.sleep(3000);
//		TakesScreenshot scrShot =((TakesScreenshot)driver);
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//		File DestFile=new File("C:\\Automation\\PratikshaAutomation\\cresentscreenshot.jpg");
//		// FileUtils.copyFile(SrcFile, DestFile);
//		System.out.println("ScreenShot take successfully");

//		String parent= driver.getWindowHandle();
//		Set<String>s=driver.getWindowHandles();
//		Iterator<String> I1= s.iterator();
//		while(I1.hasNext())
//		{
//		String child_window=I1.next();
//		if(!parent.equals(child_window))
//		{
//		driver.switchTo().window(child_window);
//
//		System.out.println(driver.switchTo().window(child_window).getTitle());
//
//		driver.close();
//		}
//		}
//		//switch to the parent window
//		driver.switchTo().window(parent);
//		Thread.sleep(3000);
//		
//		
//		System.out.println("Click on TR Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnResultStatement")).click();
//		Thread.sleep(2000);
//		String parent1= driver.getWindowHandle();
//		Set<String>ss=driver.getWindowHandles();
//		Iterator<String> II1= ss.iterator();
//		while(II1.hasNext())
//		{
//		String child_window1=II1.next();
//		if(!parent1.equals(child_window1))
//		{
//		driver.switchTo().window(child_window1);
//		System.out.println(driver.switchTo().window(child_window1).getTitle());
//		driver.close();
//		}
//		}
//		//switch to the parent window
//		driver.switchTo().window(parent1);
//		Thread.sleep(3000);
//		
//		System.out.println("Click on Result Report in Excel");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnResultExcel")).click();
//		Thread.sleep(3000);
//		
//		System.out.println("Click on Overall Backlog Report in Excel");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBacklogExcel")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
//		
//		System.out.println("Click on TR Report Excel");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnTRExcel")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Click on Format-II Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btncoursegrade")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Click on Grade Range Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btngraderange")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Click on Format-II Excel Report Excel");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExcel")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Click on Exam fees paid Excel Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnExamFeesPaid")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Click on Convocation Excel Report");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnConvocationExcelReport")).click();
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		
//		System.out.println("Click on Serial Number");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSRNo")).click();
//		Thread.sleep(2000);
//		
//		System.out.println("Enter Date of Convocation");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtprint")).sendKeys("14-02-2024");
//		Thread.sleep(2000);
//		System.out.println("Click on Degree Certificate");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCertificate")).click();
//		Thread.sleep(2000);
	}
}
