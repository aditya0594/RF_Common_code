package RFCC_Extra;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class SectionEnrollmentNoAllotment extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void SectionEnrollmentNo_Allotment() throws Exception {

		RF_AdminLoginPage.loginPage();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.linkText("ACADEMIC"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		System.out.println("Click on Academic from Navigation Bar");
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.linkText("Post Admission"));
		action.moveToElement(subMenu);
		action.click().build().perform();
		System.out.println("Click on Post Admissiom option");
		Thread.sleep(2000); 
		
		WebElement link_sec = driver.findElement(By.linkText("Section/Enrollment No. Allotment"));
		link_sec.click();
		System.out.println("Click on Section/Enrollment No. Allotment from sub menu");

		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlInsName-container")).click();
		WebElement SchoolInstituteddl = driver.findElement(By.className("select2-search__field"));
		String SchoolInstituteText = "School of Computer Information and Mathematical Sciences";
		SchoolInstituteddl.sendKeys(SchoolInstituteText);
		System.out.println("Select School Institute: " + SchoolInstituteText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		WebElement Degreeddl = driver.findElement(By.className("select2-search__field"));
		String DegreeText = "Bachelor of Technology";
		Degreeddl.sendKeys(DegreeText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Degree: " + DegreeText);
 
		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		WebElement Branchddl = driver.findElement(By.className("select2-search__field"));
		String BranchText = "Computer Science and Engineering";
		Branchddl.sendKeys(BranchText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Branch: " + BranchText);

		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnFilter")).click();
		System.out.println("Click on Filter Button");

		Thread.sleep(2000);
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_lvStudents_ctrl0_ddlsec-container")).click();
		WebElement ClassSectionddl = driver.findElement(By.className("select2-search__field"));
		String ClassSectionText = "A";
		ClassSectionddl.sendKeys(ClassSectionText);
		driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
		System.out.println("Select Class Section: " + ClassSectionText);

		Thread.sleep(2000);
		WebElement RollNo1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl0_TextBox1"));
		String n = Keys.chord(Keys.CONTROL, "A");
		String RollNo1Text = "0603001";
		RollNo1.sendKeys(n, RollNo1Text);
		System.out.println("Enter Roll No.: " + RollNo1Text);

//		WebElement RollNo2= driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl1_TextBox1"));
//	    String RollNo2Text = "0403002";
//	    RollNo2.sendKeys(RollNo2Text);
//		System.out.println("Roll No Enter for Student 2: "+ RollNo2Text);
		
		Thread.sleep(2000);
		WebElement btn_submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		btn_submit.click();
		System.out.println("Click on Submit Button");
		Thread.sleep(5000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Updated Successfully!!!";
		String Actual_Msg =alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println("Actual and Expected Msg matched");
		Thread.sleep(2000);
		alert.accept();
	}

}
